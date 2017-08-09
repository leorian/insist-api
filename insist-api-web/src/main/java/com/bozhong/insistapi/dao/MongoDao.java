package com.bozhong.insistapi.dao;


import com.bozhong.config.domain.JqPage;

import java.util.List;

/**
 * Created by xiezg@317hu.com on 2017/4/14 0014.
 */
public interface MongoDao {
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
     * @param appId
     * @param t
     * @param <T>
     */
    <T> void updateOneByAppId(String appId, T t);

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
     * @param tClass
     * @param <T>
     * @return
     */
    <T> List<T> getListByAppId(String appId, Class<T> tClass);

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
     * @param appId
     * @param method
     * @param address
     * @param tClass
     * @param <T>
     * @return
     */
    <T> T getOneByMethodAndAddress(String appId, String method, String address, Class<T> tClass);
}
