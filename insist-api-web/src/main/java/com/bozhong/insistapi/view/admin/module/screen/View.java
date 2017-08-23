package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.entity.AppDO;
import com.yx.eweb.main.EWebContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/21 0021.
 */
@Controller
public class View extends AbstractPreview {
    @Override
    public void excute(EWebContext eWebContext) {
        super.excute(eWebContext);
        String appId = eWebContext.getRequest().getParameter("appId");
        eWebContext.put("menu", View.class.getSimpleName());
        List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        if (!CollectionUtils.isEmpty(appDOList) && StringUtil.isNotBlank(appId)) {
            for (AppDO appDO : appDOList) {
                if (appDO.getAppId().equals(appId)) {
                    appDO.setViewSelectType(true);
                    eWebContext.put("appDO", appDO);
                    break;
                }
            }
        }

        eWebContext.getRequest().setAttribute("appDOList", appDOList);
    }
}
