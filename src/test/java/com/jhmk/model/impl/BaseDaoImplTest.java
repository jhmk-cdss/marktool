package com.jhmk.model.impl;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.mongobean.CollectionType1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ziyu.zhou
 * @date 2018/12/5 19:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseDaoImplTest {

    @Autowired
    private collection_type1Impl collection_type1Impl;

    @Test
    public void testSaveUser() throws Exception {
        CollectionType1 user = new CollectionType1();
        user.set_id("111112");
        user.setDept_name("心血管");
        user.setAdmission_time("2018-01-01 11:11:11");
        user.set入院诊断("噶西欧尔雅");
        user.setPatient_id("111");
        user.setVisit_id("2");
        user.set出院诊断("333");
        collection_type1Impl.save(user);
    }

    @Test
    public void findUserByUserName() {
//        CollectionType1 user= collection_type1Impl.findById("BJDXDSYY#000#1");
        CollectionType1 user = collection_type1Impl.findById("111111");
        System.out.println("user is " + JSONObject.toJSONString(user));
    }

    @Test
    public void updateUser() {
        CollectionType1 user = new CollectionType1();
        user.set_id("111111");
        user.setDept_name("天空");
        user.set入院诊断("fffxxxx");
        collection_type1Impl.update(user);
    }

    @Test
    public void deleteUserById() {
        collection_type1Impl.delete("111111");
    }
}