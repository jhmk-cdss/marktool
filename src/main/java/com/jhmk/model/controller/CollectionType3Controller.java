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
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.HitRateService;
import com.jhmk.model.util.DateFormatUtil;
import com.jhmk.model.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 11:55
 */

@Controller
@RequestMapping("/collectionType3")
public class CollectionType3Controller extends BaseController {
    @Autowired
    CollectionType1RepService collectionType1RepService;
    @Autowired
    CollectionType2RepService collectionType2RepService;
    @Autowired
    CollectionType3RepService collectionType3RepService;
    @Autowired
    HitRateService hitRateService;

    @PostMapping(value = "/add")
    public void add(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        try {
            CollectionType3 collectionType1 = JSONObject.parseObject(map, CollectionType3.class);
            CollectionType3 save = collectionType3RepService.save(collectionType1);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }

    /**
     * 删除
     *
     * @param response
     * @param map
     */
    @PostMapping(value = "/remove")
    public void remove(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(map);
        String id = jsonObject.getString("_id");
        try {
            collectionType3RepService.delete(id);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }

    /**
     * 修改
     *
     * @param response
     * @param map
     */
    @PostMapping(value = "/update")
    public void update(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(map);
        String id = jsonObject.getString("_id");
        try {
            CollectionType3 collectionType1 = JSONObject.parseObject(map, CollectionType3.class);
            collectionType3RepService.update(collectionType1);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }

    @PostMapping(value = "/move")
    public void move(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(map);
        String id = jsonObject.getString("_id");
        String num = jsonObject.getString("num");
        CollectionType3 oldBean = collectionType3RepService.findBy_id(id);
        try {
            if ("1".equals(num)) {
                CollectionType1 collectionType1 = JSONObject.parseObject(JSONObject.toJSONString(oldBean), CollectionType1.class);
                collectionType1.setBatchno(DateFormatUtil.getStrNowDate());
                collectionType1RepService.save(collectionType1);
            } else if ("2".equals(num)) {
                CollectionType2 collectionType2 = JSONObject.parseObject(JSONObject.toJSONString(oldBean), CollectionType2.class);
                collectionType2.setBatchno(DateFormatUtil.getStrNowDate());
                collectionType2RepService.save(collectionType2);
            } else {
                CollectionType3 collectionType3 = JSONObject.parseObject(map, CollectionType3.class);
                collectionType3.setBatchno(DateFormatUtil.getStrNowDate());
                collectionType3RepService.save(collectionType3);
            }
            collectionType3RepService.delete(id);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }

    @PostMapping(value = "/list")
    public void list(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(map);
        PageImpl dataByCondition = collectionType3RepService.getDataByCondition(jsonObject);
        resp.setResponseCode(ResponseCode.OK);
        resp.setData(dataByCondition);
        wirte(response, resp);
    }

//    @PostMapping(value = "/list")
//    public void list(HttpServletResponse response, @RequestBody String map) {
//        AtResponse resp = new AtResponse(System.currentTimeMillis());
//        JSONObject jsonObject = JSONObject.parseObject(map);
//        PageImpl dataByCondition = collectionType2RepService.getDataByCondition(jsonObject);
//        List<CollectionType2> allDataByCondition = collectionType2RepService.getAllDataByCondition(jsonObject);
//        Map<String, Double> allHitRate = hitRateService.getAllHitRate2(allDataByCondition);
//        Map<String, Object> params = new HashMap<>();
//        params.put("rate", allHitRate);
//        params.put("showData", dataByCondition);
//        resp.setResponseCode(ResponseCode.OK);
//        resp.setData(params);
//        wirte(response, resp);
//    }

}
