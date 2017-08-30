package com.bozhong.insistapi.pipeline;

import com.bozhong.common.util.CollectionUtil;
import com.bozhong.common.util.StringUtil;
import com.bozhong.config.util.CookiesUtil;
import com.bozhong.insistapi.common.InsistApiConstants;
import com.bozhong.insistapi.common.WebSettingParam;
import com.bozhong.insistapi.entity.AccessEntity;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.bozhong.myredis.MyRedisClusterForHessian;
import com.yx.eweb.main.PipeLineInter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by xiezg@317hu.com on 2017/4/25 0025.
 */
public class SecurityPipeLine implements PipeLineInter {

    public static final String pattern = "^[\\w\\W]*/rest/httpMock/[\\w\\W]*$";

    private MyRedisClusterForHessian myRedisClusterForHessian;

    @Autowired
    private MongoService mongoService;

    private static final Logger logger = Logger.getLogger(SecurityPipeLine.class);

    @Override
    public boolean run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.warn("SecurityPipeLine has execute ! ");
        httpServletRequest.setAttribute("html_title", WebSettingParam.HTML_TITLE);
        httpServletRequest.setAttribute("insist_api_crop", WebSettingParam.CORP);
        httpServletRequest.setAttribute("insist_api_department", WebSettingParam.DEPARTMENT);
        httpServletRequest.setAttribute("normal_url", WebSettingParam.NORMAL_URL);
        httpServletRequest.setAttribute("exception_url", WebSettingParam.EXCEPTION_URL);
        httpServletRequest.setAttribute("interface_url", WebSettingParam.INTERFACE_URL);
        Cookie tokenCookie = CookiesUtil.getCookieByName(httpServletRequest, "insist_api_token");
        if (tokenCookie == null) {
            try {
                //动态链接调用过滤
                boolean isMatch = Pattern.matches(pattern, httpServletRequest.getRequestURL());
                if (isMatch) {
                    return true;
                }

                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
                        "/admin/login.htm");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }

        String token = tokenCookie.getValue();
        String uId = myRedisClusterForHessian.getForStr(InsistApiConstants.INSIST_CENTER_USERNAME_PREFIX + token);
        if (StringUtil.isNotBlank(uId)) {
            try {
                synchronized (uId) {
                    if (mongoService.findOneByAccessName(uId, AccessEntity.class) == null) {
                        AccessEntity accessEntity = new AccessEntity();
                        accessEntity.setAccessName(uId);
                        accessEntity.setAccessCount(1l);
                        mongoService.insertOne(accessEntity);
                    } else {
                        mongoService.findOneAndUpdateByAccessName(uId, AccessEntity.class);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            httpServletRequest.setAttribute("uId", uId);
            try {
                List<AppDO> appDOList = null;
                try {
                    appDOList = DocHttpUtil.getAppDOList(uId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                httpServletRequest.setAttribute("appDOList", appDOList);
                Map<String, String> appDOMap = new HashMap<>();
                if (!CollectionUtil.isEmpty(appDOList)) {
                    for (AppDO appDO : appDOList) {
                        appDOMap.put(appDO.getAppId(), appDO.getAppName());
                    }
                }
                httpServletRequest.setAttribute("appDOMap", appDOMap);
                if (!StringUtils.isEmpty(httpServletRequest.getParameter("appId")) &&
                        !appDOMap.keySet().contains(httpServletRequest.getParameter("appId"))) {
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
                            "/admin/login.htm");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }

        try {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +
                    "/admin/login.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void setMyRedisClusterForHessian(MyRedisClusterForHessian myRedisClusterForHessian) {
        this.myRedisClusterForHessian = myRedisClusterForHessian;
    }
}
