package com.bozhong.insistapi.view.admin.module.screen;

import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.domain.Node;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.qiniu.util.Json;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/7/24 0024.
 */
@Controller
public class Pdf implements ScreenInter {

    @Autowired
    private MongoService mongoService;

    @Override
    public void excute(EWebContext eWebContext) {
        String appId = eWebContext.getRequest().getParameter("appId");
        String uId = eWebContext.getRequest().getParameter("uId");

        List<InterfaceHttpEntity> interfaceHttpEntities = mongoService.getListByAppId(appId, InterfaceHttpEntity.class);
        List<InterfaceRpcEntity> interfaceRpcEntities = mongoService.getListByAppId(appId, InterfaceRpcEntity.class);
        Map<String, List<Node>> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            int index = 0;
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                if (map.get(interfaceHttpEntity.getCategory())==null) {
                    map.put(interfaceHttpEntity.getCategory(),new ArrayList<Node>());
                }
                Node node = new Node();
                node.setHref("#httpNav"+(++index));
                node.setText(interfaceHttpEntity.getName());
                map.get(interfaceHttpEntity.getCategory()).add(node);
            }
        }

        if (!CollectionUtils.isEmpty(interfaceRpcEntities)){
            int index = 0;
            for (InterfaceRpcEntity interfaceRpcEntity : interfaceRpcEntities) {
                if (map.get(interfaceRpcEntity.getCategory())==null) {
                    map.put(interfaceRpcEntity.getCategory(),new ArrayList<Node>());
                }
                Node node = new Node();
                node.setHref("#rpcNav"+(++index));
                node.setText(interfaceRpcEntity.getName());
                map.get(interfaceRpcEntity.getCategory()).add(node);
            }
        }
        List<Node> nodes = new ArrayList<>();
        List<InterfaceCategoryEntity> interfaceCategoryEntities = mongoService.findListByInterfaceAppId(appId,
                InterfaceCategoryEntity.class);
        if (!CollectionUtils.isEmpty(interfaceCategoryEntities)) {
            for (InterfaceCategoryEntity interfaceCategoryEntity : interfaceCategoryEntities) {
                Node node = new Node();
                node.setText(interfaceCategoryEntity.getInterfaceCategoryName());
                node.setNodes(map.get(interfaceCategoryEntity.getInterfaceCategoryId()));
                nodes.add(node);
            }
        }


        eWebContext.put("nodes", nodes);
        eWebContext.put("httpData", JSON.toJSONString(interfaceHttpEntities));
        eWebContext.put("rpcData", JSON.toJSONString(interfaceRpcEntities));
        List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        if (CollectionUtils.isEmpty(appDOList)) {
            try {
                appDOList = DocHttpUtil.getAppDOList(uId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!CollectionUtils.isEmpty(appDOList) && StringUtil.isNotBlank(appId)) {
            for (AppDO appDO : appDOList) {
                if (appDO.getAppId().equals(appId)) {
                    eWebContext.put("appDO", appDO);
                    break;
                }
            }
        } else {
            AppDO appDO = new AppDO();
            appDO.setAppId(appId);
            eWebContext.put("appDO", appDO);
        }
    }
}
