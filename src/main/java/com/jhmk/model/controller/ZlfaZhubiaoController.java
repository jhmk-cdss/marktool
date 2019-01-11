package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.base.BaseEntityController;
import com.jhmk.model.bean.rule.Rule;
import com.jhmk.model.bean.sqlbean.*;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaMianDiagnosisDetailRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaOrderModelRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaZhubiaoRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaUpdateAddModelDetailRepService;
import com.jhmk.model.bean.tempbean.CollectionCompareBean;
import com.jhmk.model.bean.tempbean.ZlfaCompareBean;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.ZlfaMianDiagnosisDetailService;
import com.jhmk.model.service.ZlfaZhubiaoService;
import com.jhmk.model.util.CompareUtil;
import com.jhmk.model.util.UrlConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.jhmk.model.service.InitDataService.drugPurposeMap;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:47
 */
@Controller
@RequestMapping("zlfaZhubiao")
public class ZlfaZhubiaoController extends BaseEntityController<ZlfaZhubiao> {
    private static final Logger logger = LoggerFactory.getLogger(ZlfaZhubiaoController.class);
    @Autowired
    ZlfaZhubiaoService zlfaZhubiaoService;
    @Autowired
    ZlfaOrderModelRepService zlfaOrderModelRepService;
    @Autowired
    ZlfaZhubiaoRepService zlfaZhubiaoRepService;
    @Autowired
    ZlfaUpdateAddModelDetailRepService zlfaUpdateAddModelDetailRepService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;
    @Autowired
    ZlfaMianDiagnosisDetailRepService zlfaMianDiagnosisDetailRepService;
    @Autowired
    ZlfaMianDiagnosisDetailService zlfaMianDiagnosisDetailService;


    @PostMapping("/list")
    public void list(HttpServletResponse response, @RequestBody String map) {
        Map params = (Map) JSONObject.parse(map);
        AtResponse resp = super.listDataByMap(params, zlfaZhubiaoRepService, "createTime");
        wirte(response, resp);
    }

    @PostMapping("/search")
    public void search(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        String patient_id = object.getString("patient_id");
        String visitId = object.getString("visit_id");
        ZlfaZhubiao firstByPatientIdAndVisitId = zlfaZhubiaoRepService.findFirstByPatientIdAndVisitId(patient_id, visitId);
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        resp.setResponseCode(ResponseCode.OK);
        resp.setData(firstByPatientIdAndVisitId);
        wirte(response, resp);
    }


    @PostMapping("/delete")
    public void delete(HttpServletResponse response, @RequestBody String map) {
        JSONObject parse = JSONObject.parseObject(map);
        Integer id = parse.getInteger("id");
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        try {
            zlfaZhubiaoRepService.delete(id);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResponseCode(ResponseCode.INERERROR);
        }
        wirte(response, resp);
    }

