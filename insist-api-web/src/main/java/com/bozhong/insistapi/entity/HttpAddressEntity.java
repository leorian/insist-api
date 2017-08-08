package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/8/8 0008.
 */
public class HttpAddressEntity extends BaseEntity {

    private String appId;
    private String mockAddress;
    private String devAddress;
    private String sitAddress;
    private String uatAddress;
    private String prdAddress;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMockAddress() {
        return mockAddress;
    }

    public void setMockAddress(String mockAddress) {
        this.mockAddress = mockAddress;
    }

    public String getDevAddress() {
        return devAddress;
    }

    public void setDevAddress(String devAddress) {
        this.devAddress = devAddress;
    }

    public String getSitAddress() {
        return sitAddress;
    }

    public void setSitAddress(String sitAddress) {
        this.sitAddress = sitAddress;
    }

    public String getUatAddress() {
        return uatAddress;
    }

    public void setUatAddress(String uatAddress) {
        this.uatAddress = uatAddress;
    }

    public String getPrdAddress() {
        return prdAddress;
    }

    public void setPrdAddress(String prdAddress) {
        this.prdAddress = prdAddress;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
