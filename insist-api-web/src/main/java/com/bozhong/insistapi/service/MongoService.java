package com.bozhong.insistapi.service;

import com.bozhong.config.domain.JqPage;

import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/4/14 0014.
 */
public interface MongoService {

    /**
     * @param t
     * @param <T>
     */
    <T> void insertOne(T t);

    /**
     * @param appId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByAppId(String appId, Class<T> tClass);

    /**
     * 查询某个人的访问量
     *
     * @param accessName
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByAccessName(String accessName, Class<T> tClass);

    /**
     * @param accessName
     * @param tClass
     * @param <T>
     * @return
     */
    <T> void findOneAndUpdateByAccessName(String accessName, Class<T> tClass);

    /**
     * @param loggerId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByLoggerId(String loggerId, Class<T> tClass);

    /**
     * @param interfaceCategoryId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T findOneByInterfaceCategoryId(String interfaceCategoryId, Class<T> tClass);

    /**
     * @param appId
     * @param t
     * @param <T>
     */
    <T> void updateOneByAppId(String appId, T t);

    /**
     * @param interfaceCategoryId
     * @param t
     * @param <T>
     */
    <T> void updateOneByInterfaceCategoryId(String interfaceCategoryId, T t);

    /**
     * @param tList
     * @param tClass
     * @param <T>
     */
    <T> void insertMany(List<T> tList, Class<T> tClass);


    /**
     * @param tClass
     * @param <T>
     * @return
     */
    <T> long findCount(Class<T> tClass);


    /**
     * @param jqPage
     * @param tClass
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPage(JqPage<T> jqPage, Class<T> tClass);

    /**
     * @param appId
     * @param loggerContent
     * @param jqPage
     * @param tClass
     * @param <T>
     * @return
     */
    <T> JqPage<T> getJqPageByCondition(String appId, String loggerContent, JqPage<T> jqPage, Class<T> tClass);

    /**
     * @param appId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> List<T> getListByAppId(String appId, Class<T> tClass);

    /**
     * @param appId
     * @param category
     * @param tClass
     * @param <T>
     * @return
     */
    <T> List<T> getListByAppIdAndCategory(String appId, String category, Class<T> tClass);

    /**
     * @param interfaceAppId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> List<T> findListByInterfaceAppId(String interfaceAppId, Class<T> tClass);

    /**
     * @param interfaceId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T getOneByInterfaceId(String interfaceId, Class<T> tClass);

    /**
     * @param mockAddress
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T getOneByMockAddress(String mockAddress, Class<T> tClass);

    /**
     * @param appId
     * @param method
     * @param address
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T getOneByMethodAndAddress(String appId, String method, String address, Class<T> tClass);

    /**
     * @param interfaceId
     * @param t
     * @param <T>
     */
    <T> void updateOneByKey(String interfaceId, T t);

    /**
     * @param interfaceId
     * @param tClass
     * @param <T>
     */
    <T> void deleteOneByKey(String interfaceId, Class<T> tClass);


    /**
     * @param interfaceCategoryId
     * @param tClass
     * @param <T>
     */
    <T> void deleteOneByInterfaceCategoryId(String interfaceCategoryId, Class<T> tClass);

    /**
     * 类别数量统计
     *
     * @param appId
     * @param tClass
     * @param <T>
     * @return
     */
    <T> Map<String, Integer> categoryCountGroupByAppId(String appId, Class<T> tClass);

    /**
     * 应用类别个数统计
     *
     * @param tClass
     * @param <T>
     * @return
     */
    <T> Map<String, Integer> appCategoryCountGroup(Class<T> tClass);

    /**
     * 应用接口个数统计
     *
     * @param tClass
     * @param <T>
     * @return
     */
    <T> Map<String, Integer> appInterfaceCountGroup(Class<T> tClass);

    /**
     * 操作记录统计
     *
     * @param tClass
     * @param <T>
     * @return
     */
    <T> Map<String, Integer> operatorCountMap(Class<T> tClass);


}
