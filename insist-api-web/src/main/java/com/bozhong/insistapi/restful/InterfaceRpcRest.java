package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.domain.InterfaceRpcDomain;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
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
@Path("interfaceRpc")
public class InterfaceRpcRest {

    @Autowired
    private MongoService mongoService;

    @POST
    @Path("insertInterfaceRpc")
    public String insertInterfaceRpc(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        InterfaceRpcDomain httpDomain = new InterfaceRpcDomain();
        try {
            BeanUtils.copyProperties(httpDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(httpDomain));

        InterfaceRpcEntity interfaceRpcEntity = httpDomain.buildInterfaceRpcEntity();
        interfaceRpcEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceRpcEntity.getId()));
        interfaceRpcEntity.setInterfaceParamResponseEntities(httpDomain.
                buildInterfaceParamResponseEntities(interfaceRpcEntity.getId()));
        interfaceRpcEntity.setInterfaceResultEntities(httpDomain.
                buildInterfaceResultEntities(interfaceRpcEntity.getId()));

        mongoService.insertOne(interfaceRpcEntity);

        return ResultMessageBuilder.build().toJSONString();
    }

    @POST
    @Path("findInterfaceRpcList")
    public String findInterfaceRpcList(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String appId = (String) param.get("appId");
        String category = (String) param.get("category");
        if (StringUtil.isNotBlank(category)) {
            return JSON.toJSONString(mongoService.getListByAppIdAndCategory(appId, category, InterfaceRpcEntity.class));
        } else {
            return JSON.toJSONString(mongoService.getListByAppId(appId, InterfaceRpcEntity.class));
        }
    }

    @POST
    @Path("findInterfaceRpc")
    public String findInterfaceRpc(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceId");
        return JSON.toJSONString(mongoService.getOneByInterfaceId(interfaceId, InterfaceRpcEntity.class));
    }

    @POST
    @Path("updateInterfaceRpc")
    public String updateInterfaceRpc(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceRpcIdInput");
        InterfaceRpcDomain httpDomain = new InterfaceRpcDomain();
        try {
            BeanUtils.copyProperties(httpDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(httpDomain));

        InterfaceRpcEntity interfaceRpcEntity = httpDomain.buildInterfaceRpcEntity();
        interfaceRpcEntity.setId(interfaceId);
        interfaceRpcEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceRpcEntity.getId()));
        interfaceRpcEntity.setInterfaceParamResponseEntities(httpDomain.
                buildInterfaceParamResponseEntities(interfaceRpcEntity.getId()));
        interfaceRpcEntity.setInterfaceResultEntities(httpDomain.
                buildInterfaceResultEntities(interfaceRpcEntity.getId()));

        mongoService.updateOneByKey(interfaceId, interfaceRpcEntity);

        return ResultMessageBuilder.build().toJSONString();
    }

    @POST
    @Path("deleteInterfaceRpc")
    public String deleteInterfaceRpc(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceId");
        mongoService.deleteOneByKey(interfaceId, InterfaceRpcEntity.class);
        return ResultMessageBuilder.build().toJSONString();
    }
}
