package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;
import com.yx.eweb.main.EWebServletContext;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/8/14 0014.
 */
public class InterfaceCategoryDomain implements Serializable {

    /**
     * 应用ID
     */
    private String interfaceAppIdInput;

    /**
     * 分类ID
     */
    private String interfaceCategoryIdInput;

    /**
     * 分类名称
     */
    private String interfaceCategoryNameInput;

    /**
     * 分类描述
     */
    private String interfaceCategoryDescribeInput;

    public String getInterfaceAppIdInput() {
        return interfaceAppIdInput;
    }

    public void setInterfaceAppIdInput(String interfaceAppIdInput) {
        this.interfaceAppIdInput = interfaceAppIdInput;
    }

    public String getInterfaceCategoryIdInput() {
        return interfaceCategoryIdInput;
    }

    public void setInterfaceCategoryIdInput(String interfaceCategoryIdInput) {
        this.interfaceCategoryIdInput = interfaceCategoryIdInput;
    }

    public String getInterfaceCategoryNameInput() {
        return interfaceCategoryNameInput;
    }

    public void setInterfaceCategoryNameInput(String interfaceCategoryNameInput) {
        this.interfaceCategoryNameInput = interfaceCategoryNameInput;
    }

    public String getInterfaceCategoryDescribeInput() {
        return interfaceCategoryDescribeInput;
    }

    public void setInterfaceCategoryDescribeInput(String interfaceCategoryDescribeInput) {
        this.interfaceCategoryDescribeInput = interfaceCategoryDescribeInput;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public InterfaceCategoryEntity builderInterfaceCategoryEntity() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        InterfaceCategoryEntity interfaceCategoryEntity = new InterfaceCategoryEntity();
        interfaceCategoryEntity.setInterfaceAppId(this.getInterfaceAppIdInput());
        interfaceCategoryEntity.setInterfaceCategoryId(simpleDateFormat.format(new Date()));
        interfaceCategoryEntity.setInterfaceCategoryName(this.getInterfaceCategoryNameInput());
        interfaceCategoryEntity.setInterfaceCategoryDescribe(this.getInterfaceCategoryDescribeInput());
        interfaceCategoryEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceCategoryEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceCategoryEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceCategoryEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
        return interfaceCategoryEntity;
    }
}
