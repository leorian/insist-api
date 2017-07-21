package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.InterfaceParamEntity;
import com.bozhong.insistapi.entity.InterfaceResultEntity;
import com.bozhong.insistapi.entity.InterfaceRpcEntity;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.enums.InterfaceTypeEnum;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiezhonggui on 2017/7/15.
 */
public class InterfaceRpcDomain implements Serializable{
    /*接口详情*/
    private String appIdInput;
    private String classNameInput;
    private String methodNameInput;
    private String nameInput;
    private String functionDescribeInput;
    private String returnTypeInput;
    private String methodParamInput;

    /*请求参数*/
    private List<String> paramNamesInput;
    private List<String> paramTypesInput;
    private List<String> paramDescribesInput;
    private List<Boolean> requiredsInput;
    private List<Boolean> jsontransformatsInput;
    private List<String> examplesInput;
    private List<String> defaultValuesInput;


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

    public List<String> getParamNamesInput() {
        return paramNamesInput;
    }

    public void setParamNamesInput(List<String> paramNamesInput) {
        this.paramNamesInput = paramNamesInput;
    }

    public List<String> getParamTypesInput() {
        return paramTypesInput;
    }

    public void setParamTypesInput(List<String> paramTypesInput) {
        this.paramTypesInput = paramTypesInput;
    }

    public List<String> getParamDescribesInput() {
        return paramDescribesInput;
    }

    public void setParamDescribesInput(List<String> paramDescribesInput) {
        this.paramDescribesInput = paramDescribesInput;
    }

    public List<Boolean> getRequiredsInput() {
        return requiredsInput;
    }

    public void setRequiredsInput(List<Boolean> requiredsInput) {
        this.requiredsInput = requiredsInput;
    }

    public List<Boolean> getJsontransformatsInput() {
        return jsontransformatsInput;
    }

    public void setJsontransformatsInput(List<Boolean> jsontransformatsInput) {
        this.jsontransformatsInput = jsontransformatsInput;
    }

    public List<String> getExamplesInput() {
        return examplesInput;
    }

    public void setExamplesInput(List<String> examplesInput) {
        this.examplesInput = examplesInput;
    }

    public List<String> getDefaultValuesInput() {
        return defaultValuesInput;
    }

    public void setDefaultValuesInput(List<String> defaultValuesInput) {
        this.defaultValuesInput = defaultValuesInput;
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
        if (CollectionUtils.isEmpty(this.getParamNamesInput())) {
            return null;
        }

        List<InterfaceParamEntity> interfaceParamEntities = new ArrayList<>(this.getParamNamesInput().size());
        for (int i = 0; i < this.getParamNamesInput().size(); i++) {
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
            interfaceParamEntity.setParamName(this.getParamNamesInput().get(i));
            interfaceParamEntity.setParamType(this.getParamTypesInput().get(i));
            interfaceParamEntity.setParamDescribe(this.getParamDescribesInput().get(i));
            interfaceParamEntity.setRequired(this.getRequiredsInput().get(i));
            interfaceParamEntity.setJsontransformat(this.getJsontransformatsInput().get(i));
            interfaceParamEntity.setExample(this.getExamplesInput().get(i));
            interfaceParamEntity.setDefaultValue(this.getDefaultValuesInput().get(i));
            interfaceParamEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamEntities.add(interfaceParamEntity);
        }

        return interfaceParamEntities;
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
