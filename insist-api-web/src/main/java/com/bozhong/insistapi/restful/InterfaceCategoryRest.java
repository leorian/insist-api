package com.bozhong.insistapi.restful;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.config.enums.OperationType;
import com.bozhong.insistapi.domain.InterfaceCategoryDomain;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InsistApiOperationEntity;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.enums.OperationCategoryEnum;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.sun.jersey.spi.resource.Singleton;
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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
        try {
            //记录接口类别新增操作日志
            InsistApiOperationEntity operationEntity = new InsistApiOperationEntity();
            operationEntity.buildOperationEntity(interfaceCategoryEntity.getInterfaceAppId(),
                    getAppName(interfaceCategoryEntity.getInterfaceAppId()), OperationType.ADD.name(),
                    OperationCategoryEnum.CATEGORY.name(), interfaceCategoryEntity);
            mongoService.insertOne(operationEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            //记录接口类别更新操作日志
            InsistApiOperationEntity operationEntity = new InsistApiOperationEntity();
            operationEntity.buildOperationEntity(interfaceCategoryEntity.getInterfaceAppId(),
                    getAppName(interfaceCategoryEntity.getInterfaceAppId()), OperationType.UPDATE.name(),
                    OperationCategoryEnum.CATEGORY.name(), interfaceCategoryEntity);
            mongoService.insertOne(operationEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        try {
            InterfaceCategoryEntity interfaceCategoryEntity = mongoService.findOneByInterfaceCategoryId(interfaceCategoryId,
                    InterfaceCategoryEntity.class);
            //记录接口类别新增操作日志
            InsistApiOperationEntity operationEntity = new InsistApiOperationEntity();
            operationEntity.buildOperationEntity(interfaceCategoryEntity.getInterfaceAppId(),
                    getAppName(interfaceCategoryEntity.getInterfaceAppId()), OperationType.DELETE.name(),
                    OperationCategoryEnum.CATEGORY.name(), interfaceCategoryEntity);
            mongoService.insertOne(operationEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    /**
     * 获取哦应用名称
     *
     * @param appId
     * @return
     */
    private String getAppName(String appId) throws IOException {
        List<AppDO> appDOList = DocHttpUtil.getAllAppDOList();
        Map<String, String> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(appDOList)) {
            for (AppDO appDO : appDOList) {
                map.put(appDO.getAppId(), appDO.getAppName());
            }
        }
        return map.get(appId);
    }
}
