package com.bozhong.insistapi.dao.impl;

import com.bozhong.config.common.MongoDBConfig;
import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.dao.MongoDao;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.*;

import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by xiezg@317hu.com on 2017/4/14 0014.
 */
public class MongoDaoImpl implements MongoDao {
    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Override
    public <T> void insertOne(T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.insertOne(document);
    }

    @Override
    public <T> void insertMany(List<T> tlist, Class<T> tClass) {
        Gson gson = new Gson();
        List<Document> documentList = gson.fromJson(gson.toJson(tlist), new TypeToken<List<Document>>() {
        }.getType());
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        mongoCollection.insertMany(documentList);
    }

    @Override
    public <T> long findCount(Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        return mongoCollection.count();
    }

    @Override
    public <T> JqPage<T> getJqPage(JqPage<T> jqPage, Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        FindIterable<Document> findIterable = mongoCollection.find().sort(descending("createTimeStamp"))
                .skip(jqPage.getFromIndex()).limit(jqPage.getPageSize());
        Iterator<Document> iterator = findIterable.iterator();
        List<T> rows = new ArrayList<>(jqPage.getPageSize());
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            rows.add(gson.fromJson(document.toJson(), tClass));
        }
        jqPage.setRecords((int) mongoCollection.count());
        jqPage.setRows(rows);
        return jqPage;
    }

    @Override
    public <T> List<T> getListByAppId(String appId, Class<T> tClass) {
        Assert.notNull(appId, "appId can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = eq("appId", appId);
        FindIterable<Document> findIterable = mongoCollection.find(filter);
        Iterator<Document> iterator = findIterable.iterator();
        List<T> tList = new ArrayList<T>();
        Gson gson = new Gson();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            tList.add(gson.fromJson(document.toJson(), tClass));
        }
        return tList;
    }
}
