package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
import com.bozhong.insistapi.service.MongoService;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/8/22 0022.
 */
@Controller
public class Empty implements ScreenInter {

    @Autowired
    private MongoService mongoService;

    @Override
    public void excute(EWebContext eWebContext) {
        //List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        List<AppDO> appDOList = null;
        try {
            appDOList = DocHttpUtil.getAllAppDOList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!CollectionUtils.isEmpty(appDOList)) {
            Map<String, Integer> appCategoryCountMap = mongoService.appCategoryCountGroup(InterfaceCategoryEntity.class);
            Map<String, Integer> appInterfaceCountMap = mongoService.appInterfaceCountGroup(InterfaceHttpEntity.class);
            Map<String, Integer> appInterfaceCountMap2 = mongoService.appInterfaceCountGroup(InterfaceRpcEntity.class);
            if (appCategoryCountMap == null) {
                appCategoryCountMap = new HashMap<>();
            }

            if (appInterfaceCountMap == null) {
                appInterfaceCountMap = new HashMap<>();
            }

            if (appInterfaceCountMap2 == null) {
                appInterfaceCountMap2 = new HashMap<>();
            }

            for (AppDO appDO : appDOList) {
                appDO.setCategoryCount(appCategoryCountMap.get(appDO.getAppId()));
                appDO.setInterfaceCount(appInterfaceCountMap.get(appDO.getAppId()),
                        appInterfaceCountMap2.get(appDO.getAppId()));
            }
        }

        eWebContext.put("appDOListOpen", appDOList);
    }
}
