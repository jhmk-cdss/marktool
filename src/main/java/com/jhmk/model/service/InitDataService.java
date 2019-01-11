package com.jhmk.model.service;

import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaMianDiagnosisDetailRepService;
import com.jhmk.model.util.ReadResourceUtil;
import com.jhmk.model.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ziyu.zhou
 * @date 2018/12/29 14:24
 */
@Service
public class InitDataService {
    @Autowired
    ZlfaMianDiagnosisDetailRepService zlfaMianDiagnosisDetailRepService;
    /**
     * 医嘱方案
     */
    public static Map<String, ZlfaMianDiagnosisDetail> yizhuMap = new HashMap<>();
    public static Map<String, String> drugPurposeMap = new HashMap<>();

    /**
     * 初始化数据
     */
    @PostConstruct
    public void initData() {
//        initYizhuMap();
        readZlfaPurpose();
    }

    /**
     * 将医嘱项名称 对应目的假如map
     */
    public void initYizhuMap() {
        Iterable<ZlfaMianDiagnosisDetail> all = zlfaMianDiagnosisDetailRepService.findAll();
        Iterator<ZlfaMianDiagnosisDetail> iterator = all.iterator();
        while (iterator.hasNext()) {
            ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = iterator.next();
            ZlfaOrderModel zlfaOrderModel = zlfaMianDiagnosisDetail.getZlfaOrderModel();
            if (zlfaOrderModel != null) {
                //医嘱项名称
                String orderItemName = zlfaOrderModel.getOrderItemName();
                if (StringUtils.isNotBlank(orderItemName)) {
                    yizhuMap.put(orderItemName, zlfaMianDiagnosisDetail);
                }
            }
        }
    }

    /**
     * 医嘱 对应 治疗方案目的  初始化
     */
    public void readZlfaPurpose() {
        Set<String> strListByFileNmae = ReadResourceUtil.getStrListByFileNmae("tempfile/drugPurpose");
        for (String str : strListByFileNmae) {
            String[] split = str.trim().split("&");
            String drug = split[0];
            if (split.length == 2) {
                String purpose = split[1];
                drugPurposeMap.put(drug, purpose);
            } else {
                drugPurposeMap.put(drug, null);
            }
        }

    }

}
