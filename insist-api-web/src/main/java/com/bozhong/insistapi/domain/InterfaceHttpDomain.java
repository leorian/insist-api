package com.bozhong.insistapi.domain;

import com.alibaba.fastjson.JSON;
import com.bozhong.insistapi.entity.*;
import com.bozhong.insistapi.enums.ExampleTypeEnum;
import com.bozhong.insistapi.enums.InterfaceTypeEnum;
import com.yx.eweb.main.EWebServletContext;

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

    /*请求头部*/
    private String[] paramNamesHeaderInput;
    private String[] paramTypesHeaderInput;
    private String[] paramDescribesHeaderInput;
    private String[] examplesHeaderInput;
    private String[] exampleDetailsHeaderInput;
    private String[] defaultValueDetailsHeaderInput;

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


    private String mockAddressInput;
    private String devAddressInput;
    private String sitAddressInput;
    private String uatAddressInput;
    private String prdAddressInput;


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

    public String[] getParamNamesHeaderInput() {
        return paramNamesHeaderInput;
    }

    public void setParamNamesHeaderInput(String[] paramNamesHeaderInput) {
        this.paramNamesHeaderInput = paramNamesHeaderInput;
    }

    public String[] getParamTypesHeaderInput() {
        return paramTypesHeaderInput;
    }

    public void setParamTypesHeaderInput(String[] paramTypesHeaderInput) {
        this.paramTypesHeaderInput = paramTypesHeaderInput;
    }

    public String[] getParamDescribesHeaderInput() {
        return paramDescribesHeaderInput;
    }

    public void setParamDescribesHeaderInput(String[] paramDescribesHeaderInput) {
        this.paramDescribesHeaderInput = paramDescribesHeaderInput;
    }

    public String[] getExamplesHeaderInput() {
        return examplesHeaderInput;
    }

    public void setExamplesHeaderInput(String[] examplesHeaderInput) {
        this.examplesHeaderInput = examplesHeaderInput;
    }

    public String[] getExampleDetailsHeaderInput() {
        return exampleDetailsHeaderInput;
    }

    public void setExampleDetailsHeaderInput(String[] exampleDetailsHeaderInput) {
        this.exampleDetailsHeaderInput = exampleDetailsHeaderInput;
    }

    public String[] getDefaultValueDetailsHeaderInput() {
        return defaultValueDetailsHeaderInput;
    }

    public void setDefaultValueDetailsHeaderInput(String[] defaultValueDetailsHeaderInput) {
        this.defaultValueDetailsHeaderInput = defaultValueDetailsHeaderInput;
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

    public String getMockAddressInput() {
        return mockAddressInput;
    }

    public void setMockAddressInput(String mockAddressInput) {
        this.mockAddressInput = mockAddressInput;
    }

    public String getDevAddressInput() {
        return devAddressInput;
    }

    public void setDevAddressInput(String devAddressInput) {
        this.devAddressInput = devAddressInput;
    }

    public String getSitAddressInput() {
        return sitAddressInput;
    }

    public void setSitAddressInput(String sitAddressInput) {
        this.sitAddressInput = sitAddressInput;
    }

    public String getUatAddressInput() {
        return uatAddressInput;
    }

    public void setUatAddressInput(String uatAddressInput) {
        this.uatAddressInput = uatAddressInput;
    }

    public String getPrdAddressInput() {
        return prdAddressInput;
    }

    public void setPrdAddressInput(String prdAddressInput) {
        this.prdAddressInput = prdAddressInput;
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
        interfaceHttpEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceHttpEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceHttpEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceHttpEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
        interfaceHttpEntity.setMockAddress(this.getMockAddressInput());
        interfaceHttpEntity.setDevAddress(this.getDevAddressInput());
        interfaceHttpEntity.setSitAddress(this.getSitAddressInput());
        interfaceHttpEntity.setUatAddress(this.getUatAddressInput());
        interfaceHttpEntity.setPrdAddress(this.getPrdAddressInput());
        return interfaceHttpEntity;
    }

    public List<InterfaceParamHeaderEntity> buildInterfaceParamHeaderEntities(String interfaceId) {
        if (this.getParamNamesHeaderInput() == null || this.getParamNamesHeaderInput().length == 0) {
            return null;
        }

        List<InterfaceParamHeaderEntity> interfaceParamHeaderEntities = new ArrayList<>(this.getParamNamesHeaderInput().length);
        for (int i = 0; i < this.getParamNamesHeaderInput().length; i++) {
            InterfaceParamHeaderEntity interfaceParamHeaderEntity = new InterfaceParamHeaderEntity();
            try {
                Thread.sleep(10l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            interfaceParamHeaderEntity.setId(simpleDateFormat.format(date));
            interfaceParamHeaderEntity.setInterfaceId(interfaceId);
            interfaceParamHeaderEntity.setInterfaceType(InterfaceTypeEnum.HTTP.name());
            interfaceParamHeaderEntity.setParamNameHeader(this.getParamNamesHeaderInput()[i]);
            interfaceParamHeaderEntity.setParamTypeHeader(this.getParamTypesHeaderInput()[i]);
            interfaceParamHeaderEntity.setParamDescribeHeader(this.getParamDescribesHeaderInput()[i]);
            interfaceParamHeaderEntity.setExampleHeader(this.getExamplesHeaderInput()[i]);
            interfaceParamHeaderEntity.setExampleDetailHeader(this.getExampleDetailsHeaderInput()[i]);
            interfaceParamHeaderEntity.setDefaultValueDetailHeader(this.getDefaultValueDetailsHeaderInput()[i]);
            interfaceParamHeaderEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
            interfaceParamHeaderEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamHeaderEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
            interfaceParamHeaderEntity.setUpdateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamHeaderEntities.add(interfaceParamHeaderEntity);
        }

        return interfaceParamHeaderEntities;
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
            interfaceParamEntity.setExampleDetail(this.getExampleDetailsInput()[i]);
            interfaceParamEntity.setDefaultValueDetail(this.getDefaultValueDetailsInput()[i]);
            interfaceParamEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
            interfaceParamEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
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
            interfaceParamResponseEntity.setInterfaceType(InterfaceTypeEnum.HTTP.name());
            interfaceParamResponseEntity.setParamNameResponse(this.getParamNamesResponseInput()[i]);
            interfaceParamResponseEntity.setParamTypeResponse(this.getParamTypesResponseInput()[i]);
            interfaceParamResponseEntity.setParamDescribeResponse(this.getParamDescribesResponseInput()[i]);
            interfaceParamResponseEntity.setExampleResponse(this.getExamplesResponseInput()[i]);
            interfaceParamResponseEntity.setExampleDetailResponse(this.getExampleDetailsResponseInput()[i]);
            interfaceParamResponseEntity.setDefaultValueDetailResponse(this.getDefaultValueDetailsResponseInput()[i]);
            interfaceParamResponseEntity.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
            interfaceParamResponseEntity.setCreateDateTime(simpleDateFormat.format(new Date()));
            interfaceParamResponseEntity.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
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
        interfaceResultEntity1.setInterfaceType(InterfaceTypeEnum.HTTP.name());
        interfaceResultEntity1.setExampleType(ExampleTypeEnum.NORMAL.name());
        interfaceResultEntity1.setExampleContent(this.getReturnExampleContent());
        interfaceResultEntity1.setAttentionMatters(this.getReturnExampleAttentionMatters());
        interfaceResultEntity1.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceResultEntity1.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntity1.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
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
        interfaceResultEntity2.setCreateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceResultEntity2.setCreateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntity2.setUpdateUserId((String) EWebServletContext.getRequest().getAttribute("uId"));
        interfaceResultEntity2.setUpdateDateTime(simpleDateFormat.format(new Date()));
        interfaceResultEntities.add(interfaceResultEntity2);
        return interfaceResultEntities;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
