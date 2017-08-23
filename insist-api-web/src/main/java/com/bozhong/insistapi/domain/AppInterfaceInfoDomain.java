package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.InterfaceCategoryEntity;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/8/23 0023.
 */
public class AppInterfaceInfoDomain {
    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 接口类别
     */
    private List<InterfaceCategoryEntity> interfaceCategoryEntities;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<InterfaceCategoryEntity> getInterfaceCategoryEntities() {
        return interfaceCategoryEntities;
    }

    public void setInterfaceCategoryEntities(List<InterfaceCategoryEntity> interfaceCategoryEntities) {
        this.interfaceCategoryEntities = interfaceCategoryEntities;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
