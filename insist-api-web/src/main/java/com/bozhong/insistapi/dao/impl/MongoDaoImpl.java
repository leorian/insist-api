package com.bozhong.insistapi.dao.impl;

import com.bozhong.config.common.MongoDBConfig;
import com.bozhong.config.domain.JqPage;
import com.bozhong.insistapi.dao.MongoDao;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.*;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.regex;
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
    public <T> T findOneByAppId(String appId, Class<T> tClass) {
        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Document document = mongoCollection.find(eq("appId", appId)).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> void updateOneByAppId(String appId, T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.updateOne(eq("appId", appId), new Document("$set", document));
    }

    @Override
    public <T> void updateOneByInterfaceCategoryId(String interfaceCategoryId, T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.updateOne(eq("interfaceCategoryId", interfaceCategoryId),
                new Document("$set", document));
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

    @Override
    public <T> List<T> getListByAppIdAndCategory(String appId, String category, Class<T> tClass) {
        Assert.notNull(appId, "appId can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = and(eq("appId", appId), eq("category", category));
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

    @Override
    public <T> List<T> findListByInterfaceAppId(String interfaceAppId, Class<T> tClass) {
        Assert.notNull(interfaceAppId, "interfaceAppId can't be null!");
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Bson filter = eq("interfaceAppId", interfaceAppId);
        FindIterable<Document> findIterable = mongoCollection.find(filter);
        Iterator<Document> iterator = findIterable.iterator();
        List<T> tList = new ArrayList<>();
        Gson gson = new Gson();
        while (iterator.hasNext()) {
            Document document = iterator.next();
            tList.add(gson.fromJson(document.toJson(), tClass));
        }
        return tList;
    }

    @Override
    public <T> T getOneByInterfaceId(String interfaceId, Class<T> tClass) {
        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Document document = mongoCollection.find(eq("id", interfaceId)).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> T getOneByMockAddress(String mockAddress, Class<T> tClass) {
        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Document document = mongoCollection.find(eq("mockAddress", mockAddress)).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> void updateOneByKey(String interfaceId, T t) {
        Gson gson = new Gson();
        Document document = gson.fromJson(t.toString(), Document.class);
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(t.getClass());
        mongoCollection.updateOne(eq("id", interfaceId), new Document("$set", document));
    }

    @Override
    public <T> void deleteOneByKey(String interfaceId, Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        mongoCollection.deleteOne(eq("id", interfaceId));
    }

    @Override
    public <T> void deleteOneByInterfaceCategoryId(String interfaceCategoryId, Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        mongoCollection.deleteOne(eq("interfaceCategoryId", interfaceCategoryId));
    }

    @Override
    public <T> T getOneByMethodAndAddress(String appId, String method, String address, Class<T> tClass) {
        Gson gson = new Gson();
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        Document document = mongoCollection.find(and(regex("method", "^.*" + method + ".*$"),
                eq("address", address), eq("appId", appId))).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), tClass);
        }

        return null;
    }

    @Override
    public <T> Map<String, Integer> categoryCountGroupByAppId(String appId, Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        AggregateIterable<Document> aggregateIterable = mongoCollection.aggregate(Arrays.asList(new Document("$match",
                        new Document("appId", new Document("$eq", appId))),
                new Document("$project",
                        new Document("id", 1).append("_id", 0).append("category", 1)),
                new Document("$unwind", "$category"),
                new Document("$group", new Document("_id", "$category").append("count", new Document("$sum", 1)))));
        MongoCursor<Document> mongoCursor = aggregateIterable.iterator();
        Map<String, Integer> appCountMap = new HashMap<>();
        while (mongoCursor.hasNext()) {
            Document document = mongoCursor.next();
            appCountMap.put(document.getString("_id"), document.getInteger("count"));
        }

        return appCountMap;
    }

    @Override
    public <T> Map<String, Integer> appCategoryCountGroup(Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        AggregateIterable<Document> aggregateIterable = mongoCollection.aggregate(Arrays.asList(
                new Document("$project", new Document("interfaceCategoryId", 1).append("_id", 0).append("interfaceAppId", 1)),
                new Document("$unwind", "$interfaceAppId"),
                new Document("$group", new Document("_id", "$interfaceAppId").append("count", new Document("$sum", 1)))
        ));
        MongoCursor<Document> mongoCursor = aggregateIterable.iterator();
        Map<String, Integer> appCategoryCountMap = new HashMap<>();
        while (mongoCursor.hasNext()) {
            Document document = mongoCursor.next();
            appCategoryCountMap.put(document.getString("_id"), document.getInteger("count"));
        }

        return appCategoryCountMap;
    }

    @Override
    public <T> Map<String, Integer> appInterfaceCountGroup(Class<T> tClass) {
        MongoCollection<Document> mongoCollection = mongoDBConfig.getCollection(tClass);
        AggregateIterable<Document> aggregateIterable = mongoCollection.aggregate(Arrays.asList(
                new Document("$project", new Document("id", 1).append("_id", 0).append("appId", 1)),
                new Document("$unwind", "$appId"),
                new Document("$group", new Document("_id", "$appId").append("count", new Document("$sum", 1)))
        ));
        MongoCursor<Document> mongoCursor = aggregateIterable.iterator();
        Map<String, Integer> appInterfaceCountMap = new HashMap<>();
        while (mongoCursor.hasNext()) {
            Document document = mongoCursor.next();
            appInterfaceCountMap.put(document.getString("_id"), document.getInteger("count"));
        }

        return appInterfaceCountMap;
    }
}
