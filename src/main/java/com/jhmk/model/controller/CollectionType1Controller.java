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
@RequestMapping("/collectionType1")
public class CollectionType1Controller extends BaseController {
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

    @RequestMapping("/getSameHitRate")
    public void getSameHitRate(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONArray jsonArray = JSONObject.parseArray(map);
        Iterator<Object> iterator = jsonArray.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        while (iterator.hasNext()) {
//            String id = iterator.next().toString().replaceAll("##2", "");
            String id = iterator.next().toString();
            JSONObject object = new JSONObject();
            object.put("_id", id);
            PageImpl dataByCondition = collectionType1RepService.getDataByCondition(object);
            List<CollectionType1> content = dataByCondition.getContent();
            if (content.size() > 0) {
                String illName = content.get(0).get出院诊断();
                String model = content.get(0).get模型结果();
                String modelResult = StringUtil.str2JsonStr(model);
                JSONArray modelArray = JSONObject.parseArray(modelResult);

                int i = diseaseService.getKeyIndex(illName, modelArray);
                countMap.put("all", countMap.get("all") == null ? 1 : countMap.get("all") + 1);
                if (i == -1) {
                    //总数量
                    //没有命中数量
//                    countMap.put("all", countMap.get("all") == null ? 1 : countMap.get("all") + 1);
                    continue;
                }
                if (i < 1) {
                    //前1命中数量
                    countMap.put("topOne", countMap.get("topOne") == null ? 1 : countMap.get("topOne") + 1);
                }
                if (i < 3) {
                    //前3命中数量
                    countMap.put("topThree", countMap.get("topThree") == null ? 1 : countMap.get("topThree") + 1);
                }
            }
        }
        Integer all = countMap.get("all");
        Integer topOne = countMap.get("topOne");
        Integer topThree = countMap.get("topThree");
        double oneRate = Double.valueOf(topOne) / Double.valueOf(all);
        double threeRate = Double.valueOf(topThree) / Double.valueOf(all);
        Map<String, Double> hitMap = new HashMap<>();
        hitMap.put("oneRate", oneRate);
        hitMap.put("threeRate", threeRate);
        resp.setData(hitMap);
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }


    @PostMapping(value = "/add")
    public void add(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        try {
            CollectionType1 collectionType1 = JSONObject.parseObject(map, CollectionType1.class);
            CollectionType1 save = collectionType1RepService.save(collectionType1);
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
            collectionType1RepService.delete(id);
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
            CollectionType1 collectionType1 = JSONObject.parseObject(map, CollectionType1.class);
            collectionType1RepService.update(collectionType1);
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
        CollectionType1 oldBean = collectionType1RepService.findBy_id(id);

        try {
            if ("2".equals(num)) {
                CollectionType2 collectionType2 = new CollectionType2();
                BeanUtils.copyProperties(oldBean, collectionType2);
                collectionType2.setBatchno(DateFormatUtil.getStrNowDate());
                collectionType2RepService.save(collectionType2);
            } else {
                CollectionType3 collectionType3 = new CollectionType3();
                BeanUtils.copyProperties(oldBean, collectionType3);
                collectionType3.setBatchno(DateFormatUtil.getStrNowDate());
                collectionType3RepService.save(collectionType3);
            }
            //逻辑删除 修改状态
            oldBean.setStatus(2);
            collectionType1RepService.save(oldBean);
//            collectionType1RepService.delete(id);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            resp.setResponseCode(ResponseCode.INERERROR);
            e.printStackTrace();
            System.out.println(e.getCause());
        }
        wirte(response, resp);
    }

    @PostMapping(value = "/list")
    public void list(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(map);
        PageImpl dataByCondition = collectionType1RepService.getDataByCondition(jsonObject);
        List<CollectionType1> allDataByCondition = collectionType1RepService.getAllDataByCondition(jsonObject);
        Map<String, Double> allHitRate = hitRateService.getAllHitRate1(allDataByCondition);
        Map<String, Object> params = new HashMap<>();
        params.put("rate", allHitRate);
        params.put("showData", dataByCondition);
        resp.setResponseCode(ResponseCode.OK);
        resp.setData(params);
        wirte(response, resp);
    }

    @PostMapping(value = "/findById")
    public void findById(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        String id = object.getString("id");
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        CollectionType1 next = collectionType1RepService.findBy_id(id);
        if (Objects.nonNull(next)) {
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = diseaseService.getKeyIndex(illName, modelArray);
            next.setHitNum(i);
            resp.setResponseCode(ResponseCode.OK);
            resp.setData(next);
        } else {
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }


}