    @PostMapping("/deleteList")
    public void deleteList(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        JSONArray jsonArray = object.getJSONArray("id");
        Iterator<Object> iterator = jsonArray.iterator();
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Integer id = Integer.valueOf(next.toString());
            try {
                zlfaZhubiaoRepService.delete(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }

    @PostMapping("/deletByCondition")
    public void deletByCondition(HttpServletResponse response, @RequestBody String map) {
        JSONObject parse = JSONObject.parseObject(map);
        Integer id = parse.getInteger("id");
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        List<Integer> gtIdList = zlfaZhubiaoRepService.getGtIdList(id);
        try {
            for (Integer sid : gtIdList) {
                zlfaZhubiaoRepService.delete(sid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }

    @PostMapping("/test")
    public void test(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        Iterable<ZlfaZhubiao> all = zlfaZhubiaoRepService.findAll();
//        String string = JSONObject.toJSONString(all);
        resp.setData(all);
        wirte(response, resp);
    }


    @PostMapping("/save")
    public void saveAll(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse();
        ZlfaZhubiao zlfaZhubiao = zlfaZhubiaoService.getZlfaZhubiaoResult(map);
        try {

            zlfaZhubiaoRepService.save(zlfaZhubiao);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("错误信息为{}", e.getCause());
            resp.setResponseCode(ResponseCode.INERERROR);

        }
        wirte(response, resp);
    }

    /**
     * 给治疗方案返回初始数据
     *
     * @param response
     * @param map
     */
    @PostMapping("/returnMainInitData")
    public void returnFirstInitData(HttpServletResponse response, @RequestBody String map) {
        Object parse = JSONObject.parse(map);
        logger.info("接受到的数据为：{}", map);
        String s = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getDataByPIdAndVId, parse, String.class);
        Rule rule = JSONObject.parseObject(s, Rule.class);
        ZlfaZhubiao zhubiao = zlfaZhubiaoService.rule2ZlfaZhubiao(rule);
        wirte(response, zhubiao);
    }

    /**
     * 给治疗方案返回初始数据
     *
     * @param response
     * @param map
     */
    @PostMapping("/returnInitData")
    public void returnInitData(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        String patient_id = object.getString("pid");
        String visitId = object.getString("vid");
        ZlfaZhubiao firstByPatientIdAndVisitId = zlfaZhubiaoRepService.findFirstByPatientIdAndVisitId(patient_id, visitId);
        if (firstByPatientIdAndVisitId != null) {
            wirte(response, firstByPatientIdAndVisitId);
        } else {
            Object parse = JSONObject.parse(map);
            String s = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getDataByPIdAndVId, parse, String.class);
            Rule rule = JSONObject.parseObject(s, Rule.class);
            ZlfaZhubiao zhubiao = zlfaZhubiaoService.ruleToZlfaZhubiao(rule);
            wirte(response, zhubiao);
        }

    }

    /**
     * 查询所有出院主诊断疾病名
     *
     * @param response
     */
    @PostMapping("/getAllDischargeMainDiagnosis")
    public void save(HttpServletResponse response) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        List<String> distinctDischargeMainDiagnosis = zlfaZhubiaoRepService.getDistinctDischargeMainDiagnosis();
        resp.setData(distinctDischargeMainDiagnosis);
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }

    /**
     * 获取所有治疗方案
     *
     * @param response
     */
    @PostMapping("/getAllFangan")
    public void find(HttpServletResponse response, @RequestBody(required = false) String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        if (StringUtils.isNotBlank(map)) {
            JSONObject object = JSONObject.parseObject(map);
            String dischargeMainDiagnosis = object.getString("dischargeMainDiagnosis");
            List<ZlfaZhubiao> allByDischargeMainDiagnosis = zlfaZhubiaoRepService.findAllByDischargeMainDiagnosis(dischargeMainDiagnosis);
            resp.setData(allByDischargeMainDiagnosis);
        } else {
            Iterable<ZlfaZhubiao> all = zlfaZhubiaoRepService.findAll();
            resp.setData(all);
        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);

    }

    /**
     * 获取所有治疗方案
     *
     * @param response
     */
    @PostMapping("/updateFangan")
    public void updateFangan(HttpServletResponse response, @RequestBody(required = false) String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        Iterable<ZlfaZhubiao> all = zlfaZhubiaoRepService.findAll();
        Iterator<ZlfaZhubiao> iterator = all.iterator();
        while (iterator.hasNext()) {
            ZlfaZhubiao next = iterator.next();
            String patientId = next.getPatientId();
            String visitId = next.getVisitId();
            Map<String, String> param = new HashMap<>(2);
            param.put("patientId", patientId);
            param.put("visitId", visitId);
            Object parse = JSONObject.toJSON(param);
            String s = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getTotalFeeAndHospitalDay, parse, String.class);
            if (StringUtils.isNotEmpty(s)) {
                JSONObject object = JSONObject.parseObject(s);
                String admissionTime = object.getString("admissionTime");
                String dischargeTime = object.getString("dischargeTime");
                float totalFee = object.getFloat("total_costs");
                int in_hospital_days = object.getInteger("in_hospital_days");
                next.setAdmissionTime(admissionTime);
                next.setDischargeTime(dischargeTime);
                next.setTotalCosts(totalFee);
                next.setInHospitalDays(in_hospital_days);
                zlfaZhubiaoRepService.save(next);
            }
        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);

    }

    /**
     * 添加用药治疗目的
     *
     * @param response
     * @param map
     */
    @GetMapping("/addDrugPurpose")
    public void addDrugPurpose(HttpServletResponse response, @RequestBody(required = false) String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        Iterable<ZlfaOrderModel> all = zlfaOrderModelRepService.findAll();
        Iterator<ZlfaOrderModel> iterator = all.iterator();
        while (iterator.hasNext()) {
            ZlfaOrderModel next = iterator.next();
            String orderItemName = next.getOrderItemName();
            if (drugPurposeMap.containsKey(orderItemName)) {
                String purpose = drugPurposeMap.get(drugPurposeMap);
                //如果是空  表示此药品不纳入 治疗方案 ，修改状态字段
                ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = next.getZlfaMianDiagnosisDetail();
                if (StringUtils.isEmpty(purpose)) {
                    zlfaMianDiagnosisDetail.setNotIncludedOrderIndicator(2);
                } else {
                    zlfaMianDiagnosisDetail.setNotIncludedOrderIndicator(1);
                    zlfaMianDiagnosisDetail.setTreatmentGoals(purpose);
                }
                zlfaMianDiagnosisDetailRepService.save(zlfaMianDiagnosisDetail);
            }

        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);

    }

    /**
     * 根据疾病名 获取主表的id
     *
     * @param response
     * @param map
     */
    @PostMapping("/getAllIdsByDischargeMainDiagnosis")
    public void getAllIdsByDischargeMainDiagnosis(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        JSONObject object = JSONObject.parseObject(map);
        String dischargeMainDiagnosis = object.getString("dischargeMainDiagnosis");
        List<ZlfaZhubiao> allByDischargeMainDiagnosis = zlfaZhubiaoRepService.findAllByDischargeMainDiagnosis(dischargeMainDiagnosis);
        List<String> idList = new ArrayList<>(allByDischargeMainDiagnosis.size());
        allByDischargeMainDiagnosis.forEach(s -> idList.add(s.getPatientId() + "#" + s.getVisitId()));
        resp.setData(idList);
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }

    /**
     * 分析治疗方案(主疾病第一次)
     *
     * @param response
     * @param map
     */
    @PostMapping("/analyzeZlfaMainDischargeMainDiagnosis")
    public void analyzeZlfa(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse();
        JSONObject object = JSONObject.parseObject(map);
        String dischargeMainDiagnosis = object.getString("dischargeMainDiagnosis");
        List<ZlfaZhubiao> allByDischargeMainDiagnosis = zlfaZhubiaoRepService.findAllByDischargeMainDiagnosis(dischargeMainDiagnosis);
        List<CollectionCompareBean> list = new ArrayList<>();
        lable:
        for (ZlfaZhubiao zhubiao : allByDischargeMainDiagnosis) {
            String patientId = zhubiao.getPatientId();
            String visitId = zhubiao.getVisitId();
            Float totalCosts = zhubiao.getTotalCosts();
            Integer inHospitalDays = zhubiao.getInHospitalDays();

            //治疗方案
            List<ZlfaCompareBean> zlfaCompareBeanList = new ArrayList<>();
            List<ZlfaModel> zlfaModelList = zhubiao.getZlfaModelList();
            if (zlfaModelList != null && zlfaModelList.size() > 0) {
                for (ZlfaModel zlfaModel : zlfaModelList) {

                    if ("1".equals(zlfaModel.getTreatmentPlanNum())) {
                        List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaModel.getZlfaMianDiagnosisDetailList();
                        for (ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail : zlfaMianDiagnosisDetailList) {
                            //1 代表治疗方案用药 2 代表无用的药
                            if (1 == zlfaMianDiagnosisDetail.getNotIncludedOrderIndicator()) {
                                ZlfaCompareBean zlfaCompareBean = new ZlfaCompareBean();
                                zlfaCompareBean.setMedicineTreatment(zlfaMianDiagnosisDetail.getMedicineTreatment());
                                zlfaCompareBean.setTreatmentGoals(zlfaMianDiagnosisDetail.getTreatmentGoals());
                                ZlfaOrderModel zlfaOrderModel = zlfaMianDiagnosisDetail.getZlfaOrderModel();
                                if (zlfaOrderModel != null) {
                                    zlfaCompareBean.setOrderItemName(zlfaOrderModel.getOrderItemName());
                                }
                                zlfaCompareBeanList.add(zlfaCompareBean);
                            }
                        }
                        CollectionCompareBean collectionCompareBean = new CollectionCompareBean();
                        collectionCompareBean.setColumnMetaData(zlfaCompareBeanList);
                        collectionCompareBean.setId("BJDXDSYY#" + patientId + "#" + visitId);
                        collectionCompareBean.setCount(1);
                        collectionCompareBean.setTotalFee(totalCosts);
                        collectionCompareBean.setInHospitalDay(inHospitalDays);
                        list.add(collectionCompareBean);
                        continue lable;
                    }
                }
            }
        }
   /*     Map<CollectionCompareBean, Integer> resultMap = new HashMap<>();
        for (CollectionCompareBean collectionCompareBean : list) {
            if (resultMap.containsKey(collectionCompareBean)) {
                resultMap.put(collectionCompareBean, resultMap.get(collectionCompareBean) + 1);
            } else {
                Set<String> idList = new HashSet<>(1);
//                idList.add()
                collectionCompareBean.setIdList(idList);

                resultMap.put(collectionCompareBean, 1);
            }
        }

        List<CollectionCompareBean> resultList = new ArrayList<>(resultMap.size());
        for (Map.Entry<CollectionCompareBean, Integer> entry : resultMap.entrySet()) {
            CollectionCompareBean key = entry.getKey();
            Integer value = entry.getValue();
            key.setCount(value);
            resultList.add(key);
        }
        Collections.sort(resultList, CompareUtil.createComparator(-1, "count"));
        resp.setData(resultList);
        */

        List<CollectionCompareBean> resultList = new ArrayList<>();
        for (CollectionCompareBean bean : list) {
            if (resultList.contains(bean)) {
                int i = resultList.indexOf(bean);
                CollectionCompareBean collectionCompareBean = list.get(i);
                //病历ID集合
                Set<String> idList = collectionCompareBean.getIdList();
                String id = bean.getId();
                idList.add(id);
                collectionCompareBean.setIdList(idList);
                //住院天数集合
                List<Integer> inHospitalDayList = collectionCompareBean.getInHospitalDayList();
                int inHospitalDay = bean.getInHospitalDay();
                inHospitalDayList.add(inHospitalDay);
                collectionCompareBean.setInHospitalDayList(inHospitalDayList);
                //总花费集合
                List<Float> totalFeeList = collectionCompareBean.getTotalFeeList();
                Float totalFee = bean.getTotalFee();
                totalFeeList.add(totalFee);
                collectionCompareBean.setTotalFeeList(totalFeeList);


                collectionCompareBean.setCount(collectionCompareBean.getCount() + 1);
            } else {
                bean.setCount(1);
                Set<String> idList = new HashSet<>();
                String id = bean.getId();
                idList.add(id);
                bean.setIdList(idList);

                List<Float> totalFeeList = new ArrayList<>(1);
                totalFeeList.add(bean.getTotalFee());
                bean.setTotalFeeList(totalFeeList);
                List<Integer> inHospitalDayList = new ArrayList<>(1);
                inHospitalDayList.add(bean.getInHospitalDay());
                bean.setInHospitalDayList(inHospitalDayList);

                resultList.add(bean);
            }
        }

        for (CollectionCompareBean bean : resultList) {
            List<Integer> inHospitalDayList = bean.getInHospitalDayList();
            List<Float> totalFeeList = bean.getTotalFeeList();
            int avgInHospitalDay = 0;
            float avgTotalFee = 0;

            for (Integer day : inHospitalDayList) {
                avgInHospitalDay += day;
            }
            for (Float fee : totalFeeList) {
                avgTotalFee += fee;
            }
            bean.setAvgTotalFee(avgTotalFee / totalFeeList.size());
            bean.setAvgInHospitalDay(avgInHospitalDay / inHospitalDayList.size());
        }
        Collections.sort(resultList, CompareUtil.createComparator(-1, "count"));
        logger.info("=============》》》》》》》》》》》》》治疗方案总共{}种", resultList.size());
        resp.setData(resultList);
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }

    public static void main(String[] args) {

        List<CollectionCompareBean> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CollectionCompareBean collectionCompareBean1 = new CollectionCompareBean();
            List<ZlfaCompareBean> list1 = new ArrayList<>();
            ZlfaCompareBean zlfaCompareBean = new ZlfaCompareBean();
            zlfaCompareBean.setOrderItemName("1");
            zlfaCompareBean.setMedicineTreatment("1");
            zlfaCompareBean.setTreatmentGoals("1");
            ZlfaCompareBean zlfaCompareBean2 = new ZlfaCompareBean();
            zlfaCompareBean2.setOrderItemName("2");
            zlfaCompareBean2.setMedicineTreatment("2");
            zlfaCompareBean2.setTreatmentGoals("2");
            list1.add(zlfaCompareBean);
            list1.add(zlfaCompareBean2);
            collectionCompareBean1.setColumnMetaData(list1);
            resultList.add(collectionCompareBean1);
        }

        CollectionCompareBean collectionCompareBean1 = new CollectionCompareBean();
        List<ZlfaCompareBean> list1 = new ArrayList<>();
        ZlfaCompareBean zlfaCompareBean = new ZlfaCompareBean();
        zlfaCompareBean.setOrderItemName("1");
        zlfaCompareBean.setMedicineTreatment("1");
        zlfaCompareBean.setTreatmentGoals("1");
        ZlfaCompareBean zlfaCompareBean2 = new ZlfaCompareBean();
        zlfaCompareBean2.setOrderItemName("2");
        zlfaCompareBean2.setMedicineTreatment("2");
        zlfaCompareBean2.setTreatmentGoals("2");
        list1.add(zlfaCompareBean2);
        list1.add(zlfaCompareBean);
        collectionCompareBean1.setColumnMetaData(list1);
        resultList.add(collectionCompareBean1);

        Map<CollectionCompareBean, Integer> resultMap = new HashMap<>();
        for (CollectionCompareBean collectionCompareBean : resultList) {
            if (resultMap.containsKey(collectionCompareBean)) {
                resultMap.put(collectionCompareBean, resultMap.get(collectionCompareBean) + 1);
            } else {
                Set<String> idList = new HashSet<>(1);
//                idList.add()
                collectionCompareBean.setIdList(idList);

                resultMap.put(collectionCompareBean, 1);
            }
        }
        System.out.println(resultMap);
    }


