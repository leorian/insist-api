package com.bozhong.insistapi.restful;

import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.entity.InsistApiOperationEntity;
import com.bozhong.insistapi.service.MongoService;
import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
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
}
