package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.InterfaceHttpEntity;
import com.bozhong.insistapi.entity.InterfaceParamEntity;
import com.bozhong.insistapi.entity.InterfaceResultEntity;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.enums.InterfaceTypeEnum;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/7/12 0012.
 */
public class InterfaceHttpDomain implements Serializable {

    /*接口详情*/
    private String appIdInput;
    private String protocolInput;
    private String methodInput;
    private String transformatInput;
    private String addressInput;
    private String nameInput;
    private String descriptionInput;

    /*请求参数*/
    private String[] paramNamesInput;
    private String[] paramTypesInput;
    private String[] paramDescribesInput;
    private Boolean[] requiredsInput;
    private Boolean[] jsontransformatsInput;
    private String[] examplesInput;
    private String[] defaultValuesInput;


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

    public String getProtocolInput() {
        return protocolInput;
    }

    public void setProtocolInput(String protocolInput) {
        this.protocolInput = protocolInput;
    }

    public String getMethodInput() {
        return methodInput;
    }

    public void setMethodInput(String methodInput) {
        this.methodInput = methodInput;
    }

    public String getTransformatInput() {
        return transformatInput;
    }

    public void setTransformatInput(String transformatInput) {
        this.transformatInput = transformatInput;
    }

    public String getAddressInput() {
        return addressInput;
    }

    public void setAddressInput(String addressInput) {
        this.addressInput = addressInput;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getDescriptionInput() {
        return descriptionInput;
    }

    public void setDescriptionInput(String descriptionInput) {
        this.descriptionInput = descriptionInput;
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

    public InterfaceHttpEntity buildInterfaceHttpEntity() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        InterfaceHttpEntity interfaceHttpEntity = new InterfaceHttpEntity();
        interfaceHttpEntity.setId(simpleDateFormat.format(date));
        interfaceHttpEntity.setAppId(this.getAppIdInput());
        interfaceHttpEntity.setProtocol(this.getProtocolInput());
        interfaceHttpEntity.setMethod(this.getMethodInput());
        interfaceHttpEntity.setTransformat(this.getTransformatInput());
        interfaceHttpEntity.setAddress(this.getAddressInput());
        interfaceHttpEntity.setName(this.getNameInput());
        interfaceHttpEntity.setDescription(this.getDescriptionInput());
        interfaceHttpEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceHttpEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
        return interfaceHttpEntity;
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
            interfaceParamEntity.setInterfaceType(InterfaceTypeEnum.HTTP.name());
            interfaceParamEntity.setParamName(this.getParamNamesInput()[i]);
            interfaceParamEntity.setParamType(this.getParamTypesInput()[i]);
            interfaceParamEntity.setParamDescribe(this.getParamDescribesInput()[i]);
            interfaceParamEntity.setRequired(this.getRequiredsInput()[i]);
            interfaceParamEntity.setJsontransformat(this.getJsontransformatsInput()[i]);
            interfaceParamEntity.setExample(this.getExamplesInput()[i]);
            interfaceParamEntity.setDefaultValue(this.getDefaultValuesInput()[i]);
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
        interfaceResultEntity1.setInterfaceType(InterfaceTypeEnum.HTTP.name());
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
        interfaceResultEntity2.setInterfaceType(InterfaceTypeEnum.HTTP.name());
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
