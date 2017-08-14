package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.bozhong.insistapi.enums.ParamTypeEnum;
import com.bozhong.insistapi.service.MongoService;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/21 0021.
 */
@Controller
public class Main implements ScreenInter {

    @Autowired
    private MongoService mongoService;

    @Override
    public void excute(EWebContext eWebContext) {
        String appId = eWebContext.getRequest().getParameter("appId");
        eWebContext.put("menu", Main.class.getSimpleName());
        List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        if (!CollectionUtils.isEmpty(appDOList) && StringUtil.isNotBlank(appId)) {
            for (AppDO appDO : appDOList) {
                if (appDO.getAppId().equals(appId)) {
                    appDO.setMainSelectType(true);
                    eWebContext.put("appDO", appDO);
                    break;
                }
            }
        }

        eWebContext.getRequest().setAttribute("appDOList", appDOList);

        List<InterfaceCategoryEntity> interfaceCategoryEntities = mongoService.findListByInterfaceAppId(appId,
                InterfaceCategoryEntity.class);
        eWebContext.put("interfaceCategoryEntities", interfaceCategoryEntities);
        eWebContext.put("paramTypeEnumList", ParamTypeEnum.LIST);
    }
}
