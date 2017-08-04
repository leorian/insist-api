package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcEntity extends BaseEntity {


    public InterfaceRpcEntity() {
    }

    public InterfaceRpcEntity(String id, String appId, String name, String className, String methodName,
                              String functionDescribe, String returnType, String methodParam) {
        this.id = id;
        this.appId = appId;
        this.name = name;
        this.className = className;
        this.methodName = methodName;
        this.functionDescribe = functionDescribe;
        this.returnType = returnType;
        this.methodParam = methodParam;
    }

    /**
     * 接口ID
     */
    private String id;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 接口名称
     */
    private String name;

    /**
     * 类全路径名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 功能描述
     */
    private String functionDescribe;

    /**
     * 返回值类型
     */
    private String returnType;

    /**
     * 方法参数
     */
    private String methodParam;

    /**
     *
     */
    private List<InterfaceParamEntity> interfaceParamEntities;

    /**
     *
     */
    private List<InterfaceParamResponseEntity> interfaceParamResponseEntities;

    /**
     *
     */
    private List<InterfaceResultEntity> interfaceResultEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFunctionDescribe() {
        return functionDescribe;
    }

    public void setFunctionDescribe(String functionDescribe) {
        this.functionDescribe = functionDescribe;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getMethodParam() {
        return methodParam;
    }

    public void setMethodParam(String methodParam) {
        this.methodParam = methodParam;
    }

    public List<InterfaceParamEntity> getInterfaceParamEntities() {
        return interfaceParamEntities;
    }

    public void setInterfaceParamEntities(List<InterfaceParamEntity> interfaceParamEntities) {
        this.interfaceParamEntities = interfaceParamEntities;
    }

    public List<InterfaceResultEntity> getInterfaceResultEntities() {
        return interfaceResultEntities;
    }

    public void setInterfaceResultEntities(List<InterfaceResultEntity> interfaceResultEntities) {
        this.interfaceResultEntities = interfaceResultEntities;
    }

    public List<InterfaceParamResponseEntity> getInterfaceParamResponseEntities() {
        return interfaceParamResponseEntities;
    }

    public void setInterfaceParamResponseEntities(List<InterfaceParamResponseEntity> interfaceParamResponseEntities) {
        this.interfaceParamResponseEntities = interfaceParamResponseEntities;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
