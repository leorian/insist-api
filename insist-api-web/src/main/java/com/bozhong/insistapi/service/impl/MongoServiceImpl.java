package com.bozhong.insistapi.service.impl;

import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.dao.MongoDao;
import com.bozhong.insistapi.service.MongoService;

import java.util.List;
import java.util.Map;

/**
 * Created by xiezg@317hu.com on 2017/4/14 0014.
 */
public class MongoServiceImpl implements MongoService {
    private MongoDao mongoDao;

    @Override
    public <T> void insertOne(T t) {
        mongoDao.insertOne(t);
    }

    @Override
    public <T> T findOneByAppId(String appId, Class<T> tClass) {
        return mongoDao.findOneByAppId(appId, tClass);
    }

    @Override
    public <T> T findOneByAccessName(String accessName, Class<T> tClass) {
        return mongoDao.findOneByAccessName(accessName, tClass);
    }

    @Override
    public <T> void findOneAndUpdateByAccessName(String accessName, Class<T> tClass) {
        mongoDao.findOneAndUpdateByAccessName(accessName, tClass);
    }

    @Override
    public <T> T findOneByLoggerId(String loggerId, Class<T> tClass) {
        return mongoDao.findOneByLoggerId(loggerId, tClass);
    }

    @Override
    public <T> T findOneByInterfaceCategoryId(String interfaceCategoryId, Class<T> tClass) {
        return mongoDao.findOneByInterfaceCategoryId(interfaceCategoryId, tClass);
    }

    @Override
    public <T> void updateOneByAppId(String appId, T t) {
        mongoDao.updateOneByAppId(appId, t);
    }

    @Override
    public <T> void updateOneByInterfaceCategoryId(String interfaceCategoryId, T t) {
        mongoDao.updateOneByInterfaceCategoryId(interfaceCategoryId, t);
    }

    @Override
    public <T> void insertMany(List<T> list, Class<T> tClass) {
        mongoDao.insertMany(list, tClass);
    }

    @Override
    public <T> long findCount(Class<T> tClass) {
        return mongoDao.findCount(tClass);
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> jqPage, Class<T> tClass) {
        return mongoDao.getJqPage(jqPage, tClass);
    }

    @Override
    public <T> JqPage<T> getJqPageByCondition(String appId, String loggerContent, JqPage<T> jqPage, Class<T> tClass) {
        return mongoDao.getJqPageByCondition(appId, loggerContent, jqPage, tClass);
    }

    @Override
    public <T> List<T> getListByAppId(String appId, Class<T> tClass) {
        return mongoDao.getListByAppId(appId, tClass);
    }

    @Override
    public <T> List<T> getListByAppIdAndCategory(String appId, String category, Class<T> tClass) {
        return mongoDao.getListByAppIdAndCategory(appId, category, tClass);
    }

    @Override
    public <T> List<T> findListByInterfaceAppId(String interfaceAppId, Class<T> tClass) {
        return mongoDao.findListByInterfaceAppId(interfaceAppId, tClass);
    }

    @Override
    public <T> T getOneByInterfaceId(String interfaceId, Class<T> tClass) {
        return mongoDao.getOneByInterfaceId(interfaceId, tClass);
    }

    @Override
    public <T> T getOneByMockAddress(String mockAddress, Class<T> tClass) {
        return mongoDao.getOneByMockAddress(mockAddress, tClass);
    }

    @Override
    public <T> T getOneByMethodAndAddress(String appId, String method, String address, Class<T> tClass) {
        return mongoDao.getOneByMethodAndAddress(appId, method, address, tClass);
    }

    @Override
    public <T> void updateOneByKey(String interfaceId, T t) {
        mongoDao.updateOneByKey(interfaceId, t);
    }

    @Override
    public <T> void deleteOneByKey(String interfaceId, Class<T> tClass) {
        mongoDao.deleteOneByKey(interfaceId, tClass);
    }

    @Override
    public <T> void deleteOneByInterfaceCategoryId(String interfaceCategoryId, Class<T> tClass) {
        mongoDao.deleteOneByInterfaceCategoryId(interfaceCategoryId, tClass);
    }

    @Override
    public <T> Map<String, Integer> categoryCountGroupByAppId(String appId, Class<T> tClass) {
        return mongoDao.categoryCountGroupByAppId(appId, tClass);
    }

    @Override
    public <T> Map<String, Integer> appCategoryCountGroup(Class<T> tClass) {
        return mongoDao.appCategoryCountGroup(tClass);
    }

    @Override
    public <T> Map<String, Integer> appInterfaceCountGroup(Class<T> tClass) {
        return mongoDao.appInterfaceCountGroup(tClass);
    }

    @Override
    public <T> Map<String, Integer> operatorCountMap(Class<T> tClass) {
        return mongoDao.operatorCountMap(tClass);
    }

    public void setMongoDao(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

}
