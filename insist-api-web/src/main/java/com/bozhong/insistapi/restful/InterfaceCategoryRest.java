package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.insistapi.domain.InterfaceCategoryDomain;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.service.MongoService;
import com.sun.jersey.spi.resource.Singleton;
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
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/8/14 0014.
 */
@Controller
@Singleton
@Path("interfaceCategory")
public class InterfaceCategoryRest {
    @Autowired
    private MongoService mongoService;

    /**
     * 新增分类
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @return
     */
    @POST
    @Path("insertInterfaceCategory")
    public String insertInterfaceCategory(@Context Request request, @Context UriInfo uriInfo,
                                          @Context HttpHeaders httpHeaders) {
        InterfaceCategoryDomain interfaceCategoryDomain = new InterfaceCategoryDomain();
        try {
            BeanUtils.copyProperties(interfaceCategoryDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(interfaceCategoryDomain));
        InterfaceCategoryEntity interfaceCategoryEntity = interfaceCategoryDomain.builderInterfaceCategoryEntity();
        mongoService.insertOne(interfaceCategoryEntity);
        return ResultMessageBuilder.build().toJSONString();
    }

    /**
     * 更新分类
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @return
     */
    @POST
    @Path("updateInterfaceCategory")
    public String updateInterfaceCategory(@Context Request request, @Context UriInfo uriInfo,
                                          @Context HttpHeaders httpHeaders) {
        InterfaceCategoryDomain interfaceCategoryDomain = new InterfaceCategoryDomain();
        try {
            BeanUtils.copyProperties(interfaceCategoryDomain, EWebServletContext.getRequest().getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String interfaceCategoryId = EWebServletContext.getRequest().getParameter("interfaceCategoryIdInput");
        System.out.println(JSON.toJSONString(interfaceCategoryDomain));
        InterfaceCategoryEntity interfaceCategoryEntity = interfaceCategoryDomain.builderInterfaceCategoryEntity();
        interfaceCategoryEntity.setInterfaceCategoryId(interfaceCategoryId);
        mongoService.updateOneByInterfaceCategoryId(interfaceCategoryId, interfaceCategoryEntity);
        return ResultMessageBuilder.build().toJSONString();
    }

    /**
     * 删除分类
     *
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @return
     */
    @POST
    @Path("deleteInterfaceCategory")
    public String deleteInterfaceCategory(@Context Request request, @Context UriInfo uriInfo,
                                          @Context HttpHeaders httpHeaders) {
        String interfaceCategoryId = EWebServletContext.getRequest().getParameter("interfaceCategoryIdInput");
        mongoService.deleteOneByInterfaceCategoryId(interfaceCategoryId, InterfaceCategoryEntity.class);
        return ResultMessageBuilder.build().toJSONString();
    }

    /**
     * 查询应用分类列表
     *
     * @return
     */
    @POST
    @Path("findInterfaceCategoryEntityList")
    public String findInterfaceCategoryEntityList() {
        String interfaceAppId = EWebServletContext.getRequest().getParameter("interfaceAppId");
        List<InterfaceCategoryEntity> interfaceCategoryEntities = mongoService.findListByInterfaceAppId(interfaceAppId,
                InterfaceCategoryEntity.class);

        return ResultMessageBuilder.build(interfaceCategoryEntities).toJSONString();
    }
}
