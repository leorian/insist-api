package com.bozhong.insistapi.restful;

import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InsistApiOperationEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/8/24 0024.
 */
@Controller
@Singleton
@Path("logger")
public class LoggerRest {

    @Autowired
    private MongoService mongoService;

    /**
     * 操作日志分页查询
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @return
     */
    @POST
    @Path("loggerPager")
    public String loggerPager(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String appIdInput = (String) param.get("appIdInput");
        String loggerContentInput = (String) param.get("loggerContentInput");
        String callBack = param.get("callback").toString();
        Integer page = Integer.valueOf(param.get("page").toString());
        Integer rows = Integer.valueOf(param.get("rows").toString());
        Gson gson = new Gson();
        JqPage<InsistApiOperationEntity> jqPage = new JqPage<InsistApiOperationEntity>();
        jqPage.setPage(page);
        jqPage.setPageSize(rows);
        jqPage = mongoService.getJqPageByCondition(appIdInput, loggerContentInput, jqPage, InsistApiOperationEntity.class);
        return callBack + "(" + gson.toJson(jqPage) + ")";
    }

    /**
     * 查询日志
     *
     * @return
     */
    @POST
    @Path("findOneLogger")
    public String findOneLogger() {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String loggerId = (String) param.get("loggerId");
        InsistApiOperationEntity insistApiOperationEntity = mongoService.findOneByLoggerId(loggerId, InsistApiOperationEntity.class);
        return ResultMessageBuilder.build(insistApiOperationEntity).toJSONString();
    }

    /**
     * 操作记录统计
     *
     * @return
     */
    @POST
    @Path("operatorCountMap")
    public String operatorCountMap() {
        Map<String, Integer> map = mongoService.operatorCountMap(InsistApiOperationEntity.class);
        return ResultMessageBuilder.build(map).toJSONString();
    }

    /**
     * 应用接口数统计
     *
     * @return
     */
    @POST
    @Path("appCountMap")
    public String appCountMap() {
        Map<String, Integer> map = mongoService.appInterfaceCountGroup(InterfaceHttpEntity.class);
        Map<String, Integer> appCountMap = new HashMap<>();
        try {
            List<AppDO> list = DocHttpUtil.getAllAppDOList();
            if (!CollectionUtils.isEmpty(list)) {
                for (AppDO appDO : list) {
                    appCountMap.put(appDO.getAppName(), map.get(appDO.getAppId()) == null ? 0 : map.get(appDO.getAppId()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResultMessageBuilder.build(appCountMap).toJSONString();
    }
}
