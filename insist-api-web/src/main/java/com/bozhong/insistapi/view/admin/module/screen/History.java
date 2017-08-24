package com.bozhong.insistapi.view.admin.module.screen;

import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.ScreenInter;
import org.springframework.stereotype.Controller;

/**
 * Created by xiezg@317hu.com on 2017/8/24 0024.
 */
@Controller
public class History implements ScreenInter {
    @Override
    public void excute(EWebContext eWebContext) {
        eWebContext.put("menu", History.class.getSimpleName());
    }
}
