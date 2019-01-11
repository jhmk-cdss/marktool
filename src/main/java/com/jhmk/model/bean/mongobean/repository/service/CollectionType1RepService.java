package com.jhmk.model.bean.mongobean.repository.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.mongobean.CollectionType1;
import com.jhmk.model.bean.mongobean.repository.CollectionType1Repository;
import com.jhmk.model.model.WebPage;
import com.jhmk.model.service.DiseaseService;
import com.jhmk.model.util.DateFormatUtil;
import com.jhmk.model.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 10:16
 */
@Service
public class CollectionType1RepService {
    @Autowired
    DiseaseService diseaseService;

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    CollectionType1Repository repository;

    public CollectionType1 findBy_id(String id) {
        return repository.findBy_id(id);
    }

    public Page<CollectionType1> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CollectionType1 save(CollectionType1 bean) {
        return repository.save(bean);
    }

    public Iterable<CollectionType1> saveAll(Iterable<CollectionType1> bean) {
        return repository.save(bean);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public void update(CollectionType1 bean) {
        Query query = new Query(Criteria.where("_id").is(bean.get_id()));
        Update update = new Update();
        Optional.ofNullable(bean.getDept_name()).ifPresent(s -> update.set("dept_name", s));
        Optional.ofNullable(bean.getBatchno()).ifPresent(s -> update.set("batchno", DateFormatUtil.format(new Date(), DateFormatUtil.DATETIME_PATTERN_SS)));
        Optional.ofNullable(bean.get模型结果()).ifPresent(s -> update.set("模型结果", s));
        Optional.ofNullable(bean.get入院诊断()).ifPresent(s -> update.set("入院诊断", s));
        Optional.ofNullable(bean.get出院诊断()).ifPresent(s -> update.set("出院诊断", s));
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, bean.getClass());
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,CollectionType1.class);
    }


    public List<CollectionType1> getAllDataByCondition(JSONObject jsonObject) {
        String _id = jsonObject.getString("_id");
        String deptName = jsonObject.getString("dept_name");
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String patient_id = jsonObject.getString("patient_id");
        String visit_id = jsonObject.getString("visit_id");
        String ryzd = jsonObject.getString("入院诊断");
        String cyzd = jsonObject.getString("出院诊断");
        String model = jsonObject.getString("模型命中第数");
        String updateTime = jsonObject.getString("batchno");
        WebPage webPage = new WebPage();
        String pageStr = jsonObject.getString(WebPage.PAGE_NUM);
        int page = 0;
        if (pageStr != null && !"".equals(pageStr.trim())) {
            // Pageable页面从0开始计
            page = new Integer(pageStr) - 1;
        }
        int pageSize = webPage.getPageSize();
        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        Query query = new Query();
        //条件id =XX
        Criteria criteria = new Criteria();
        if (startTime != null && endTime != null) {
            criteria.andOperator(
                    Criteria.where("admission_time").gte(startTime),
                    Criteria.where("admission_time").lt(endTime)
            );
        }
        Optional.ofNullable(_id).ifPresent(s -> criteria.and("_id").is(s));
        Optional.ofNullable(deptName).ifPresent(s -> criteria.and("dept_name").is(s));
        Optional.ofNullable(patient_id).ifPresent(s -> criteria.and("patient_id").is(s));
        Optional.ofNullable(visit_id).ifPresent(s -> criteria.and("visit_id").is(s));
        Optional.ofNullable(ryzd).ifPresent(s -> criteria.and("入院诊断").is(s));
        Optional.ofNullable(cyzd).ifPresent(s -> criteria.and("出院诊断").is(s));
        Optional.ofNullable(model).ifPresent(s -> criteria.and("模型命中第数").is(s));

        query.addCriteria(criteria);

        //mongoTemplate.count计算总数

        long total = mongoTemplate.count(query, CollectionType1.class);
        // mongoTemplate.find 查询结果集
        List<CollectionType1> items = mongoTemplate.find(query, CollectionType1.class);
        return items;

    }

    //    public PageImpl getPageDataByCondition(JSONObject jsonObject) {
