package com.bozhong.insistapi.pipeline;

import com.bozhong.common.util.CollectionUtil;
import com.bozhong.common.util.StringUtil;
import com.bozhong.config.util.CookiesUtil;
import com.bozhong.insistapi.common.InsistApiConstants;
import com.bozhong.insistapi.common.WebSettingParam;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.bozhong.myredis.MyRedisClusterForHessian;
import com.yx.eweb.main.PipeLineInter;
import org.apache.log4j.Logger;

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

    public static final String pattern = "^[\\w\\W]*/rest/mock/[\\w\\W]*$";

    private MyRedisClusterForHessian myRedisClusterForHessian;

    private static final Logger logger = Logger.getLogger(SecurityPipeLine.class);

    @Override
    public boolean run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.warn("SecurityPipeLine has execute ! ");
        httpServletRequest.setAttribute("html_title", WebSettingParam.HTML_TITLE);
        httpServletRequest.setAttribute("switch_crop", WebSettingParam.CORP);
        httpServletRequest.setAttribute("switch_department", WebSettingParam.DEPARTMENT);
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
            httpServletRequest.setAttribute("uId", uId);
            try {
                List<AppDO> appDOList = DocHttpUtil.getAppDOList(uId);
                httpServletRequest.setAttribute("appDOList", appDOList);
                Map<String, String> appDOMap = new HashMap<>();
                if (!CollectionUtil.isEmpty(appDOList)) {
                    for (AppDO appDO : appDOList) {
                        appDOMap.put(appDO.getAppId(), appDO.getAppName());
                    }
                }
                httpServletRequest.setAttribute("appDOMap", appDOMap);
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
