package com.bozhong.insistapi.view.admin.module.screen;

import com.bozhong.common.util.StringUtil;
import com.bozhong.insistapi.entity.AppDO;
import com.bozhong.insistapi.task.DocHttpUtil;
import com.yx.eweb.main.EWebContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/24 0024.
 */
@Controller
public class Pdf extends AbstractPreview {

    @Override
    public void excute(EWebContext eWebContext) {
        super.excute(eWebContext);
        String appId = eWebContext.getRequest().getParameter("appId");
        List<AppDO> appDOList = (List<AppDO>) eWebContext.getRequest().getAttribute("appDOList");
        if (CollectionUtils.isEmpty(appDOList)) {
            try {
                appDOList = DocHttpUtil.getAllAppDOList();
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
