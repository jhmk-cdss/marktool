package com.jhmk.model.repository;

import com.jhmk.model.bean.sqlbean.BiaozhuJbzdmodel;
import com.jhmk.model.bean.sqlbean.BiaozhuZhubiao;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuZhubiaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BiaozhuZhubiaoRepositoryTest {
    @Autowired
    BiaozhuZhubiaoRepository repository;

    @Test
    public void testFIndOne() {
         repository.findOne(1);
//        if (byId.isPresent()){
//                List<BiaozhuJbzdmodel> biaozhuJbzdmodelList  = byId.get().getBiaozhuJbzdmodelList();
//                System.out.println(biaozhuJbzdmodelList);
//        }
        Iterable<BiaozhuZhubiao> all = repository.findAll();
        System.out.println(all);
    }
}