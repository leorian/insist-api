package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.service.MongoService;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

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
        List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        if (!CollectionUtils.isEmpty(appDOList)) {
            Map<String, Integer> appCategoryCountMap = mongoService.appCategoryCountGroup(InterfaceCategoryEntity.class);
            Map<String, Integer> appInterfaceCountMap = mongoService.appInterfaceCountGroup(InterfaceHttpEntity.class);
            if (appCategoryCountMap == null) {
                appCategoryCountMap = new HashMap<>();
            }

            if (appInterfaceCountMap == null) {
                appInterfaceCountMap = new HashMap<>();
            }
            for (AppDO appDO : appDOList) {
                appDO.setCategoryCount(appCategoryCountMap.get(appDO.getAppId()));
                appDO.setInterfaceCount(appInterfaceCountMap.get(appDO.getAppId()));
            }
        }
    }
}