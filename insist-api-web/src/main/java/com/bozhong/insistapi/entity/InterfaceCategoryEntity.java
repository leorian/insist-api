package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/8/14 0014.
 */
public class InterfaceCategoryEntity extends BaseEntity {

    /**
     * 应用ID
     */
    private String interfaceAppId;

    /**
     * 分类ID
     */
    private String interfaceCategoryId;

    /**
     * 分类名称
     */
    private String interfaceCategoryName;

    /**
     * 分类描述
     */
    private String interfaceCategoryDescribe;

    /**
     * 类别分类中接口数量
     */
    private Integer InterfaceCount;

    public String getInterfaceAppId() {
        return interfaceAppId;
    }

    public void setInterfaceAppId(String interfaceAppId) {
        this.interfaceAppId = interfaceAppId;
    }

    public String getInterfaceCategoryId() {
        return interfaceCategoryId;
    }

    public void setInterfaceCategoryId(String interfaceCategoryId) {
        this.interfaceCategoryId = interfaceCategoryId;
    }

    public String getInterfaceCategoryName() {
        return interfaceCategoryName;
    }

    public void setInterfaceCategoryName(String interfaceCategoryName) {
        this.interfaceCategoryName = interfaceCategoryName;
    }

    public String getInterfaceCategoryDescribe() {
        return interfaceCategoryDescribe;
    }

    public void setInterfaceCategoryDescribe(String interfaceCategoryDescribe) {
        this.interfaceCategoryDescribe = interfaceCategoryDescribe;
    }

    public Integer getInterfaceCount() {
        return InterfaceCount;
    }

    public void setInterfaceCount(Integer interfaceCount) {
        InterfaceCount = interfaceCount;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
