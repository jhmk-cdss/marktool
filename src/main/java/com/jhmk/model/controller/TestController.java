package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.jhmk.model.base.BaseController;
import com.jhmk.model.bean.mongobean.CollectionType1;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType1RepService;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType2RepService;
import com.jhmk.model.bean.sqlbean.BiaozhuJbzdmodel;
import com.jhmk.model.bean.sqlbean.BiaozhuZhubiao;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuZhubiaoRepository;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.DiseaseService;
import com.jhmk.model.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 17:51
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    CollectionType2RepService collectionType2RepService;
    @Autowired
    CollectionType1RepService collectionType1RepService;
    @Autowired
    BiaozhuZhubiaoRepository repository;
    @Autowired

    RestTemplate restTemplate;
    @Autowired

    DiseaseService diseaseService;

//    @RequestMapping("/1")
//    public void testFIndOne() {
//        Optional<BiaozhuZhubiao> byId = repository.findOne(1);
//        if (byId.isPresent()) {
//            List<BiaozhuJbzdmodel> biaozhuJbzdmodelList = byId.get().getBiaozhuJbzdmodelList();
//            System.out.println(biaozhuJbzdmodelList);
//        }
//    }

    /**
     * 获取前一 前三命中率
     *
     * @param response
     * @param map
     */
    @RequestMapping("/getSameHitRate")
    public void getSameHitRate(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONArray jsonArray = JSONObject.parseArray(map);
        Iterator<Object> iterator = jsonArray.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        while (iterator.hasNext()) {
            String id = iterator.next().toString().replaceAll("##2", "");
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

    @RequestMapping("/getDiffHitRate")
    public void getDiffHitRate(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONArray jsonArray = JSONObject.parseArray(map);
        Iterator<Object> iterator = jsonArray.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        while (iterator.hasNext()) {
            String id = iterator.next().toString().replaceAll("##2", "");
            JSONObject object = new JSONObject();
            object.put("_id", id);
            PageImpl dataByCondition = collectionType2RepService.getDataByCondition(object);
            List<CollectionType1> content = dataByCondition.getContent();
            if (content.size() > 0) {
                String illName = content.get(0).get出院诊断();
                String model = content.get(0).get模型结果();
                String modelResult = StringUtil.str2JsonStr(model);
                JSONArray modelArray = JSONObject.parseArray(modelResult);

                int i = diseaseService.getKeyIndex(illName, jsonArray);
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


    @RequestMapping("/save")
    public void testSave(HttpServletResponse response, @RequestBody String map) {
        JSONObject jsonObject = JSONObject.parseObject(map);
        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString(""));
        BiaozhuZhubiao one = repository.findOne(1);
        System.out.println(one);
    }


    @RequestMapping("/findSameMongo")
    public void findMongo(HttpServletResponse response, @RequestBody String map) {
        JSONObject jsonObject = JSONObject.parseObject(map);
        JSONArray jarray = JSONObject.parseArray(map);
        Iterator<Object> iterator = jarray.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        while (iterator.hasNext()) {
            Map<String, String> beanMap = (Map) iterator.next();
            JSONObject object = new JSONObject();
            object.put("patient_id", beanMap.get("patient_id"));
            object.put("visit_id", beanMap.get("visit_id"));
            PageImpl dataByCondition = collectionType1RepService.getDataByCondition(object);
            List<CollectionType1> content = dataByCondition.getContent();
            if (content.size() > 0) {
                String illName = content.get(0).get出院诊断();
                String model = content.get(0).get模型结果();
                String s1 = StringUtil.str2JsonStr(model);
                JSONArray jsonArray = JSONObject.parseArray(s1);
                int i = diseaseService.getKeyIndex(illName, jsonArray);
                if (i == -1) {
                    countMap.put("all", countMap.get("all") == null ? 0 : countMap.get("all"));
                    continue;
                }
                if (i < 3) {

                }
                System.out.println(i);
                List<String> list1 = Arrays.asList(model);
                String substring = model.substring(1, model.length() - 1).trim();
                System.out.println(substring);
                String[] split = substring.split(",");
                List<String> list = Arrays.asList(split);
                System.out.println(model);
            }

        }
        CollectionType1 collectionType1 = JSONObject.parseObject(map, CollectionType1.class);
        PageImpl dataByCondition = collectionType1RepService.getDataByCondition(jsonObject);
        List<CollectionType1> content = dataByCondition.getContent();
        if (content.size() > 0) {
            String illName = content.get(0).get出院诊断();
            String model = content.get(0).get模型结果();
            String s1 = StringUtil.str2JsonStr(model);
            JSONArray jsonArray = JSONObject.parseArray(s1);
            int i = diseaseService.getKeyIndex(illName, jsonArray);
            System.out.println(i);
            List<String> list1 = Arrays.asList(model);
            String substring = model.substring(1, model.length() - 1).trim();
            System.out.println(substring);
            String[] split = substring.split(",");
            List<String> list = Arrays.asList(split);
            System.out.println(model);
        }

    }

    public static void test1() {
        Map<String, Double> map = new HashMap<>();
        map.put("呼吸衰竭", 0.8859443068504333);
        map.put("慢性阻塞性肺疾病", 0.08530370146036148);
        ArrayList<Map.Entry<String, Double>> entries = new ArrayList<>(map.entrySet());
        System.out.println(JSONObject.toJSONString(entries));
    }
}
