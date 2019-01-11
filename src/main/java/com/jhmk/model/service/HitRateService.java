package com.jhmk.model.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.mongobean.CollectionType1;
import com.jhmk.model.bean.mongobean.CollectionType2;
import com.jhmk.model.bean.mongobean.repository.service.CollectionType1RepService;
import com.jhmk.model.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 16:50
 */

@Service
public class HitRateService {
    @Autowired
    DiseaseService diseaseService;
    @Autowired
    CollectionType1RepService collectionType1RepService;

//    public Map<String, Double> getAllHitRate1(List<CollectionType1> allDataByCondition) {
//        Iterator<CollectionType1> iterator = allDataByCondition.iterator();
//        Map<String, Integer> countMap = new HashMap<>();
//        while (iterator.hasNext()) {
//            String id = iterator.next().get_id();
//            JSONObject object = new JSONObject();
//            object.put("_id", id);
//            PageImpl dataByCondition = collectionType1RepService.getDataByCondition(object);
//            List<CollectionType1> content = dataByCondition.getContent();
//            if (content.size() > 0) {
//                String illName = content.get(0).get出院诊断();
//                String model = content.get(0).get模型结果();
//                String modelResult = StringUtil.str2JsonStr(model);
//                JSONArray modelArray = JSONObject.parseArray(modelResult);
//
//                int i = diseaseService.getKeyIndex(illName, modelArray);
//                countMap.put("all", countMap.get("all") == null ? 1 : countMap.get("all") + 1);
//                if (i == -1) {
//                    //总数量
//                    //没有命中数量
////                    countMap.put("all", countMap.get("all") == null ? 1 : countMap.get("all") + 1);
//                    continue;
//                }
//                if (i < 1) {
//                    //前1命中数量
//                    countMap.put("topOne", countMap.get("topOne") == null ? 1 : countMap.get("topOne") + 1);
//                }
//                if (i < 3) {
//                    //前3命中数量
//                    countMap.put("topThree", countMap.get("topThree") == null ? 1 : countMap.get("topThree") + 1);
//                }
//            }
//        }
//        Integer all = countMap.get("all");
//        Integer topOne = countMap.get("topOne");
//        Integer topThree = countMap.get("topThree");
//        double oneRate = Double.valueOf(topOne) / Double.valueOf(all);
//        double threeRate = Double.valueOf(topThree) / Double.valueOf(all);
//        Map<String, Double> hitMap = new HashMap<>();
//        hitMap.put("oneRate", oneRate);
//        hitMap.put("threeRate", threeRate);
//        return hitMap;
//    }

    public Map<String, Double> getAllHitRate1(List<CollectionType1> allDataByCondition) {
        Iterator<CollectionType1> iterator = allDataByCondition.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("all", 0);
        countMap.put("topOne", 0);
        countMap.put("topThree", 0);
        while (iterator.hasNext()) {
            CollectionType1 next = iterator.next();
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = -1;
            if (modelArray !=null&&modelArray.size()>0){
                i = diseaseService.getKeyIndex(illName, modelArray);
            }
            countMap.put("all", countMap.get("all") + 1);
            if (i == -1) {
                //总数量
                //没有命中数量
//                    countMap.put("all", countMap.get("all") == null ? 1 : countMap.get("all") + 1);
                continue;
            }
            if (i < 1) {
                //前1命中数量
                countMap.put("topOne", countMap.get("topOne") + 1);
            }
            if (i < 3) {
                //前3命中数量
                countMap.put("topThree", countMap.get("topThree") + 1);
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
        return hitMap;
    }

    public Map<String, Double> getAllHitRate2(List<CollectionType2> allDataByCondition) {
        Iterator<CollectionType2> iterator = allDataByCondition.iterator();
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("all", 0);
        countMap.put("topOne", 0);
        countMap.put("topThree", 0);
        while (iterator.hasNext()) {
            CollectionType2 next = iterator.next();
            String illName = next.get出院诊断();
            String model = next.get模型结果();
            String modelResult = StringUtil.str2JsonStr(model);
            JSONArray modelArray = JSONObject.parseArray(modelResult);
            int i = diseaseService.getKeyIndex(illName, modelArray);
            countMap.put("all", countMap.get("all") + 1);
            if (i == -1) {
                //总数量
                //没有命中数量
                continue;
            }
            if (i < 1) {
                //前1命中数量
                countMap.put("topOne", countMap.get("topOne") + 1);
            }
            if (i < 3) {
                //前3命中数量
                countMap.put("topThree", countMap.get("topThree") + 1);
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
        return hitMap;
    }
}
