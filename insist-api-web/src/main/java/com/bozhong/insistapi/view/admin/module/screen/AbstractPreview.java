package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.insistapi.domain.Node;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
import com.bozhong.insistapi.service.MongoService;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/8/23 0023.
 */
public abstract class AbstractPreview implements ScreenInter {
    @Autowired
    private MongoService mongoService;

    @Override
    public void excute(EWebContext eWebContext) {
        String appId = eWebContext.getRequest().getParameter("appId");
        List<InterfaceHttpEntity> interfaceHttpEntities = mongoService.getListByAppId(appId, InterfaceHttpEntity.class);
        List<InterfaceRpcEntity> interfaceRpcEntities = mongoService.getListByAppId(appId, InterfaceRpcEntity.class);
        Map<String, List<Node>> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(interfaceHttpEntities)) {
            int index = 0;
            for (InterfaceHttpEntity interfaceHttpEntity : interfaceHttpEntities) {
                if (map.get(interfaceHttpEntity.getCategory()) == null) {
                    map.put(interfaceHttpEntity.getCategory(), new ArrayList<Node>());
                }
                Node node = new Node();
                node.setHref("javascript:loadHttpInterfaceContent(" + String.valueOf("\\\"" + interfaceHttpEntity.getId() + "\\\"") + ")");
                node.setText(interfaceHttpEntity.getName());
                map.get(interfaceHttpEntity.getCategory()).add(node);
            }
        }

        if (!CollectionUtils.isEmpty(interfaceRpcEntities)) {
            int index = 0;
            for (InterfaceRpcEntity interfaceRpcEntity : interfaceRpcEntities) {
                if (map.get(interfaceRpcEntity.getCategory()) == null) {
                    map.put(interfaceRpcEntity.getCategory(), new ArrayList<Node>());
                }
                Node node = new Node();
                node.setHref("javascript:loadRpcInterfaceContent(" + String.valueOf("\\\"" + interfaceRpcEntity.getId() + "\\\"") + ")");
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

        if (!CollectionUtils.isEmpty(nodes)) {
            List<Node> nodeList = new ArrayList<>();
            for (Node node : nodes) {
                if (!CollectionUtils.isEmpty(node.getNodes())){
                    nodeList.add(node);
                }
            }
            nodes = nodeList;
        }

        eWebContext.put("nodes", nodes);
    }
}
