package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.InterfaceParamEntity;
import com.bozhong.insistapi.entity.InterfaceParamResponseEntity;
import com.bozhong.insistapi.entity.InterfaceResultEntity;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.enums.InterfaceTypeEnum;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcDomain implements Serializable {
    /*接口详情*/
    private String appIdInput;
    private String classNameInput;
    private String methodNameInput;
    private String nameInput;
    private String functionDescribeInput;
    private String returnTypeInput;
    private String methodParamInput;

    /*请求参数*/
    private String[] paramNamesInput;
    private String[] paramTypesInput;
    private String[] paramDescribesInput;
    private Boolean[] requiredsInput;
    private Boolean[] jsontransformatsInput;
    private String[] examplesInput;
    private String[] defaultValuesInput;
    private String[] exampleDetailsInput;
    private String[] defaultValueDetailsInput;

    /*响应参数*/
    private String[] paramNamesResponseInput;
    private String[] paramTypesResponseInput;
    private String[] paramDescribesResponseInput;
    private String[] examplesResponseInput;
    private String[] exampleDetailsResponseInput;
    private String[] defaultValueDetailsResponseInput;


    /*返回示例*/
    private String returnExampleContent;
    private String returnExampleAttentionMatters;

    /*异常示例*/
    private String exceptionExampleContent;
    private String exceptionAttentionMatters;

    public String getAppIdInput() {
        return appIdInput;
    }

    public void setAppIdInput(String appIdInput) {
        this.appIdInput = appIdInput;
    }

    public String getClassNameInput() {
        return classNameInput;
    }

    public void setClassNameInput(String classNameInput) {
        this.classNameInput = classNameInput;
    }

    public String getMethodNameInput() {
        return methodNameInput;
    }

    public void setMethodNameInput(String methodNameInput) {
        this.methodNameInput = methodNameInput;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getFunctionDescribeInput() {
        return functionDescribeInput;
    }

    public void setFunctionDescribeInput(String functionDescribeInput) {
        this.functionDescribeInput = functionDescribeInput;
    }

    public String getReturnTypeInput() {
        return returnTypeInput;
    }

    public void setReturnTypeInput(String returnTypeInput) {
        this.returnTypeInput = returnTypeInput;
    }

    public String getMethodParamInput() {
        return methodParamInput;
    }

    public void setMethodParamInput(String methodParamInput) {
        this.methodParamInput = methodParamInput;
    }

    public String[] getParamNamesInput() {
        return paramNamesInput;
    }

    public void setParamNamesInput(String[] paramNamesInput) {
        this.paramNamesInput = paramNamesInput;
    }

    public String[] getParamTypesInput() {
        return paramTypesInput;
    }

    public void setParamTypesInput(String[] paramTypesInput) {
        this.paramTypesInput = paramTypesInput;
    }

    public String[] getParamDescribesInput() {
        return paramDescribesInput;
    }

    public void setParamDescribesInput(String[] paramDescribesInput) {
        this.paramDescribesInput = paramDescribesInput;
    }

    public Boolean[] getRequiredsInput() {
        return requiredsInput;
    }

    public void setRequiredsInput(Boolean[] requiredsInput) {
        this.requiredsInput = requiredsInput;
    }

    public Boolean[] getJsontransformatsInput() {
        return jsontransformatsInput;
    }

    public void setJsontransformatsInput(Boolean[] jsontransformatsInput) {
        this.jsontransformatsInput = jsontransformatsInput;
    }

    public String[] getExamplesInput() {
        return examplesInput;
    }

    public void setExamplesInput(String[] examplesInput) {
        this.examplesInput = examplesInput;
    }

    public String[] getDefaultValuesInput() {
        return defaultValuesInput;
    }

    public void setDefaultValuesInput(String[] defaultValuesInput) {
        this.defaultValuesInput = defaultValuesInput;
    }

    public String[] getExampleDetailsInput() {
        return exampleDetailsInput;
    }

    public void setExampleDetailsInput(String[] exampleDetailsInput) {
        this.exampleDetailsInput = exampleDetailsInput;
    }

    public String[] getDefaultValueDetailsInput() {
        return defaultValueDetailsInput;
    }

    public String[] getParamNamesResponseInput() {
        return paramNamesResponseInput;
    }

    public void setParamNamesResponseInput(String[] paramNamesResponseInput) {
        this.paramNamesResponseInput = paramNamesResponseInput;
    }

    public String[] getParamTypesResponseInput() {
        return paramTypesResponseInput;
    }

    public void setParamTypesResponseInput(String[] paramTypesResponseInput) {
        this.paramTypesResponseInput = paramTypesResponseInput;
    }

    public String[] getParamDescribesResponseInput() {
        return paramDescribesResponseInput;
    }

    public void setParamDescribesResponseInput(String[] paramDescribesResponseInput) {
        this.paramDescribesResponseInput = paramDescribesResponseInput;
    }

    public String[] getExamplesResponseInput() {
        return examplesResponseInput;
    }

    public void setExamplesResponseInput(String[] examplesResponseInput) {
        this.examplesResponseInput = examplesResponseInput;
    }

    public String[] getExampleDetailsResponseInput() {
        return exampleDetailsResponseInput;
    }

    public void setExampleDetailsResponseInput(String[] exampleDetailsResponseInput) {
        this.exampleDetailsResponseInput = exampleDetailsResponseInput;
    }

    public String[] getDefaultValueDetailsResponseInput() {
        return defaultValueDetailsResponseInput;
    }

    public void setDefaultValueDetailsResponseInput(String[] defaultValueDetailsResponseInput) {
        this.defaultValueDetailsResponseInput = defaultValueDetailsResponseInput;
    }

    public void setDefaultValueDetailsInput(String[] defaultValueDetailsInput) {
        this.defaultValueDetailsInput = defaultValueDetailsInput;
    }

    public String getReturnExampleContent() {
        return returnExampleContent;
    }

    public void setReturnExampleContent(String returnExampleContent) {
        this.returnExampleContent = returnExampleContent;
    }

    public String getReturnExampleAttentionMatters() {
        return returnExampleAttentionMatters;
    }

    public void setReturnExampleAttentionMatters(String returnExampleAttentionMatters) {
        this.returnExampleAttentionMatters = returnExampleAttentionMatters;
    }

    public String getExceptionExampleContent() {
        return exceptionExampleContent;
    }

    public void setExceptionExampleContent(String exceptionExampleContent) {
        this.exceptionExampleContent = exceptionExampleContent;
    }

    public String getExceptionAttentionMatters() {
        return exceptionAttentionMatters;
    }

    public void setExceptionAttentionMatters(String exceptionAttentionMatters) {
        this.exceptionAttentionMatters = exceptionAttentionMatters;
    }

    public InterfaceRpcEntity buildInterfaceRpcEntity() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        InterfaceRpcEntity interfaceRpcEntity = new InterfaceRpcEntity();
        interfaceRpcEntity.setId(simpleDateFormat.format(date));
        interfaceRpcEntity.setAppId(this.getAppIdInput());
        interfaceRpcEntity.setClassName(this.getClassNameInput());
        interfaceRpcEntity.setMethodName(this.getMethodNameInput());
        interfaceRpcEntity.setName(this.getNameInput());
        interfaceRpcEntity.setFunctionDescribe(this.getFunctionDescribeInput());
        interfaceRpcEntity.setReturnType(this.getReturnTypeInput());
        interfaceRpcEntity.setMethodParam(this.getMethodParamInput());
        interfaceRpcEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceRpcEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
        return interfaceRpcEntity;
    }

    public List<InterfaceParamEntity> buildInterfaceParamEntities(String interfaceId) {
        if (this.getParamNamesInput() == null || this.getParamNamesInput().length == 0) {
            return null;
        }

        List<InterfaceParamEntity> interfaceParamEntities = new ArrayList<>(this.getParamNamesInput().length);
        for (int i = 0; i < this.getParamNamesInput().length; i++) {
            InterfaceParamEntity interfaceParamEntity = new InterfaceParamEntity();
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            interfaceParamEntity.setId(simpleDateFormat.format(date));
            interfaceParamEntity.setInterfaceId(interfaceId);
            interfaceParamEntity.setInterfaceType(InterfaceTypeEnum.RPC.name());
            interfaceParamEntity.setParamName(this.getParamNamesInput()[i]);
            interfaceParamEntity.setParamType(this.getParamTypesInput()[i]);
            interfaceParamEntity.setParamDescribe(this.getParamDescribesInput()[i]);
            interfaceParamEntity.setRequired(this.getRequiredsInput()[i]);
            interfaceParamEntity.setJsontransformat(this.getJsontransformatsInput()[i]);
            interfaceParamEntity.setExample(this.getExamplesInput()[i]);
            interfaceParamEntity.setDefaultValue(this.getDefaultValuesInput()[i]);
            interfaceParamEntity.setExampleDetail(this.getExampleDetailsInput()[i]);
            interfaceParamEntity.setDefaultValueDetail(this.getDefaultValueDetailsInput()[i]);
            interfaceParamEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamEntities.add(interfaceParamEntity);
        }

        return interfaceParamEntities;
    }

    public List<InterfaceParamResponseEntity> buildInterfaceParamResponseEntities(String interfaceId) {
        if (this.getParamNamesResponseInput() == null || this.getParamNamesResponseInput().length == 0) {
            return null;
        }

        List<InterfaceParamResponseEntity> interfaceParamResponseEntities = new ArrayList<>(this.getParamNamesResponseInput().length);
        for (int i = 0; i < this.getParamNamesResponseInput().length; i++) {
            InterfaceParamResponseEntity interfaceParamResponseEntity = new InterfaceParamResponseEntity();
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            interfaceParamResponseEntity.setId(simpleDateFormat.format(date));
            interfaceParamResponseEntity.setInterfaceId(interfaceId);
            interfaceParamResponseEntity.setInterfaceType(InterfaceTypeEnum.RPC.name());
            interfaceParamResponseEntity.setParamNameResponse(this.getParamNamesResponseInput()[i]);
            interfaceParamResponseEntity.setParamTypeResponse(this.getParamTypesResponseInput()[i]);
            interfaceParamResponseEntity.setParamDescribeResponse(this.getParamDescribesResponseInput()[i]);
            interfaceParamResponseEntity.setExampleResponse(this.getExamplesResponseInput()[i]);
            interfaceParamResponseEntity.setExampleDetailResponse(this.getExampleDetailsResponseInput()[i]);
            interfaceParamResponseEntity.setDefaultValueDetailResponse(this.getDefaultValueDetailsResponseInput()[i]);
            interfaceParamResponseEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamResponseEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamResponseEntities.add(interfaceParamResponseEntity);
        }

        return interfaceParamResponseEntities;
    }

    public List<InterfaceResultEntity> buildInterfaceResultEntities(String interfaceId) {
        List<InterfaceResultEntity> interfaceResultEntities = new ArrayList<>(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        InterfaceResultEntity interfaceResultEntity1 = new InterfaceResultEntity();
        interfaceResultEntity1.setId(simpleDateFormat.format(new Date()));
        interfaceResultEntity1.setInterfaceId(interfaceId);
        interfaceResultEntity1.setInterfaceType(InterfaceTypeEnum.RPC.name());
        interfaceResultEntity1.setExampleType(ExampleTypeEnum.NORMAL.name());
        interfaceResultEntity1.setExampleContent(this.getReturnExampleContent());
        interfaceResultEntity1.setAttentionMatters(this.getReturnExampleAttentionMatters());
        interfaceResultEntity1.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntity1.setUpdateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntities.add(interfaceResultEntity1);
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InterfaceResultEntity interfaceResultEntity2 = new InterfaceResultEntity();
        interfaceResultEntity2.setId(simpleDateFormat.format(new Date()));
        interfaceResultEntity2.setInterfaceId(interfaceId);
        interfaceResultEntity2.setInterfaceType(InterfaceTypeEnum.RPC.name());
        interfaceResultEntity2.setExampleType(ExampleTypeEnum.EXCEPTION.name());
        interfaceResultEntity2.setExampleContent(this.getExceptionExampleContent());
        interfaceResultEntity2.setAttentionMatters(this.getExceptionAttentionMatters());
        interfaceResultEntity2.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntity2.setUpdateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntities.add(interfaceResultEntity2);
        return interfaceResultEntities;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
