//package com.jhmk.model.repository.service;
//
//import com.alibaba.fastjson.JSONObject;
//import com.jhmk.model.bean.CollectioType1;
//import com.jhmk.model.util.WebPage;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.apache.poi.ss.formula.functions.T;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
///**
// * @author ziyu.zhou
// * @date 2018/12/7 11:23
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CollectionType1RepServiceTest {
//    @Autowired
//    CollectionType1RepService collectionType1RepService;
//    @Autowired
//    MongoTemplate mongoTemplate;
//
////    @Test
////    public void findAll() {
////        collectionType1RepService.findAll()
////    }
////    public Specification<T> getWhereClause(Date startTime, Date endTime, Map<String, Object> params) {
////        return new Specification<T>() {
////            @Override
////            public Predicate toPredicate(Root<T> root,
////                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
////                List<Predicate> list = new ArrayList<Predicate>();
////
////                if (startTime != null) {
////                    list.add(cb.greaterThanOrEqualTo(root.get("createTime").as(Date.class), startTime));
////
////                }
////                if (endTime != null) {
////                    list.add(cb.lessThanOrEqualTo(root.get("createTime").as(Date.class), endTime));
////                }
//////                //拼接传入参数
////                if (params != null) {
////                    for (String key : params.keySet()) {
////                        if (WebPage.PAGE_NUM.equals(key)) {
////                            continue;
////                        } else {
////                            Object value = params.get(key);
////                            if (!org.springframework.util.StringUtils.isEmpty(value.toString())) {
////                                list.add(cb.equal(root.get(key), value));
////                            }
////                        }
////                    }
////                }
////
////                Predicate[] p = new Predicate[list.size()];
////                list.toArray(p);
////                return cb.and(p);
////
////            }
////        };
////    }
//
//    @Test
//    public void getRecordeds() {
//        Integer page = 1;
//        Integer size = 20;
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("deptName", "心血管科");
//        jsonObject.put("startTime", "2016-01-01 00:00:00");
//        jsonObject.put("endTime", "2017-01-01 00:00:00");
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
//        long total = mongoTemplate.count(query, CollectioType1.class);
//
//        // mongoTemplate.find 查询结果集
//
//        List<CollectioType1> items = mongoTemplate.find(query.with(pageable), CollectioType1.class);
//
//        PageImpl page1 = new PageImpl(items, pageable, total);
//        System.out.println(page1.getContent());
//
//    }
//}