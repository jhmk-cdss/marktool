package com.jhmk.model.bean.mongobean.repository.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.mongobean.CollectionType1;
import com.jhmk.model.bean.mongobean.CollectionType2;
import com.jhmk.model.bean.mongobean.repository.CollectionType2Repository;
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
public class CollectionType2RepService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    DiseaseService diseaseService;

    @Autowired
    CollectionType2Repository repository;

    public CollectionType2 findBy_id(String id) {
        return repository.findBy_id(id);
    }

    public Page<CollectionType2> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CollectionType2 save(CollectionType2 bean) {
        return repository.save(bean);
    }

    public Iterable<CollectionType2> saveAll(Iterable<CollectionType2> bean) {
        return repository.save(bean);
    }

    public void delete(String id) {
        repository.delete(id);
    }

    public void update(CollectionType2 bean) {
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
        // mongoTemplate.updateMulti(query,update,CollectionType2.class);
    }


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
        Optional.ofNullable(_id).ifPresent(s -> criteria.and("_id").is(s));
        Optional.ofNullable(deptName).ifPresent(s -> criteria.and("dept_name").is(s));
        Optional.ofNullable(patient_id).ifPresent(s -> criteria.and("patient_id").is(s));
        Optional.ofNullable(visit_id).ifPresent(s -> criteria.and("visit_id").is(s));
        Optional.ofNullable(ryzd).ifPresent(s -> criteria.and("入院诊断").is(s));
        Optional.ofNullable(cyzd).ifPresent(s -> criteria.and("出院诊断").is(s));
        Optional.ofNullable(model).ifPresent(s -> criteria.and("模型命中第数").is(s));

        query.addCriteria(criteria);

        //mongoTemplate.count计算总数

        long total = mongoTemplate.count(query, CollectionType2.class);
        // mongoTemplate.find 查询结果集
        List<CollectionType2> items = mongoTemplate.find(query.with(pageable), CollectionType2.class);
        List<CollectionType2> collectionType1s = analyzeData(items);
        PageImpl page1 = new PageImpl(collectionType1s, pageable, total);
        return page1;

    }

    public List<CollectionType2> getAllDataByCondition(JSONObject jsonObject) {
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
        List<CollectionType2> items = mongoTemplate.find(query, CollectionType2.class);
        return items;

    }

    public List<CollectionType2> analyzeData(List<CollectionType2> content) {
//        List<CollectionType1> newcontent = new ArrayList<>();
        for (CollectionType2 next : content) {
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = diseaseService.getKeyIndex(illName, modelArray);
            next.setHitNum(i);
            next.set模型结果(modelResult);
        }
        return content;
    }

}
