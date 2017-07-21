package com.bozhong.insistapi.service.impl;

import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.dao.MongoDao;
import com.bozhong.insistapi.service.MongoService;

import java.util.List;

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
    public <T> List<T> getListByAppId(String appId, Class<T> tClass) {
        return mongoDao.getListByAppId(appId, tClass);
    }

    @Override
    public <T> T getOneByInterfaceId(String interfaceId, Class<T> tClass) {
        return mongoDao.getOneByInterfaceId(interfaceId, tClass);
    }

    public void setMongoDao(MongoDao mongoDao) {
        this.mongoDao = mongoDao;
    }

}
