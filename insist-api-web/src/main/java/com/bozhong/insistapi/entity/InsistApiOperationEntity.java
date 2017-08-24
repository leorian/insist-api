package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yx.eweb.main.EWebServletContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiezg@317hu.com on 2017/8/24 0024.
 */
public class InsistApiOperationEntity extends BaseEntity {



    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private String operationTime;

    /**
     * 操作类型
     */
    private String operationType;

    /**
     * 操作类别
     */
    private String operationCategory;

    /**
     * 操作内容
     */
    private String operationContent;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationCategory() {
        return operationCategory;
    }

    public void setOperationCategory(String operationCategory) {
        this.operationCategory = operationCategory;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public void buildOperationEntity(String appId, String appName, String operationType, String operationCategory, Object o) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.setAppId(appId);
        this.setAppName(appName);
        this.setOperator((String) EWebServletContext.getRequest().getAttribute("uId"));
        this.setOperationTime(simpleDateFormat.format(new Date()));
        this.setOperationType(operationType);
        this.setOperationCategory(operationCategory);
        this.setOperationContent(gson.toJson(o));
        this.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        this.setCreateDateTime(simpleDateFormat.format(new Date()));
        this.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        this.setUpdateDateTime(simpleDateFormat.format(new Date()));
    }
}
