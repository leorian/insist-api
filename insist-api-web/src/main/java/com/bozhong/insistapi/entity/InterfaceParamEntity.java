package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceParamEntity extends BaseEntity {
    /**
     * 接口参数主键
     */
    private String id;

    /**
     * 接口ID
     */
    private String interfaceId;

    /**
     * 接口类型
     */
    private String interfaceType;

    /**
     * 参数名称
     */
    private String paramName;

    /**
     * 参数类型
     */
    private String paramType;

    /**
     * 参数描述
     */
    private String paramDescribe;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 是否JSON格式化传输
     */
    private Boolean jsontransformat;

    /**
     * 示例
     */
    private String example;

    /**
     * 默认值
     */
    private String defaultValue;

    public InterfaceParamEntity() {
    }

    public InterfaceParamEntity(String id, String interfaceId, String interfaceType, String paramName, String paramType,
                                String paramDescribe, Boolean required, Boolean jsontransformat,
                                String example, String defaultValue) {
        this.id = id;
        this.interfaceId = interfaceId;
        this.interfaceType = interfaceType;
        this.paramName = paramName;
        this.paramType = paramType;
        this.paramDescribe = paramDescribe;
        this.required = required;
        this.jsontransformat = jsontransformat;
        this.example = example;
        this.defaultValue = defaultValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamDescribe() {
        return paramDescribe;
    }

    public void setParamDescribe(String paramDescribe) {
        this.paramDescribe = paramDescribe;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getJsontransformat() {
        return jsontransformat;
    }

    public void setJsontransformat(Boolean jsontransformat) {
        this.jsontransformat = jsontransformat;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
