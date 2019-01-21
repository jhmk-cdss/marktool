package com.jhmk.model.util;

import com.jhmk.model.config.UrlPropertiesConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author ziyu.zhou
 * @date 2019/1/10 16:17
 * 文档工具类 (同义词  父子级关系等)
 */
@Service
public class DocumentUtil {
    Logger logger = LoggerFactory.getLogger(DocumentUtil.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;

    /**
     * @return 获取一个词的标准名称
     */
    public String getStandardFromAlias(String name) {
        HttpHeaders header = HttpHeadersUtils.getHeader(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        String trim = name.trim();
        postParameters.add("word", trim);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(postParameters, header);
        String standardName = restTemplate.postForObject(urlPropertiesConfig.getKnowbaseurl() + UrlConstants.standardFromAlias, request, String.class);
        if (StringUtils.isNotBlank(standardName)) {
            return standardName;
        }
        return trim;
    }

    /**
     * @return 获取一个疾病的所有子疾病
     */
    public List<String> getAllChildDisease(String name) {
        List<String> nameList = new ArrayList<>();
        HttpHeaders header = HttpHeadersUtils.getHeader(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        String trim = name.trim();
        postParameters.add("word", trim);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(postParameters, header);
        Object allDisease = restTemplate.postForObject(urlPropertiesConfig.getKnowbaseurl() + UrlConstants.getAllChildDisease, request, Object.class);
        if (Objects.nonNull(allDisease)) {
            Map<String, ArrayList<String>> arrayListMap = (Map) allDisease;
            Set<String> set = arrayListMap.keySet();
            for (String str : set) {
                if (StringUtils.isNotBlank(str)) {
                    ArrayList<String> arrayList = arrayListMap.get(str);
                    return arrayList;
                }
            }
        }
        return nameList;
    }

    /**
     * @return 根据药品层级，返回该层级的所有药品
     */
    public List<String> getMedicineFromLevelName(String name) {
        HttpHeaders header = HttpHeadersUtils.getHeader(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        String trim = name.trim();
        postParameters.add("word", trim);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(postParameters, header);
        try {
            ArrayList<String> medicineFromLevelName = restTemplate.postForObject(urlPropertiesConfig.getKnowbaseurl() + UrlConstants.getMedicineFromLevelName, request, ArrayList.class);
            return medicineFromLevelName;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("调用{}方法失败：，请求参数为：{}"+urlPropertiesConfig.getKnowbaseurl() + UrlConstants.getMedicineFromLevelName,postParameters);
            return null;
        }
    }


}
