package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.common.InsistApiConstants;
import com.bozhong.insistapi.common.InsistApiErrorEnum;
import com.bozhong.insistapi.domain.AppInterfaceInfoDomain;
import com.bozhong.insistapi.entity.*;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.sun.jersey.spi.resource.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/8/2 0002.
 */
@Controller
@Singleton
@Path(InsistApiConstants.HTTP_MOCK)
public class MockRest {

    @Autowired
    private MongoService mongoService;


    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mockGETNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }

    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String mockPOSTNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }

    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @HEAD
    @Produces(MediaType.APPLICATION_JSON)
    public String mockHEADNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }

    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String mockPUTNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }


    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String mockDELETENormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }

    @Path("normal/{appId}/{mockAddress:[\\w\\W]*$}")
    @OPTIONS
    @Produces(MediaType.APPLICATION_JSON)
    public String mockOPTIONSNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.NORMAL);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mockGetException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String mockPostException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @HEAD
    @Produces(MediaType.APPLICATION_JSON)
    public String mockHEADException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String mockPUTException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String mockDELETEException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    @Path("exception/{appId}/{mockAddress:[\\w\\W]*$}")
    @OPTIONS
    @Produces(MediaType.APPLICATION_JSON)
    public String mockOPTIONSException(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, appId, mockAddress, ExampleTypeEnum.EXCEPTION);
    }

    private String mockService(Request request, UriInfo uriInfo, HttpHeaders httpHeaders, String appId,
                               String mockAddress, ExampleTypeEnum exampleTypeEnum) {
        InterfaceHttpEntity interfaceHttpEntity = mongoService.getOneByMethodAndAddress(appId,
                request.getMethod().toUpperCase(), mockAddress, InterfaceHttpEntity.class);

        if (interfaceHttpEntity == null && !mockAddress.startsWith("/")) {
            interfaceHttpEntity = mongoService.getOneByMethodAndAddress(appId,
                    request.getMethod().toUpperCase(), "/" + mockAddress, InterfaceHttpEntity.class);
        }

        if (interfaceHttpEntity == null) {
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10001.getError(),
                    InsistApiErrorEnum.E10001.getCnMsg()).toJSONString();
        }

        List<InterfaceResultEntity> interfaceResultEntities = interfaceHttpEntity.getInterfaceResultEntities();
        if (CollectionUtils.isEmpty(interfaceResultEntities)) {
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10002.getError(),
                    InsistApiErrorEnum.E10002.getCnMsg()).toJSONString();
        }

        //正常的返回示例
        for (InterfaceResultEntity interfaceResultEntity : interfaceResultEntities) {
            if (exampleTypeEnum.name().equals(interfaceResultEntity.getExampleType())) {
                return interfaceResultEntity.getExampleContent();
            }
        }

        //没有正常的返回示例，默认返回第一条
        return interfaceResultEntities.get(0).getExampleContent();
    }

    /**
     * 根据应用ID查询应用下所有接口文档信息
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @param appId
     * @return
     */
    @Path("interface/{appId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String mockGETNormal(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("appId") String appId) {
        if (StringUtil.isBlank(appId)) {
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10004.getError(),
                    InsistApiErrorEnum.E10004.getMsg()).toJSONString();
        }
        AppInterfaceInfoDomain appInterfaceInfoDomain = null;
        try {
            List<AppDO> appDOList = DocHttpUtil.getAllAppDOList();
            if (!CollectionUtils.isEmpty(appDOList)) {
                for (AppDO appDO : appDOList) {
                    if (appId.equals(appDO.getAppId())) {
                        appInterfaceInfoDomain = new AppInterfaceInfoDomain();
                        appInterfaceInfoDomain.setAppId(appDO.getAppId());
                        appInterfaceInfoDomain.setAppName(appDO.getAppName());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10003.getError(),
                    InsistApiErrorEnum.E10003.getMsg()).toJSONString();
        }

        if (appInterfaceInfoDomain == null) {
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10005.getError(),
                    InsistApiErrorEnum.E10005.getMsg()).toJSONString();
        }

        List<InterfaceCategoryEntity> interfaceCategoryEntities = mongoService.findListByInterfaceAppId(appId, InterfaceCategoryEntity.class);
        if (CollectionUtils.isEmpty(interfaceCategoryEntities)) {
            return ResultMessageBuilder.build(false, InsistApiErrorEnum.E10006.getError(),
                    InsistApiErrorEnum.E10006.getMsg()).toJSONString();
        }

        HttpAddressEntity httpAddressEntity = mongoService.findOneByAppId(appId, HttpAddressEntity.class);
        List<InterfaceHttpEntity> interfaceHttpEntities = mongoService.getListByAppId(appId, InterfaceHttpEntity.class);
        List<InterfaceRpcEntity> interfaceRpcEntities = mongoService.getListByAppId(appId, InterfaceRpcEntity.class);
        Map<String, List<InterfaceHttpEntity>> httpMap = new HashMap<>();
        Map<String, List<InterfaceRpcEntity>> rpcMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                InterfaceHttpRest.addressTranslate(interfaceHttpEntity, httpAddressEntity);
                if (httpMap.get(interfaceHttpEntity.getCategory()) == null) {
                    httpMap.put(interfaceHttpEntity.getCategory(), new ArrayList<InterfaceHttpEntity>());
                }
                httpMap.get(interfaceHttpEntity.getCategory()).add(interfaceHttpEntity);
            }
        }

        if (!CollectionUtils.isEmpty(interfaceRpcEntities)) {
            for (InterfaceRpcEntity interfaceRpcEntity : interfaceRpcEntities) {
                if (rpcMap.get(interfaceRpcEntity.getCategory()) == null) {
                    rpcMap.put(interfaceRpcEntity.getCategory(), new ArrayList<InterfaceRpcEntity>());
                }
                rpcMap.get(interfaceRpcEntity.getCategory()).add(interfaceRpcEntity);
            }
        }

        for (InterfaceCategoryEntity interfaceCategoryEntity : interfaceCategoryEntities) {
            interfaceCategoryEntity.setInterfaceHttpEntities(httpMap.get(interfaceCategoryEntity.getInterfaceCategoryId()));
            interfaceCategoryEntity.setInterfaceRpcEntities(rpcMap.get(interfaceCategoryEntity.getInterfaceCategoryId()));
        }

        appInterfaceInfoDomain.setInterfaceCategoryEntities(interfaceCategoryEntities);
        return JSON.toJSONString(appInterfaceInfoDomain);
    }
}
