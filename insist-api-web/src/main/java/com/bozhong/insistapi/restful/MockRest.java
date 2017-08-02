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

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
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


    @Path("{mockAddress:[\\w\\W]*$}")
    @GET
    public String mockGet(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, mockAddress);
    }

    @Path("{mockAddress:[\\w\\W]*$}")
    @POST
    public String mockPost(@Context Request request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders
            , @PathParam("mockAddress") String mockAddress) {
        return mockService(request, uriInfo, httpHeaders, mockAddress);
    }

    private String mockService(Request request, UriInfo uriInfo, HttpHeaders httpHeaders, String mockAddress) {
        InterfaceHttpEntity interfaceHttpEntity = mongoService.getOneByMockAddress(mockAddress, InterfaceHttpEntity.class);
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
            if (ExampleTypeEnum.NORMAL.name().equals(interfaceResultEntity.getExampleType())) {
                return interfaceResultEntity.getExampleContent();
            }
        }

        //没有正常的返回示例，默认返回第一条
        return interfaceResultEntities.get(0).getExampleContent();
    }
}
