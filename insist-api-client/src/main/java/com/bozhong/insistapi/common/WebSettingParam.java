package com.bozhong.insistapi.common;

import com.bozhong.myswitch.core.AppSwitch;

/**
 * Created by xiezg@317hu.com on 2017/4/18 0018.
 */
public class WebSettingParam {
    @AppSwitch(type = "string", desc = "公司")
    public static String CORP = "杭州伯仲信息科技有限公司";
    @AppSwitch(type = "string", desc = "部门")
    public static String DEPARTMENT = "云平台部";
    @AppSwitch(type = "string", desc = "网站标题")
    public static String HTML_TITLE = "API接口管理平台";
}
