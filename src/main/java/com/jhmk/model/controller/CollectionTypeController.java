package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.base.BaseController;
import com.jhmk.model.bean.mongobean.CollectionType1;
import com.jhmk.model.bean.mongobean.CollectionType2;
import com.jhmk.model.bean.mongobean.CollectionType3;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType1RepService;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType2RepService;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType3RepService;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuZhubiaoRepository;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.DiseaseService;
import com.jhmk.model.service.HitRateService;
import com.jhmk.model.util.DateFormatUtil;
import com.jhmk.model.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 11:55
 */

@Controller
@RequestMapping("/collectionType")
public class CollectionTypeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CollectionTypeController.class);

    @Autowired
    CollectionType1RepService collectionType1RepService;
    @Autowired
    CollectionType2RepService collectionType2RepService;
    @Autowired
    CollectionType3RepService collectionType3RepService;
    @Autowired
    BiaozhuZhubiaoRepository repository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiseaseService diseaseService;
    @Autowired
    HitRateService hitRateService;


    @PostMapping(value = "/findById")
    public void findById(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        String id = object.getString("id");
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        CollectionType1 next = collectionType1RepService.findBy_id(id);
        CollectionType2 next2 = collectionType2RepService.findBy_id(id);
        CollectionType3 next3 = collectionType3RepService.findBy_id(id);
        if (Objects.nonNull(next)) {
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = diseaseService.getKeyIndex(illName, modelArray);
            next.setHitNum(i);
            resp.setResponseCode(ResponseCode.OK);
            resp.setData(next);
            logger.info("表一数据为===============>>>>>>>>>>>>>>>{}",JSONObject.toJSONString(next));
            wirte(response, resp);
            return;
        } else if (Objects.nonNull(next2)) {
            String illName = next2.get出院诊断();
            String model = next2.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = diseaseService.getKeyIndex(illName, modelArray);
            next2.setHitNum(i);
            resp.setResponseCode(ResponseCode.OK);
            resp.setData(next2);
            logger.info("表二数据为===============>>>>>>>>>>>>>>>{}",JSONObject.toJSONString(next2));

            wirte(response, resp);
            return;
        } else if (Objects.nonNull(next3)) {
            resp.setData(next3);
            resp.setResponseCode(ResponseCode.OK);
            logger.info("表三数据为===============>>>>>>>>>>>>>>>{}",JSONObject.toJSONString(next3));
            wirte(response, resp);
            return;
        } else {
            logger.info("都没查到：====================》》》》》》》》》》》{}",id);

            resp.setResponseCode(ResponseCode.INERERROR);
        }
    }


}
