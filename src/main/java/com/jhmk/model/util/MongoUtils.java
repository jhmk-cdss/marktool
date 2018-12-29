//package com.jhmk.model.util;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.mongodb.*;
//import com.mongodb.client.*;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.UpdateOptions;
//import com.mongodb.client.result.DeleteResult;
//import jhmk.clinic.core.config.CdssConstans;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.bson.types.ObjectId;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * MONGODB数据操作工具类
// */
//public class MongoUtils {
//    private static final Map<String, String> BasicDBObject = null;
//    private static MongoClient mongoClient;
//    private static final Logger logger = LoggerFactory.getLogger(MongoUtils.class);
//
//    static {
//        if (mongoClient == null) {
//            MongoClientOptions.Builder options = new MongoClientOptions.Builder();
//            options.connectionsPerHost(100);// 连接池设置为300个连接,默认为100
//            options.connectTimeout(10000);// 连接超时，推荐>3000毫秒
//            options.maxWaitTime(10000); //
//            options.socketTimeout(0);// 套接字超时时间，0无限制
//            // 线程队列数，如果连接线程排满了队列就会抛出“Out of semaphores to get db”错误。
//            options.threadsAllowedToBlockForConnectionMultiplier(10);
//            options.writeConcern(WriteConcern.SAFE);
//            options.build();
//            MongoClientOptions myOptions = options.build();
//            try {
//                //数据库连接实例
//
//                List<ServerAddress> serverAddressList = new ArrayList<>();
//                ServerAddress address = new ServerAddress(CdssConstans.HOST, CdssConstans.PORT);
////				ServerAddress address = new ServerAddress("172.16.19.212",20000);
//                serverAddressList.add(address);
//                mongoClient = new MongoClient(address, myOptions);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static MongoDatabase getDB(String dbName) {
//        if (dbName != null && !"".equals(dbName)) {
//            MongoDatabase database = mongoClient.getDatabase(dbName);
//            return database;
//        }
//        return null;
//    }
//
//    public static MongoCollection<Document> getCollection(String dbName, String collName) {
//        if (null == collName || "".equals(collName)) {
//            return null;
//        }
//        if (null == dbName || "".equals(dbName)) {
//            return null;
//        }
//        MongoCollection<Document> collection = mongoClient.getDatabase(dbName).getCollection(collName);
////		System.out.println(collection);
//        return collection;
//    }
//
//    public static List<String> getAllCollections(String dbName) {
//        MongoIterable<String> colls = getDB(dbName).listCollectionNames();
//        List<String> _list = new ArrayList<String>();
//        for (String s : colls) {
//            _list.add(s);
//        }
//        return _list;
//    }
//
//    public static MongoIterable<String> getAllDBNames() {
//        MongoIterable<String> s = mongoClient.listDatabaseNames();
//        return s;
//    }
//
//    public static void dropDB(String dbName) {
//        getDB(dbName).drop();
//    }
//
//    public static void dropCollection(String dbName, String collName) {
//        getDB(dbName).getCollection(collName).drop();
//    }
//
//    public static Document findById(MongoCollection<Document> coll, String id) {
//        try {
//            ObjectId _id = null;
//            try {
//                _id = new ObjectId(id);
//            } catch (Exception e) {
//                return null;
//            }
//            Document myDoc = coll.find(Filters.eq("_id", _id)).first();
//            return myDoc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    public static Document findByNames(MongoCollection<Document> coll,
//                                       Bson filter) {
//        try {
//            return coll.find(filter).first();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Document findByNames(MongoCollection<Document> coll,
//                                       Map<String, Object> map) {
//        try {
//            return coll.find(new BasicDBObject(map)).first();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    public static int getCount(MongoCollection<Document> coll) {
//        try {
//            int count = (int) coll.count();
//            return count;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static int getCount(String collName) {
//        try {
//            MongoCollection<Document> collection = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//            int count = (int) collection.count();
//            return count;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static MongoCursor<Document> find(MongoCollection<Document> coll,
//                                             Bson filter) {
//        try {
//            return coll.find(filter).iterator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static MongoCursor<Document> find(MongoCollection<Document> coll,
//                                             Map<String, Object> map) {
//        try {
//            return coll.find(new BasicDBObject(map)).iterator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    /**
//     * @param coll   document coll
//     * @param map    查询条件map
//     * @param fields 指定返回字段
//     * @return
//     */
//    public static MongoCursor<Document> find(MongoCollection<Document> coll,
//                                             Map<String, Object> map, List<String> fields) {
//        com.mongodb.BasicDBObject ob = new BasicDBObject(map);
//        Document include = new Document();
//        for (String string : fields) {
//            include.append(string, 1);
//        }
//        try {
//            return coll.find(ob).projection(include).iterator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 指定嵌套字段查询，返回对应字段为key，结果为value的map
//     *
//     * @param coll   document coll
//     * @param map    查询条件map
//     * @param fields 指定返回字段
//     * @return
//     */
//    public static List<Map<String, String>> findMapResult(MongoCollection<Document> coll,
//                                                          Map<String, Object> map, List<String> fields) {
//        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
//
//        com.mongodb.BasicDBObject ob = new BasicDBObject(map);
//        Document include = new Document();
//        for (String string : fields) {
//            include.append(string, 1);
//        }
//        try {
//            MongoCursor<Document> resultCursor = coll.find(ob).projection(include).iterator();
//            Document doc = null;
//            while (resultCursor.hasNext()) {
//                Map<String, String> resultMap = new HashMap<String, String>();
//                doc = resultCursor.next();
//                for (String fieldTmp : fields) {
//                    if (fieldTmp.contains(".")) {
//                        String field[] = fieldTmp.split("\\.");
//                        Document docTmp = doc;
//                        for (int i = 0; i < (field.length - 1); i++) {
//                            docTmp = docTmp.get(field[i], Document.class);
//                        }
//                        if (docTmp != null) {
//                            String value = String.valueOf(docTmp.get(field[field.length - 1]));
//                            resultMap.put(fieldTmp, value);
//                        }
//                    } else {
//                        String value = String.valueOf(doc.get(fieldTmp));
//                        resultMap.put(fieldTmp, value);
//                    }
//                }
//                doc = null;
//                resultList.add(resultMap);
//            }
//            resultCursor = null;
//            return resultList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static List<Map<String, String>> findMapResultbyId(MongoCollection<Document> coll,
//                                                              String _id, List<String> fields) {
//        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
//        com.mongodb.BasicDBObject ob = new BasicDBObject("_id", _id);
//        Document include = new Document();
//        for (String string : fields) {
//            include.append(string, 1);
//        }
//        try {
//            MongoCursor<Document> resultCursor = coll.find(ob).projection(include).iterator();
//            while (resultCursor.hasNext()) {
//                Map<String, String> resultMap = new HashMap<String, String>();
//                Document doc = resultCursor.next();
//                for (String fieldTmp : fields) {
//                    if (fieldTmp.contains(".")) {
//                        String field[] = fieldTmp.split("\\.");
//                        Document docTmp = doc;
//                        for (int i = 0; i < (field.length - 1); i++) {
//                            docTmp = docTmp.get(field[i], Document.class);
//                        }
//                        String value = String.valueOf(docTmp.get(field[field.length - 1]));
//                        resultMap.put(fieldTmp, value);
//                    } else {
//                        String value = String.valueOf(doc.get(fieldTmp));
//                        resultMap.put(fieldTmp, value);
//                    }
//                }
//                resultList.add(resultMap);
//            }
//            return resultList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Map<String, List<Map<String, String>>> findMapResultbyIdList(MongoCollection<Document> coll,
//                                                                               List<String> idList, List<String> fields) {
//        Map<String, List<Map<String, String>>> resultListMap = new HashMap<String, List<Map<String, String>>>();
//        Document idQuery = new Document("_id", new Document("$in", idList));
//        Document include = new Document();
//        for (String string : fields) {
//            include.append(string, 1);
//        }
//        include.append("_id", 1);
//        try {
//            MongoCursor<Document> resultCursor = coll.find(idQuery).projection(include).iterator();
//            while (resultCursor.hasNext()) {
//                List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
//                Map<String, String> resultMap = new HashMap<String, String>();
//                Document doc = resultCursor.next();
//                String _id = doc.getString("_id");
//                for (String fieldTmp : fields) {
//                    if (fieldTmp.contains(".")) {
//                        String field[] = fieldTmp.split("\\.");
//                        Document docTmp = doc;
//                        for (int i = 0; i < (field.length - 1); i++) {
//                            docTmp = docTmp.get(field[i], Document.class);
//                        }
//                        String value = String.valueOf(docTmp.get(field[field.length - 1]));
//                        resultMap.put(fieldTmp, value);
//                    } else {
//                        String value = String.valueOf(doc.get(fieldTmp));
//                        resultMap.put(fieldTmp, value);
//                    }
//                }
//                resultList.add(resultMap);
//                resultListMap.put(_id, resultList);
//            }
//            return resultListMap;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static JSONObject findJsonResultByKey(String collName, String key, String value, String field) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONObject result = new JSONObject();
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            MongoCursor<Document> resultCursor = coll.find(new Document(key, value)).projection(include).iterator();
//            while (resultCursor.hasNext()) {
//                Document doc = resultCursor.next();
//                JSONObject _value = JSONObject.parseObject(doc.toJson());
//                result.put(_value.getString(field), _value.getString("_id"));
//            }
//            end = System.currentTimeMillis();
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + key + ":" + value + " not exist!";
//        }
//        return null;
//    }
//
//    public static JSONArray findJsonResultByKey(String collName, String key, String value) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONArray result = new JSONArray();
//        try {
//            MongoCursor<Document> resultCursor = coll.find(new Document(key, value)).iterator();
//            while (resultCursor.hasNext()) {
//                Document doc = resultCursor.next();
//                JSONObject _value = JSONObject.parseObject(doc.toJson());
//                result.add(_value);
//            }
//            end = System.currentTimeMillis();
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + key + ":" + value + " not exist!";
//        }
//        return null;
//    }
//
//    public static JSONObject findJsonResultByID(String collName, String _id, String field) {
//        JSONObject result = new JSONObject();
//        long start = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            Document document = coll.find(new Document("_id", _id)).projection(include).first();
//            result = JSONObject.parseObject(document.toJson());
//            //清空资源
//            include = null;
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + _id + " not exist!";
//        } catch (OutOfMemoryError e) {
//            logger.error("MongoUtils OutOfMemoryError-- _id" + _id + "|" + "collName" + collName + "|" + "message:" + e.getMessage());
//        }
//        return null;
//    }
//
//    public static void findJsonResultByID2(String collName, String _id, String field) {
//        long start = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            FindIterable iterable = coll.find(new Document("_id", _id));
//            long end = System.currentTimeMillis();
//            String msg = "[" + collName + "]" + _id + " not exist!";
//            if (iterable != null) {
//            } else {
//            }
//            //清空资源
//            include = null;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + _id + " not exist!";
//        } catch (OutOfMemoryError e) {
//            logger.error("MongoUtils OutOfMemoryError-- _id" + _id + "|" + "collName" + collName + "|" + "message:" + e.getMessage());
//        }
//    }
//
//    /**
//     * querymongoDB读数据
//     */
//    public static JSONObject queryJsonResultByID(String collName, String _id, String field) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            Document myDoc = coll.find(new Document("_id", _id)).projection(include).first();
//            String value = myDoc.toJson();
//            JSONObject result = JSONObject.parseObject(value);
//            end = System.currentTimeMillis();
//            //清空资源
//            include = null;
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + _id + " not exist!";
//        } catch (OutOfMemoryError e) {
//            logger.error("MongoUtils OutOfMemoryError-- _id" + _id + "|" + "collName" + collName + "|" + "message:" + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * mongo id统计
//     */
//    public static JSONObject getAllID(String collName, int size, String file) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONObject result = null;
//        Document include = new Document();
//        include.append("", 1);
//        long allCount = coll.count();
//        System.out.println("-------" + allCount);
//        long sum = 0;
//        String lastId = "";
//        try {
//            FindIterable<Document> limit = null;
//            limit = coll.find().sort(new BasicDBObject("_id", 1)).limit(size);
//            for (Document doc : limit) {
//                String id = doc.getString("_id");
////	        	FileUtils.writeFileByLine(file,id+System.lineSeparator()); todo 注释掉了
//
//                sum++;
//                lastId = id;
//            }
//            end = System.currentTimeMillis();
//            System.out.println("当前位置： " + sum + "耗时" + (end - start) / 1000);
//            for (; sum < allCount; ) {
//                limit = coll
//                        .find(new BasicDBObject("_id", new BasicDBObject(
//                                QueryOperators.GT, lastId)))
//                        .sort(new BasicDBObject("_id", 1)).limit(size);
//                for (Document doc : limit) {
//                    String id = doc.getString("_id");
////		        	FileUtils.writeFileByLine(file,id+System.lineSeparator());
//                    sum++;
//                    lastId = id;
//                }
//                end = System.currentTimeMillis();
//                System.out.println("当前位置： " + sum + "耗时" + (end - start) / 1000);
//            }
//
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "]" + " not exist!";
//        }
//        return null;
//    }
//
//    public static Document findDocumentResult(MongoCollection<Document> coll, String _id) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        try {
//            Document myDoc = coll.find(new Document("_id", _id)).first();
//            return myDoc;
//        } catch (Exception e) {
//            String msg = "" + _id + " not exist!";
//        }
//        return null;
//    }
//
//    public static JSONObject findJsonResult(String collName, String _id, Map<String, MongoCollection<Document>> colls) {
//        JSONObject result = null;
//        MongoCollection<Document> coll = null;
//        try {
//            if (colls.containsKey(collName)) {
//                coll = colls.get(collName);
//            } else {
//                coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//                colls.put(collName, coll);
//            }
//            Document myDoc = coll.find(new Document("_id", _id)).first();
//            String value = myDoc.toJson();
//            result = JSONObject.parseObject(value);
//            return result;
//        } catch (Exception e) {
//
//        }
//        return null;
//    }
//
//    public static JSONObject findJsonResult(String collName, String _id) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONObject result = null;
//        try {
//            Document myDoc = coll.find(new Document("_id", _id)).first();
//            String value = myDoc.toJson();
//            result = JSONObject.parseObject(value);
//            end = System.currentTimeMillis();
//            long cost = end - start;
//            if ((cost / 1000) > 20) {
//                logger.info(MongoUtils.class + " findJsonResultByID [" + _id + "] 用时 [" + cost + "s]");
//            }
//            return result;
//        } catch (Exception e) {
//            String msg = "[" + collName + "] " + _id + " not exist!";
////			logger.error(MongoUtils.class+" hospitalCode [] version ["+Version.version+"] serverip [] clientip [] actionType [数据处理] actionContent [] recordId ["+_id+"] recordType [] resultsign [] resultContent [] errorType [] errorContent [] abnormalInfo["+msg+"] takes ["+(end-start)+"]ms");
//        }
//        return null;
//    }
//
//    public static String findJsonResultHtml(String collName, String _id) {
//        JSONObject fjg = MongoUtils.queryJsonResultByID(collName + "_src", _id, collName + ".MR_CONTENT_HTML");
//        StringBuffer html = new StringBuffer();
//        if (fjg != null && fjg.getJSONArray(collName) != null) {
//            if (fjg.getJSONArray(collName).size() == 1) {
//                html.append(fjg.getJSONArray(collName).getJSONObject(0).getString("MR_CONTENT_HTML") + System.lineSeparator());
//            } else {
//                JSONArray array = fjg.getJSONArray(collName);
//                for (int i = 0; i < array.size(); i++) {
//                    html.append(fjg.getJSONArray(collName).getJSONObject(i).getString("MR_CONTENT_HTML") + System.lineSeparator());
//                }
//            }
//        }
//        return html.toString();
//    }
//
//    public static JSONObject findJsonResult(String collName, Map<String, String> map, String field) {
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONObject result = null;
//        com.mongodb.BasicDBObject query = new BasicDBObject(map);
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            MongoCursor<Document> resultCursor = coll.find(query).iterator();
//            while (resultCursor.hasNext()) {
//                Document doc = resultCursor.next();
//                String value = doc.toJson();
//                result = JSONObject.parseObject(value);
//            }
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static JSONObject findJsonResultByid(String collName, String _id, String field) {
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        JSONObject result = null;
//        com.mongodb.BasicDBObject query = new BasicDBObject("_id", _id);
//        Document include = new Document();
//        include.append(field, 1);
//        try {
//            MongoCursor<Document> resultCursor = coll.find(query).iterator();
//            while (resultCursor.hasNext()) {
//                Document doc = resultCursor.next();
//                String value = doc.toJson();
//                result = JSONObject.parseObject(value);
//            }
//            return result;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static String findStringResult(JSONObject jsonObject, String field) {
//        long start = System.currentTimeMillis();
//        long end = System.currentTimeMillis();
//        String result = null;
//        try {
//            result = getResult(field, jsonObject);
//            end = System.currentTimeMillis();
//        } catch (Exception e) {
//            String msg = "[" + field + "] do not exist!!!";
//        }
//        return result;
//    }
//
//    public static String getResult(String field, JSONObject jsonObject) {
//        if (field.contains(".")) {
//            String[] fields = field.split("\\.", 2);
//            return getResult(fields[1], jsonObject.getJSONObject(fields[0]));
//        } else {
//            return jsonObject.getString(field);
//        }
//    }
//
//    public static MongoCursor<Document> findByPage(
//            MongoCollection<Document> coll, Map<String, Object> map,
//            int pageNo, int pageSize) {
//        try {
//            Bson orderBy = new BasicDBObject("_id", -1);
//            return coll.find(new BasicDBObject(map)).sort(orderBy)
//                    .skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static MongoCursor<Document> findByPage(
//            MongoCollection<Document> coll, String sorting, String name,
//            Map<String, Object> map, int pageNo, int pageSize) {
//        try {
//            Bson orderBy = null;
//            // 降序
//            if (sorting.equals("desc")) {
//                orderBy = new BasicDBObject(name, -1);
//            } else {
//                orderBy = new BasicDBObject(name, 1);
//            }
//            return coll.find(new BasicDBObject(map)).sort(orderBy)
//                    .skip((pageNo - 1) * pageSize).limit(pageSize).iterator();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static int deleteById(MongoCollection<Document> coll, String id) {
//        try {
//            int count = 0;
//            ObjectId _id = null;
//            _id = new ObjectId(id);
//            Bson filter = Filters.eq("_id", _id);
//            DeleteResult deleteResult = coll.deleteOne(filter);
//            count = (int) deleteResult.getDeletedCount();
//            return count;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public static Document updateById(MongoCollection<Document> coll,
//                                      String id, Document newdoc) {
//        ObjectId _idobj = null;
//        try {
//            _idobj = new ObjectId(id);
//            Bson filter = Filters.eq("_id", _idobj);
//            // coll.replaceOne(filter, newdoc); // 完全替代
//            coll.updateOne(filter, new Document("$set", newdoc));
//            return newdoc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Document updateDocByid(MongoCollection<Document> coll,
//                                         String id, Document newdoc) {
//        ObjectId _idobj = null;
//        try {
//            Bson filter = Filters.eq("_id", id);
//            // coll.replaceOne(filter, newdoc); // 完全替代
//            UpdateOptions up = new UpdateOptions();
//            up.upsert(true);
//            coll.updateOne(filter, new Document("$set", newdoc), up);
//            return newdoc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static Document updateByid(MongoCollection<Document> coll,
//                                      String id, Document newdoc) {
//        ObjectId _idobj = null;
//        try {
//            Bson filter = Filters.eq("_id", id);
//            // coll.replaceOne(filter, newdoc); // 完全替代
//            coll.updateOne(filter, new Document("$set", newdoc));
//            return newdoc;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static boolean save(MongoCollection<Document> coll, Document doc) {
//        boolean falg = false;
//        try {
//            coll.insertOne(doc);
//            falg = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("添加异常，异常信息：", e);
//        }
//        return falg;
//    }
//
//    public static boolean save(String collName, JSONObject doc) {
//        if (!MongoUtils.getAllCollections(CdssConstans.DATASOURCE).contains(collName)) {
//            mongoClient.getDatabase(CdssConstans.DATASOURCE).createCollection(collName);
//        }
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        boolean falg = false;
//        try {
//            Document d = new Document();
//            for (String key : doc.keySet()) {
//                d.put(key, doc.get(key));
//            }
//            coll.insertOne(d);
//            falg = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("添加异常，异常信息：", e);
//        }
//        return falg;
//    }
//
//    public static boolean saveJson(String collName, JSONObject doc) {
//        if (!MongoUtils.getAllCollections(CdssConstans.DATASOURCE).contains(collName)) {
//            mongoClient.getDatabase(CdssConstans.DATASOURCE).createCollection(collName);
//        }
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        boolean falg = false;
//        Document d = new Document();
//        try {
//            for (String key : doc.keySet()) {
//                d.put(key, doc.get(key));
//            }
//            Bson filter = Filters.eq("_id", doc.get("_id"));
//            UpdateOptions up = new UpdateOptions();
//            up.upsert(true);
//            coll.updateOne(filter, new Document("$set", d), up);
//            falg = true;
//        } catch (MongoWriteException e) {
//            logger.error(e.toString());
//        }
//        return falg;
//    }
//
//    public static boolean saveJsonArray(String collName, JSONObject doc, String arrayKey) {
//        if (!MongoUtils.getAllCollections(CdssConstans.DATASOURCE).contains(collName)) {
//            mongoClient.getDatabase(CdssConstans.DATASOURCE).createCollection(collName);
//        }
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        boolean falg = false;
//        Document d = new Document();
//        try {
//            Document myDoc = coll.find(new Document("_id", doc.get("_id"))).first();
//            if (myDoc == null || myDoc.isEmpty()) {
//                for (String key : doc.keySet()) {
//                    d.put(key, doc.get(key));
//                }
//                coll.insertOne(d);
//            } else {
//                String value = myDoc.toJson();
//                JSONObject result = JSONObject.parseObject(value);
//                result.getJSONArray(arrayKey).addAll(doc.getJSONArray(arrayKey));
//                for (String key : result.keySet()) {
//                    d.put(key, result.get(key));
//                }
//                Bson filter = Filters.eq("_id", doc.get("_id"));
//                coll.updateOne(filter, new Document("$set", d));
//            }
//            falg = true;
//        } catch (MongoWriteException e) {
//            logger.error(e.toString());
//        }
//        return falg;
//    }
//
//    public static boolean saveJsonArrayList(String collName, JSONObject doc, String arrayKey) {
//        if (!MongoUtils.getAllCollections(CdssConstans.DATASOURCE).contains(collName)) {
//            mongoClient.getDatabase(CdssConstans.DATASOURCE).createCollection(collName);
//        }
//        MongoCollection<Document> coll = mongoClient.getDatabase(CdssConstans.DATASOURCE).getCollection(collName);
//        boolean falg = false;
//        Document d = new Document();
//        try {
//            Document myDoc = coll.find(new Document("_id", doc.get("_id"))).first();
//            if (myDoc == null || myDoc.isEmpty()) {
//                for (String key : doc.keySet()) {
//                    d.put(key, doc.get(key));
//                }
//                coll.insertOne(d);
//            } else {
//                String value = myDoc.toJson();
//                JSONObject result = JSONObject.parseObject(value);
//                JSONArray ybk = result.getJSONArray(arrayKey);
//                JSONObject ybki = doc.getJSONArray(arrayKey).getJSONObject(0);
//                String patient_id = ybki.getString("patient_id");
//                String visit_id = ybki.getString("visit_id");
//                JSONArray sample = ybki.getJSONArray("sample");
//                boolean have = false;
//                for (int i = 0; i < ybk.size(); i++) {
//                    JSONObject _ybk = ybk.getJSONObject(i);
//                    String _patient_id = _ybk.getString("patient_id");
//                    String _visit_id = _ybk.getString("visit_id");
//                    JSONArray _sample = _ybk.getJSONArray("sample");
//                    if (patient_id.equals(_patient_id) && visit_id.equals(_visit_id)) {
//                        have = true;
//                        if (!_sample.contains(sample.getJSONObject(0))) {
//                            _sample.addAll(sample);
//                        }
//                    }
//                }
//                if (!have) {
//                    result.getJSONArray(arrayKey).addAll(doc.getJSONArray(arrayKey));
//                }
//                for (String key : result.keySet()) {
//                    d.put(key, result.get(key));
//                }
//                Bson filter = Filters.eq("_id", doc.get("_id"));
//                coll.updateOne(filter, new Document("$set", d));
//            }
//            falg = true;
//        } catch (MongoWriteException e) {
//            logger.error(e.toString());
//        }
//        return falg;
//    }
//
//    public static boolean hasSample(JSONArray samples, JSONObject sample) {
//        String sample_id = sample.getString("sample_id");
//        for (int i = 0; i < samples.size(); i++) {
//            JSONObject _sample = samples.getJSONObject(i);
//            String _sample_id = _sample.getString("sample_id");
//            if (_sample_id.equals(sample_id)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 批量增加documents
//     *
//     * @param coll
//     * @return
//     */
//    public static boolean saveList(MongoCollection<Document> coll, List<Document> docs) {
//        boolean falg = false;
//        try {
//            coll.insertMany(docs);
//            falg = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("添加异常，异常信息：", e);
//        }
//        return falg;
//    }
//
//    public static void close() {
//        if (mongoClient != null) {
//            mongoClient.close();
//            mongoClient = null;
//        }
//    }
//
//}