//        List<CollectionType1> items = getAllDataByCondition(jsonObject);
//
//        WebPage webPage = new WebPage();
//        String pageStr = jsonObject.getString(WebPage.PAGE_NUM);
//        int page = 0;
//        if (pageStr != null && !"".equals(pageStr.trim())) {
//            // Pageable页面从0开始计
//            page = new Integer(pageStr) - 1;
//        }
//        int pageSize = webPage.getPageSize();
//        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
//        Pageable pageable = new PageRequest(page, pageSize, sort);
//        Query query = new Query();
//        //条件id =XX
//
////        List<CollectionType1> items = mongoTemplate.find(query, CollectionType1.class);
//
//        PageImpl page1 = new PageImpl(items, pageable, total);
//        return page1;
//
//    }
    public PageImpl getDataByCondition(JSONObject jsonObject) {
        String _id = jsonObject.getString("_id");
        String deptName = jsonObject.getString("dept_name");
        String startTime = jsonObject.getString("startTime");
        String endTime = jsonObject.getString("endTime");
        String patient_id = jsonObject.getString("patient_id");
        String visit_id = jsonObject.getString("visit_id");
        String ryzd = jsonObject.getString("入院诊断");
        String cyzd = jsonObject.getString("出院诊断");
        String model = jsonObject.getString("模型命中第数");
        String updateTime = jsonObject.getString("batchno");
        WebPage webPage = new WebPage();
        String pageStr = jsonObject.getString(WebPage.PAGE_NUM);
        int page = 0;
        if (pageStr != null && !"".equals(pageStr.trim())) {
            // Pageable页面从0开始计
            page = new Integer(pageStr) - 1;
        }
        int pageSize = webPage.getPageSize();
        Sort sort = new Sort(Sort.Direction.DESC, "batchno");
        Pageable pageable = new PageRequest(page, pageSize, sort);
        Query query = new Query();
        //条件id =XX
        Criteria criteria = new Criteria();
        if (startTime != null && endTime != null) {
            criteria.andOperator(
                    Criteria.where("admission_time").gte(startTime),
                    Criteria.where("admission_time").lt(endTime)
            );
        }
        //ne  不等于
        Optional.ofNullable(_id).ifPresent(s -> criteria.and("_id").is(s));
        Optional.ofNullable(deptName).ifPresent(s -> criteria.and("dept_name").is(s));
        Optional.ofNullable(patient_id).ifPresent(s -> criteria.and("patient_id").is(s));
        Optional.ofNullable(visit_id).ifPresent(s -> criteria.and("visit_id").is(s));
        Optional.ofNullable(ryzd).ifPresent(s -> criteria.and("入院诊断").is(s));
        Optional.ofNullable(cyzd).ifPresent(s -> criteria.and("出院诊断").is(s));
        Optional.ofNullable(model).ifPresent(s -> criteria.and("模型命中第数").is(s));
        criteria.and("status").ne(2);
        query.addCriteria(criteria);
        //mongoTemplate.count计算总数
        long total = mongoTemplate.count(query, CollectionType1.class);
        // mongoTemplate.find 查询结果集
//        List<CollectionType1> items = mongoTemplate.find(query, CollectionType1.class);
        List<CollectionType1> items = mongoTemplate.find(query.with(pageable), CollectionType1.class);
        List<CollectionType1> collectionType1s = analyzeData(items);
        PageImpl page1 = new PageImpl(collectionType1s, pageable, total);
        return page1;

    }

    public List<CollectionType1> analyzeData(List<CollectionType1> content) {
//        List<CollectionType1> newcontent = new ArrayList<>();
        for (CollectionType1 next : content) {
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            if (modelArray != null && modelArray.size() > 0) {
                int i = diseaseService.getKeyIndex(illName, modelArray);
                next.setHitNum(i);
                next.set模型结果(modelResult);
            }
        }
        return content;
    }

}
