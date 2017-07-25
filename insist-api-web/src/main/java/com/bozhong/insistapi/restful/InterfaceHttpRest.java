package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.insistapi.domain.InterfaceHttpDomain;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.service.MongoService;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/21 0021.
 */
@Controller
@Singleton
@Path("interfaceHttp")
public class InterfaceHttpRest {

    @Autowired
    private MongoService mongoService;

    @POST
    @Path("insertInterfaceHttp")
    public String insertInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        InterfaceHttpDomain httpDomain = new InterfaceHttpDomain();
        try {
            BeanUtils.copyProperties(httpDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(httpDomain));

        InterfaceHttpEntity interfaceHttpEntity = httpDomain.buildInterfaceHttpEntity();
        interfaceHttpEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceHttpEntity.getId()));
        interfaceHttpEntity.setInterfaceResultEntities(httpDomain.
                buildInterfaceResultEntities(interfaceHttpEntity.getId()));

        mongoService.insertOne(interfaceHttpEntity);

        return ResultMessageBuilder.build().toJSONString();
    }

    @POST
    @Path("findInterfaceHttpList")
    public String findInterfaceHttpList(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String appId = (String) param.get("appId");
        return JSON.toJSONString(mongoService.getListByAppId(appId, InterfaceHttpEntity.class));
    }

    @POST
    @Path("findInterfaceHttp")
    public String findInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceId");
        return JSON.toJSONString(mongoService.getOneByInterfaceId(interfaceId, InterfaceHttpEntity.class));
    }

    @POST
    @Path("updateInterfaceHttp")
    public String updateInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceHttpIdInput");
        InterfaceHttpDomain httpDomain = new InterfaceHttpDomain();
        try {
            BeanUtils.copyProperties(httpDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(httpDomain));

        InterfaceHttpEntity interfaceHttpEntity = httpDomain.buildInterfaceHttpEntity();
        interfaceHttpEntity.setId(interfaceId);
        interfaceHttpEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceHttpEntity.getId()));
        interfaceHttpEntity.setInterfaceResultEntities(httpDomain.
                buildInterfaceResultEntities(interfaceHttpEntity.getId()));

        mongoService.updateOneByKey(interfaceId, interfaceHttpEntity);

        return ResultMessageBuilder.build().toJSONString();
    }

    @POST
    @Path("deleteInterfaceHttp")
    public String deleteInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceId");
        mongoService.deleteOneByKey(interfaceId, InterfaceHttpEntity.class);
        return ResultMessageBuilder.build().toJSONString();
    }
}
