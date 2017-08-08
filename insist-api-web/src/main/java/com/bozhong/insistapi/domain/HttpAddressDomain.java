package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.HttpAddressEntity;
import com.yx.eweb.main.EWebServletContext;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/8/8 0008.
 */
public class HttpAddressDomain implements Serializable {
    private String httpAppIdInput;
    private String httpMockAddressInput;
    private String httpDevAddressInput;
    private String httpSitAddressInput;
    private String httpUatAddressInput;
    private String httpPrdAddressInput;

    public String getHttpAppIdInput() {
        return httpAppIdInput;
    }

    public void setHttpAppIdInput(String httpAppIdInput) {
        this.httpAppIdInput = httpAppIdInput;
    }

    public String getHttpMockAddressInput() {
        return httpMockAddressInput;
    }

    public void setHttpMockAddressInput(String httpMockAddressInput) {
        this.httpMockAddressInput = httpMockAddressInput;
    }

    public String getHttpDevAddressInput() {
        return httpDevAddressInput;
    }

    public void setHttpDevAddressInput(String httpDevAddressInput) {
        this.httpDevAddressInput = httpDevAddressInput;
    }

    public String getHttpSitAddressInput() {
        return httpSitAddressInput;
    }

    public void setHttpSitAddressInput(String httpSitAddressInput) {
        this.httpSitAddressInput = httpSitAddressInput;
    }

    public String getHttpUatAddressInput() {
        return httpUatAddressInput;
    }

    public void setHttpUatAddressInput(String httpUatAddressInput) {
        this.httpUatAddressInput = httpUatAddressInput;
    }

    public String getHttpPrdAddressInput() {
        return httpPrdAddressInput;
    }

    public void setHttpPrdAddressInput(String httpPrdAddressInput) {
        this.httpPrdAddressInput = httpPrdAddressInput;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public HttpAddressEntity buildHttpAddressEntity() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        HttpAddressEntity httpAddressEntity = new HttpAddressEntity();
        httpAddressEntity.setAppId(this.getHttpAppIdInput());
        httpAddressEntity.setMockAddress(this.getHttpMockAddressInput());
        httpAddressEntity.setDevAddress(this.getHttpDevAddressInput());
        httpAddressEntity.setSitAddress(this.getHttpSitAddressInput());
        httpAddressEntity.setUatAddress(this.getHttpUatAddressInput());
        httpAddressEntity.setPrdAddress(this.getHttpPrdAddressInput());
        httpAddressEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        httpAddressEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
        httpAddressEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        httpAddressEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
        return httpAddressEntity;
    }


}
