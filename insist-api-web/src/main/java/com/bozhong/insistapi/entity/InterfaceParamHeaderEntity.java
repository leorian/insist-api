package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceParamHeaderEntity extends BaseEntity {
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
    private String paramNameHeader;

    /**
     * 参数类型
     */
    private String paramTypeHeader;

    /**
     * 参数描述
     */
    private String paramDescribeHeader;

    /**
     * 示例
     */
    private String exampleHeader;


    /**
     * 示例详情
     */
    private String exampleDetailHeader;

    /**
     * 默认值详情
     */
    private String defaultValueDetailHeader;

    public InterfaceParamHeaderEntity() {
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

    public String getParamNameHeader() {
        return paramNameHeader;
    }

    public void setParamNameHeader(String paramNameHeader) {
        this.paramNameHeader = paramNameHeader;
    }

    public String getParamTypeHeader() {
        return paramTypeHeader;
    }

    public void setParamTypeHeader(String paramTypeHeader) {
        this.paramTypeHeader = paramTypeHeader;
    }

    public String getParamDescribeHeader() {
        return paramDescribeHeader;
    }

    public void setParamDescribeHeader(String paramDescribeHeader) {
        this.paramDescribeHeader = paramDescribeHeader;
    }

    public String getExampleHeader() {
        return exampleHeader;
    }

    public void setExampleHeader(String exampleHeader) {
        this.exampleHeader = exampleHeader;
    }

    public String getExampleDetailHeader() {
        return exampleDetailHeader;
    }

    public void setExampleDetailHeader(String exampleDetailHeader) {
        this.exampleDetailHeader = exampleDetailHeader;
    }

    public String getDefaultValueDetailHeader() {
        return defaultValueDetailHeader;
    }

    public void setDefaultValueDetailHeader(String defaultValueDetailHeader) {
        this.defaultValueDetailHeader = defaultValueDetailHeader;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
