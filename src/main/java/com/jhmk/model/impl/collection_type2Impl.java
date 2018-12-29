package com.jhmk.model.impl;

import com.jhmk.model.bean.mongobean.CollectionType2;
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
public class collection_type2Impl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(CollectionType2 clazz) {
        mongoTemplate.save(clazz);
    }

    public void delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,CollectionType2.class);
    }

    public void update(CollectionType2 bean) {
        Query query = new Query(Criteria.where("_id").is(bean.get_id()));
        Update update = new Update().set("dept_name", bean.getDept_name());
//        Update update= new Update().set("dept_name", bean.getDept_name()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, bean.getClass());
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    public CollectionType2 findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        CollectionType2 user = mongoTemplate.findOne(query, CollectionType2.class);
        return user;
    }
}
