package com.bozhong.insistapi.common;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/4/25 0025.
 */
public enum InsistApiErrorEnum {

    E10001("E10001", "Parameter Not Defined", "参数未定义！"),
    E10011("E10011", "QiNiu Upload Error", "七牛上传失败"),
    E10015("E10015", "QiNiu Get File Info Error", "七牛获取文件信息异常！"),
    E10016("E10016", "Net Work Error", "网络连接异常！"),
    E10017("E10017", "Open Office Service Error", "文件转换服务异常！"),
    E10018("E10018", "Login Failure Public Private Key Expire", "用户密码公钥私钥加密策略过期，请重新进入登录页面！"),;


    private String error;

    private String msg;

    private String cnMsg;

    InsistApiErrorEnum(String error, String msg, String cnMsg) {
        this.error = error;
        this.msg = msg;
        this.cnMsg = cnMsg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCnMsg() {
        return cnMsg;
    }

    public void setCnMsg(String cnMsg) {
        this.cnMsg = cnMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
