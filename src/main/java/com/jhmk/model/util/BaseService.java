//package com.jhmk.model.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.jhmk.model.bean.CollectionType1;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author ziyu.zhou
// * @date 2018/12/7 11:09
// */
//@Service
//public class BaseService {
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    public PageImpl getRecordeds(Integer page, Integer size, JSONObject jsonObject, Class clazz) {
//        String deptName = jsonObject.getString("deptName");
//        String startTime = jsonObject.getString("startTime");
//        String endTime = jsonObject.getString("endTime");
//        String patient_id = jsonObject.getString("patient_id");
//        String visit_id = jsonObject.getString("visit_id");
//        String ryzd = jsonObject.getString("入院诊断");
//        String cyzd = jsonObject.getString("出院诊断");
//        String model = jsonObject.getString("模型命中第数");
//        String updateTime = jsonObject.getString("batchno");
//        if (page < 1) {
//            page = 1;
//        }
//        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
//        Pageable pageable = PageRequest.of(page - 1, size, sort);
//        Query query = new Query();
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
//        // mongoTemplate.find 查询结果集
//        List<CollectionType1> items = mongoTemplate.find(query.with(pageable), CollectionType1.class);
//
//        PageImpl page1 = new PageImpl(items, pageable, total);
//        return page1;
//
//    }
//
//}
