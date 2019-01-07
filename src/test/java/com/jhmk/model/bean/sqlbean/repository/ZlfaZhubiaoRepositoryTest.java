package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZlfaZhubiaoRepositoryTest {
    @Autowired
    ZlfaZhubiaoRepository zlfaZhubiaoRepository;

    @Test
    public void testFindOne() {
        ZlfaZhubiao one = zlfaZhubiaoRepository.findOne(1);
        System.out.println(one);
    }


    @Test
    public void getMapGt2Count() {
        List<ZlfaZhubiao> mapGt2Count = zlfaZhubiaoRepository.getMapGt2Count();

        System.out.println(mapGt2Count);
    }
}