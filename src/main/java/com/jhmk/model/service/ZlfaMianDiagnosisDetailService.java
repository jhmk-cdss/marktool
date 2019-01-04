
package com.jhmk.model.service;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.rule.Rule;
import com.jhmk.model.bean.rule.Yizhu;
import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaMianDiagnosisDetailRepService;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.util.UrlConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/29 11:06
 */
@Service
public class ZlfaMianDiagnosisDetailService {
    Logger logger = LoggerFactory.getLogger(ZlfaMianDiagnosisDetailService.class);
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ZlfaZhubiaoService zlfaZhubiaoService;

    @Autowired
    ZlfaMianDiagnosisDetailRepService zlfaMianDiagnosisDetailRepService;

    public List<ZlfaMianDiagnosisDetail> getZlfaMianDiagnosisDetailList() {
        Iterable<ZlfaMianDiagnosisDetail> all = zlfaMianDiagnosisDetailRepService.findAll();
        Iterator<ZlfaMianDiagnosisDetail> iterator = all.iterator();
        while (iterator.hasNext()) {
            ZlfaMianDiagnosisDetail next = iterator.next();
            String medicineTreatment = next.getMedicineTreatment();
            String treatmentGoals = next.getTreatmentGoals();
            ZlfaModel zlfaModel = next.getZlfaModel();
            ZlfaOrderModel zlfaOrderModel = next.getZlfaOrderModel();
            if (zlfaOrderModel == null && !"手术治疗".equals(treatmentGoals)) {
                if (zlfaModel != null) {
                    ZlfaZhubiao zlfaZhubiao = zlfaModel.getZlfaZhubiao();
                    if (zlfaZhubiao != null) {
                        String patientId = zlfaZhubiao.getPatientId();
                        String visitId = zlfaZhubiao.getVisitId();
                        Map<String, String> map = new HashMap<>(2);
                        map.put("pid", patientId);
                        map.put("vid", visitId);
                        map.put("id", "BJDXDSYY#" + patientId + "#" + visitId);
                        Object o = JSONObject.toJSON(map);
                        String parse = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getDataByPIdAndVId, o, String.class);
                        Rule rule = JSONObject.parseObject(parse, Rule.class);
                        List<Yizhu> yizhuList = rule.getYizhu();
                        for (Yizhu yizhu : yizhuList) {
                            String order_item_name = yizhu.getOrder_item_name();
                            if (order_item_name.contains(medicineTreatment)) {
                                ZlfaOrderModel tempModel = zlfaZhubiaoService.getZlfaOrderModel(yizhu);
                                tempModel.setZlfaMianDiagnosisDetail(next);
                                next.setZlfaOrderModel(tempModel);
                                zlfaMianDiagnosisDetailRepService.save(next);
                                break;
                            }

                        }

                    }
                }
            }

        }
        return null;
    }
}
