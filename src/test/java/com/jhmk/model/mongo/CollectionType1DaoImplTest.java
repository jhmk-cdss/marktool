//package com.jhmk.model.mongo;
//
//import com.alibaba.fastjson.JSONObject;
//import com.jhmk.model.bean.CollectionType1;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.*;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
//
///**
// * @author ziyu.zhou
// * @date 2018/12/5 19:11
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CollectionType1DaoImplTest {
//    @Autowired
//    MongoTemplate mongoTemplate;
//    @Autowired
//    private CollectionType1Dao collectionType1Dao;
//
//    @Test
//    public void testSaveUser() throws Exception {
//        CollectionType1 user = new CollectionType1();
//        user.set_id("111111");
//        user.setDept_name("心血管");
//        user.setAdmission_time("2018-01-01 11:11:11");
//        collectionType1Dao.save(user);
//    }
//
//    @Test
//    public void findUserByUserName() {
////        CollectionType1 user= collectionType1Dao.findById("BJDXDSYY#000#1");
//        CollectionType1 user = collectionType1Dao.findById("111111");
//        System.out.println("user is " + JSONObject.toJSONString(user));
//    }
//
//    @Test
//    public void updateUser() {
//        CollectionType1 user = new CollectionType1();
//        user.set_id("111111");
//        user.setDept_name("天空");
//        user.set入院诊断("fffxxxx");
//        collectionType1Dao.update(user);
//    }
//
//    @Test
//    public void deleteUserById() {
//        collectionType1Dao.delete("111111");
//    }
//
//    @Test
//    public void getRecordeds() {
//        Integer page = 1;
//        Integer size = 20;
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("deptName","心血管科");
//        jsonObject.put("startTime","2016-01-01 00:00:00");
//        jsonObject.put("endTime","2017-01-01 00:00:00");
//        String deptName = jsonObject.getString("deptName");
//        String startTime = jsonObject.getString("startTime");
//        String endTime = jsonObject.getString("endTime");
//        String patient_id = jsonObject.getString("patient_id");
//        String visit_id = jsonObject.getString("visit_id");
//        String ryzd = jsonObject.getString("入院诊断");
//        String cyzd = jsonObject.getString("出院诊断");
//        String model = jsonObject.getString("模型命中第数");
//        String updateTime = jsonObject.getString("batchno");
//
//        if (page < 1) {
//
//            page = 1;
//
//        }
//
//        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
//
//        Pageable pageable = PageRequest.of(page - 1, size, sort);
//
//        Query query = new Query();
//
//        //条件id =XX
//
//        Criteria criteria = new Criteria();
//
//        if (StringUtils.isNotBlank(deptName)) {
//            criteria.and("dept_name").is(deptName);
//        }
//
////        Optional.ofNullable(startTime).ifPresent(s -> criteria.and("admission_time").gte(s),criteria.lte());
////        Optional.ofNullable(endTime).ifPresent(s -> criteria.and("admission_time").lte(s));
//        if (startTime != null && endTime != null) {
//            criteria.andOperator(
//                    Criteria.where("admission_time").gte(startTime),
//                    Criteria.where("admission_time").lt(endTime)
//            );
//        }
//        Optional.ofNullable(patient_id).ifPresent(s -> criteria.and("patient_id").is(s));
//        Optional.ofNullable(visit_id).ifPresent(s -> criteria.and("visit_id").is(s));
//        Optional.ofNullable(ryzd).ifPresent(s -> criteria.and("入院诊断").is(s));
//        Optional.ofNullable(cyzd).ifPresent(s -> criteria.and("出院诊断").is(s));
//        Optional.ofNullable(model).ifPresent(s -> criteria.and("模型命中第数").is(s));
//
//        query.addCriteria(criteria);
//
//        //mongoTemplate.count计算总数
//
//        long total = mongoTemplate.count(query, CollectionType1.class);
//
//        // mongoTemplate.find 查询结果集
//
//        List<CollectionType1> items = mongoTemplate.find(query.with(pageable), CollectionType1.class);
//
//        PageImpl page1 = new PageImpl(items, pageable, total);
//        System.out.println(page1.getContent());
//
//    }
////    public Page<CollectioType1> getRecordeds(Integer page, Integer size, JSONObject jsonObject) {
////        String deptName = jsonObject.getString("deptName");
////        String startTime = jsonObject.getString("startTime");
////        String endTime = jsonObject.getString("endTime");
////        String patient_id = jsonObject.getString("patient_id");
////        String visit_id = jsonObject.getString("visit_id");
////        String ryzd = jsonObject.getString("入院诊断");
////        String cyzd = jsonObject.getString("出院诊断");
////        String model = jsonObject.getString("模型命中第数");
////        String updateTime = jsonObject.getString("batchno");
////
////        if (page < 1) {
////
////            page = 1;
////
////        }
////
////        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
////
////        Pageable pageable = PageRequest.of(page - 1, size, sort);
////
////        Query query = new Query();
////
////        //条件id =XX
////
////        Criteria criteria = new Criteria();
////
////        if (StringUtils.isNotBlank(deptName)) {
////            criteria.and("dept_name").is(deptName);
////        }
////
////        Optional.ofNullable(startTime).ifPresent(s->criteria.and("startTime").is(s));
////        Optional.ofNullable(endTime).ifPresent(s->criteria.and("endTime").gte(s));
////        Optional.ofNullable(endTime).ifPresent(s->criteria.and("endTime").lte(s));
////        Optional.ofNullable(patient_id).ifPresent(s->criteria.and("patient_id").is(s));
////        Optional.ofNullable(visit_id).ifPresent(s->criteria.and("visit_id").is(s));
////        Optional.ofNullable(ryzd).ifPresent(s->criteria.and("入院诊断").is(s));
////        Optional.ofNullable(cyzd).ifPresent(s->criteria.and("出院诊断").is(s));
////        Optional.ofNullable(model).ifPresent(s->criteria.and("模型命中第数").is(s));
////
////        if (startTime != null && endTime != null) {
////
////            criteria.andOperator(
////
////                    Criteria.where("createTime").gte(startTime),
////
////                    Criteria.where("createTime").lt(endTime)
////
////            );
////
////        }
////
////        query.addCriteria(criteria);
////
////        //mongoTemplate.count计算总数
////
////        long total = mongoTemplate.count(query, CollectioType1.class);
////
////        // mongoTemplate.find 查询结果集
////
////        List<CollectioType1> items = mongoTemplate.find(query.with(pageable), CollectioType1.class);
////
////        return new PageImpl(items, pageable, total);
////
////    }
//}