package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.domain.HttpAddressDomain;
import com.bozhong.insistapi.domain.InterfaceHttpDomain;
import com.bozhong.insistapi.entity.HttpAddressEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.service.MongoService;
import com.sun.jersey.spi.resource.Singleton;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
    @Path("findHttpAddressDomain")
    public String findHttpAddressDomain(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String appId = (String) param.get("appId");
        HttpAddressEntity httpAddressEntity = mongoService.findOneByAppId(appId, HttpAddressEntity.class);
        if (httpAddressEntity == null) {
            httpAddressEntity = new HttpAddressEntity();
            httpAddressEntity.setAppId(appId);
        }
        return ResultMessageBuilder.build(httpAddressEntity).toJSONString();
    }

    @POST
    @Path("saveOrUpdateHttpAddressDomain")
    public String saveOrUpdateHttpAddressDomain(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        HttpAddressDomain httpAddressDomain = new HttpAddressDomain();
        try {
            BeanUtils.copyProperties(httpAddressDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(httpAddressDomain));
        HttpAddressEntity httpAddressEntity = httpAddressDomain.buildHttpAddressEntity();
        if (mongoService.findOneByAppId(httpAddressEntity.getAppId(), HttpAddressEntity.class) != null) {
            mongoService.updateOneByAppId(httpAddressEntity.getAppId(), httpAddressEntity);
        } else {
            mongoService.insertOne(httpAddressEntity);
        }

        return ResultMessageBuilder.build().toJSONString();
    }

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
        //请求头部
        interfaceHttpEntity.setInterfaceParamHeaderEntities(httpDomain.
                buildInterfaceParamHeaderEntities(interfaceHttpEntity.getId()));
        //请求参数
        interfaceHttpEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceHttpEntity.getId()));
        //响应参数
        interfaceHttpEntity.setInterfaceParamResponseEntities(httpDomain.
                buildInterfaceParamResponseEntities(interfaceHttpEntity.getId()));
        //返回示例和异常示例
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
        List<InterfaceHttpEntity> interfaceHttpEntities = mongoService.getListByAppId(appId, InterfaceHttpEntity.class);
        HttpAddressEntity httpAddressEntity = mongoService.findOneByAppId(appId, HttpAddressEntity.class);
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                addressTranslate(interfaceHttpEntity, httpAddressEntity);
            }
        }
        return JSON.toJSONString(interfaceHttpEntities);
    }

    @POST
    @Path("findInterfaceHttp")
    public String findInterfaceHttp(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        Map<String, Object> param = ((EWebRequestDTO) EWebServletContext.getEWebContext().getParam()).getRequestParam();
        String interfaceId = (String) param.get("interfaceId");
        InterfaceHttpEntity interfaceHttpEntity = mongoService.getOneByInterfaceId(interfaceId, InterfaceHttpEntity.class);
        String appId = interfaceHttpEntity.getAppId();
        HttpAddressEntity httpAddressEntity = mongoService.findOneByAppId(appId, HttpAddressEntity.class);
        addressTranslate(interfaceHttpEntity, httpAddressEntity);
        return JSON.toJSONString(interfaceHttpEntity);
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
        //请求头部
        interfaceHttpEntity.setInterfaceParamHeaderEntities(httpDomain.
                buildInterfaceParamHeaderEntities(interfaceHttpEntity.getId()));
        //请求参数
        interfaceHttpEntity.setInterfaceParamEntities(httpDomain.
                buildInterfaceParamEntities(interfaceHttpEntity.getId()));
        //响应参数
        interfaceHttpEntity.setInterfaceParamResponseEntities(httpDomain.
                buildInterfaceParamResponseEntities(interfaceHttpEntity.getId()));
        //返回示例和异常示例
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

    /**
     * 地址变换
     *
     * @param interfaceHttpEntity
     */
    private void addressTranslate(InterfaceHttpEntity interfaceHttpEntity, HttpAddressEntity httpAddressEntity) {
        if (interfaceHttpEntity != null && httpAddressEntity != null) {

            //mock地址
            if (StringUtil.isBlank(interfaceHttpEntity.getMockAddress())
                    && StringUtil.isNotBlank(httpAddressEntity.getMockAddress()) &&
                    StringUtil.isNotBlank(interfaceHttpEntity.getAddress())) {
                interfaceHttpEntity.setMockAddress(httpAddressEntity.getMockAddress()
                        + httpAddressEntity.getAppId() + "/" + interfaceHttpEntity.getAddress());
            }

            //dev地址
            if (StringUtil.isBlank(interfaceHttpEntity.getDevAddress())
                    && StringUtil.isNotBlank(httpAddressEntity.getDevAddress()) &&
                    StringUtil.isNotBlank(interfaceHttpEntity.getAddress())) {
                interfaceHttpEntity.setDevAddress(httpAddressEntity.getDevAddress() + interfaceHttpEntity.getAddress());
            }

            //sit地址
            if (StringUtil.isBlank(interfaceHttpEntity.getSitAddress())
                    && StringUtil.isNotBlank(httpAddressEntity.getSitAddress()) &&
                    StringUtil.isNotBlank(interfaceHttpEntity.getAddress())) {
                interfaceHttpEntity.setSitAddress(httpAddressEntity.getSitAddress() + interfaceHttpEntity.getAddress());
            }

            //uat地址
            if (StringUtil.isBlank(interfaceHttpEntity.getUatAddress())
                    && StringUtil.isNotBlank(httpAddressEntity.getUatAddress()) &&
                    StringUtil.isNotBlank(interfaceHttpEntity.getAddress())) {
                interfaceHttpEntity.setUatAddress(httpAddressEntity.getUatAddress() + interfaceHttpEntity.getAddress());
            }

            //prd地址
            if (StringUtil.isBlank(interfaceHttpEntity.getPrdAddress())
                    && StringUtil.isNotBlank(httpAddressEntity.getPrdAddress()) &&
                    StringUtil.isNotBlank(interfaceHttpEntity.getAddress())) {
                interfaceHttpEntity.setPrdAddress(httpAddressEntity.getPrdAddress() + interfaceHttpEntity.getAddress());
            }


        }
    }
}
