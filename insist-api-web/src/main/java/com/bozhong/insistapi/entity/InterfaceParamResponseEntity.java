package com.bozhong.insistapi.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceParamResponseEntity extends BaseEntity {
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
    private String paramNameResponse;

    /**
     * 参数类型
     */
    private String paramTypeResponse;

    /**
     * 参数描述
     */
    private String paramDescribeResponse;

    /**
     * 示例
     */
    private String exampleResponse;


    /**
     * 示例详情
     */
    private String exampleDetailResponse;

    /**
     * 默认值详情
     */
    private String defaultValueDetailResponse;

    public InterfaceParamResponseEntity() {
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

    public String getParamNameResponse() {
        return paramNameResponse;
    }

    public void setParamNameResponse(String paramNameResponse) {
        this.paramNameResponse = paramNameResponse;
    }

    public String getParamTypeResponse() {
        return paramTypeResponse;
    }

    public void setParamTypeResponse(String paramTypeResponse) {
        this.paramTypeResponse = paramTypeResponse;
    }

    public String getParamDescribeResponse() {
        return paramDescribeResponse;
    }

    public void setParamDescribeResponse(String paramDescribeResponse) {
        this.paramDescribeResponse = paramDescribeResponse;
    }

    public String getExampleResponse() {
        return exampleResponse;
    }

    public void setExampleResponse(String exampleResponse) {
        this.exampleResponse = exampleResponse;
    }

    public String getExampleDetailResponse() {
        return exampleDetailResponse;
    }

    public void setExampleDetailResponse(String exampleDetailResponse) {
        this.exampleDetailResponse = exampleDetailResponse;
    }

    public String getDefaultValueDetailResponse() {
        return defaultValueDetailResponse;
    }

    public void setDefaultValueDetailResponse(String defaultValueDetailResponse) {
        this.defaultValueDetailResponse = defaultValueDetailResponse;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
