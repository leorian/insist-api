package com.bozhong.insistapi.restful;

import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.insistapi.common.InsistApiConstants;
import com.bozhong.insistapi.common.InsistApiErrorEnum;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.entity.InterfaceResultEntity;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.service.MongoService;
import com.sun.jersey.spi.resource.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

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
}
