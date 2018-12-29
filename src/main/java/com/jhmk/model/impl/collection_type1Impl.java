package com.jhmk.model.impl;

import com.jhmk.model.bean.mongobean.CollectionType1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author ziyu.zhou
 * @date 2018/12/5 19:43
 */

@Service
public class collection_type1Impl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(CollectionType1 clazz) {
        mongoTemplate.save(clazz);
    }

    public void delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, CollectionType1.class);
    }

    public void update(CollectionType1 bean) {
        Query query = new Query(Criteria.where("_id").is(bean.get_id()));
        Update update = new Update().set("dept_name", bean.getDept_name());
//        Update update= new Update().set("dept_name", bean.getDept_name()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, bean.getClass());
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    public CollectionType1 findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        CollectionType1 user = mongoTemplate.findOne(query, CollectionType1.class);
        return user;
    }

//    public collection_type1 findByCondition(WebPage webPage) {
//        Query query = new Query(Criteria.where("name").is(name).and("size").is(webPage.getPageSize()).and("age").is(age))
//                .skip((webPage.getPageNo() - 1) * webPage.getPageSize())
//                .limit(webPage.getPageSize());
//        Query query = new Query(Criteria.where("name").is(name).and("size").is(webPage.getPageSize()).and("age").is(age))
//                .skip((webPage.getPageNo() - 1) * webPage.getPageSize())
//                .limit(webPage.getPageSize());
////        List<collection_type1> list = mongoTemplate.find(query, collection_type1.class, "testCollection");
//        List<collection_type1> list = mongoTemplate.find(query, collection_type1.class);
//        long totalSize = mongoTemplate.count(query, JavaEntity.class, "testCollection");
//        page.setTotalSize((int) totalSize);
//    }


}
