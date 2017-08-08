package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

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


}
