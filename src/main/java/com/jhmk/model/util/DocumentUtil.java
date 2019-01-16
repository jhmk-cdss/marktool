package com.jhmk.model.util;

import com.jhmk.model.config.UrlPropertiesConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author ziyu.zhou
 * @date 2019/1/10 16:17
 * 文档工具类 (同义词  父子级关系等)
 */
@Service
public class DocumentUtil {
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
    public String getAllChildDisease(String name) {
        HttpHeaders header = HttpHeadersUtils.getHeader(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        String trim = name.trim();
        postParameters.add("word", trim);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(postParameters, header);
        String standardName = restTemplate.postForObject(urlPropertiesConfig.getKnowbaseurl() + UrlConstants.getAllChildDisease, request, String.class);
        if (StringUtils.isNotBlank(standardName)) {
            return standardName;
        }
        return trim;
    }
}