    /**
     * 1229  王伟医嘱没有加进去 把主疾病治疗方案对应医嘱 加进去
     */
    @GetMapping("/demo")
    public void demo() {
        List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaMianDiagnosisDetailService.getZlfaMianDiagnosisDetailList();
        System.out.println(zlfaMianDiagnosisDetailList);
    }

    /**
     * 匹配之前的治疗方案 形成新的治疗方案
     *
     * @param response
     * @param map
     */
    @PostMapping("/saveZlfazhubiaoByRule")
    public void runDatabase(HttpServletResponse response, @RequestBody String map) {
        Rule rule = JSONObject.parseObject(map, Rule.class);
        String patientId = rule.getPatient_id();
        String visitId = rule.getVisit_id();
        ZlfaZhubiao firstByPatientIdAndVisitId = zlfaZhubiaoRepService.findFirstByPatientIdAndVisitId(patientId, visitId);
        if (firstByPatientIdAndVisitId == null) {
            ZlfaZhubiao zhubiao = zlfaZhubiaoService.rule2ZlfaZhubiao(rule);
            ZlfaZhubiao zlfaZhubiao = zlfaZhubiaoService.getZlfaZhubiaoResult(zhubiao);
            List<ZlfaModel> zlfaModelList = zlfaZhubiao.getZlfaModelList();
            if (zlfaModelList.size() > 0) {
                ZlfaZhubiao save = zlfaZhubiaoRepService.save(zlfaZhubiao);
                wirte(response, save);
            }
        }

    }


}
