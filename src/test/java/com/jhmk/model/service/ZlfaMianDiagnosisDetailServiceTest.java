package com.jhmk.model.service;

import com.jhmk.model.bean.sqlbean.BiaozhuZhubiao;
import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuZhubiaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ziyu.zhou
 * @date 2018/12/29 11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZlfaMianDiagnosisDetailServiceTest {
    @Autowired
    ZlfaMianDiagnosisDetailService service;

    @Test
    public void testFIndOne() {
        List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = service.getZlfaMianDiagnosisDetailList();

    }
}