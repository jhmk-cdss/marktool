package com.jhmk.model.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.util.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 11:15
 * 疾病层级表服务
 */
@Service
public class DiseaseService {
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;
    @Autowired
    RestTemplate restTemplate;

    //疾病1是否是疾病2的子疾病
    public boolean isParentOrChild(String name1, String name2) {
        if (name2.equals(name1)) {
            return true;
        }
        Map<String, String> param = new HashMap<>();
        param.put("diseaseName", name2);
        Object parse1 = JSONObject.toJSON(param);
        String childList = restTemplate.postForObject(urlPropertiesConfig.getCdssurl()+UrlConstants.getDiseaseChildrenList, parse1, String.class);
        if (childList != null && childList.contains(name1)) {
            return true;
        } else {
            return false;
        }
    }

    public int getKeyIndex(String data, JSONArray jsonArray) {
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            Map<String, String> map = (Map) jsonArray.get(i);
            Set<String> set = map.keySet();
            for (String str : set) {
                boolean flag = isParentOrChild(data, str);
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }


}
