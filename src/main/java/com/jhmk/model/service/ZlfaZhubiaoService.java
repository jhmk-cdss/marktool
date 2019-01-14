package com.jhmk.model.service;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.rule.*;
import com.jhmk.model.bean.sqlbean.*;
import com.jhmk.model.bean.sqlbean.repository.service.*;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.util.CompareUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.jhmk.model.service.InitDataService.yizhuMap;

/**
 * @author ziyu.zhou
 * @date 2018/12/17 10:29
 */
@Service
public class ZlfaZhubiaoService {
    @Autowired
    ZlfaZhubiaoRepService zlfaZhubiaoRepService;
    @Autowired
    ZlfaZhubiaoService zlfaZhubiaoService;
    @Autowired
    ZlfaModelRepService zlfaModelRepService;
    @Autowired
    ZlfaOrderModelRepService zlfaOrderModelRepService;
    @Autowired
    ZlfaSubordinationDiagnosisDetailRepService zlfaSubordinationDiagnosisDetailRepService;
    @Autowired
    ZlfaMianDiagnosisDetailRepService zlfaMianDiagnosisDetailRepService;
    @Autowired
    ZlfaUpdateDeleteModelRepService zlfaUpdateDeleteModelRepService;
    @Autowired
    ZlfaIncidentModelRepService zlfaIncidentModelRepService;
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;
    @Autowired
    ZlfaUpdateAddModelDetailRepService zlfaUpdateAddModelDetailRepService;

    @Transactional
//    public void saveAll(String map) {
//        ZlfaZhubiao zlfaZhubiao = JSONObject.parseObject(map, ZlfaZhubiao.class);
//        List<ZlfaModel> zlfaModelList = zlfaZhubiao.getZlfaModelList();
//        ZlfaZhubiao zhubiao = zlfaZhubiaoRepService.save(zlfaZhubiao);
//        for (ZlfaModel zlfaModel : zlfaModelList) {
//            zlfaModel.setZlfaZhubiao(zhubiao);
//            //治疗方案模型
//            ZlfaModel model = zlfaModelRepService.save(zlfaModel);
//            //治疗方案主
//            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = model.getZlfaMianDiagnosisDetailList();
//            for (ZlfaMianDiagnosisDetail bean : zlfaMianDiagnosisDetailList) {
////                bean.setZlfnModelId(modelId);
//                bean.setZlfaModel(model);
//                //主疾病治疗方案明细
//                ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = zlfaMianDiagnosisDetailRepService.save(bean);
//                int zlfaMianDiagnosisDetailId = zlfaMianDiagnosisDetail.getId();//主疾病治疗方案明细id
//                List<ZlfaOrderModel> zlfaOrderModelList = zlfaMianDiagnosisDetail.getZlfaOrderModel();
//                if (zlfaOrderModelList != null && zlfaOrderModelList.size() > 0) {
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
////                        zlfaOrderModel.setZlfaMianDiagnosisDetailId(zlfaMianDiagnosisDetailId);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //主疾病治疗方案明细
//            List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList = model.getZlfaSubordinationDiagnosisDetailList();
//            if (zlfaSubordinationDiagnosisDetailList != null && zlfaSubordinationDiagnosisDetailList.size() > 0) {
//                for (ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail : zlfaSubordinationDiagnosisDetailList) {
//                    zlfaSubordinationDiagnosisDetail.setZlfaModel(model);
////                    zlfaSubordinationDiagnosisDetail.setZlfnModelId(modelId);
//                    ZlfaSubordinationDiagnosisDetail zlfaMianDiagnosisDetailBean = zlfaSubordinationDiagnosisDetailRepService.save(zlfaSubordinationDiagnosisDetail);
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfaSubordinationDiagnosisDetail.getZlfaOrderModel();
//                    if (zlfaOrderModelList != null && zlfaOrderModelList.size() > 0) {
//                        for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                            zlfaOrderModel.setZlfaSubordinationDiagnosisDetail(zlfaMianDiagnosisDetailBean);
//                        }
//                        zlfaOrderModelRepService.save(zlfaOrderModelList);
//                    }
//                }
//            }
//            //增加
//            List<ZlfaUpdateAddModel> increaseList = model.getIncreaseList();
//            if (increaseList != null && increaseList.size() > 0) {
//                for (ZlfaUpdateAddModel zlfnUpdateAddModel : increaseList) {
//                    zlfnUpdateAddModel.setZlfaModel(zlfaModel);
//                    ZlfaUpdateAddModel zlfnUpdateAddModel1 = zlfaUpdateAddModelDetailRepService.save(zlfnUpdateAddModel);
//                    //事件模型
//                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateAddModel1.getZlfaIncidentModelList();
//                    for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                        zlfaIncidentModel.setZlfaUpdateAddModel(zlfnUpdateAddModel1);
//                    }
//                    zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                    //医嘱模型
//                    List<ZlfaOrderModel> zlfaOrderModelList = zlfnUpdateAddModel1.getZlfaOrderModel();
//                    for (ZlfaOrderModel zlfaOrderModel : zlfaOrderModelList) {
//                        zlfaOrderModel.setZlfaUpdateAddModel(zlfnUpdateAddModel1);
//                    }
//                    zlfaOrderModelRepService.save(zlfaOrderModelList);
//                }
//            }
//            //减少
//            List<ZlfaUpdateDeleteModel> decreaseList = model.getDecreaseList();
//
//
//            for (ZlfaUpdateDeleteModel zlfnUpdateDeleteModel : decreaseList) {
//                zlfnUpdateDeleteModel.setZlfaModel(model);
//                ZlfaUpdateDeleteModel zlfnUpdateDeleteModelBean = zlfaUpdateDeleteModelRepService.save(zlfnUpdateDeleteModel);
//                //治疗方案事件模型
//                List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateDeleteModel.getZlfaIncidentModelList();
//                for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
//                    zlfaIncidentModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModelBean);
//                }
//                zlfaIncidentModelRepService.save(zlfaIncidentModelList);
//                ZlfaOrderModel zlfaOrderModel = zlfnUpdateDeleteModel.getZlfaOrderModel();
//                zlfaOrderModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModelBean);
//                zlfaOrderModelRepService.save(zlfaOrderModelList);
//            }
//        }
//
//    }

    public ZlfaZhubiao getZlfaZhubiaoResult(String map) {
        ZlfaZhubiao zhubiao = JSONObject.parseObject(map, ZlfaZhubiao.class);
        //治疗方案模型
        List<ZlfaModel> zlfaModelList = zhubiao.getZlfaModelList();
        for (ZlfaModel zlfaModel : zlfaModelList) {
            zlfaModel.setZlfaZhubiao(zhubiao);
            //主疾病治疗方案明细
            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaModel.getZlfaMianDiagnosisDetailList();
            if (zlfaMianDiagnosisDetailList != null) {
                for (ZlfaMianDiagnosisDetail bean : zlfaMianDiagnosisDetailList) {
                    bean.setZlfaModel(zlfaModel);
                    ZlfaOrderModel zlfaOrderModel = bean.getZlfaOrderModel();
                    Optional.ofNullable(zlfaOrderModel).ifPresent(s -> zlfaOrderModel.setZlfaMianDiagnosisDetail(bean));
                }
            }

            //伴随疾病治疗方案明细
            List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList = zlfaModel.getZlfaSubordinationDiagnosisDetailList();
            if (zlfaSubordinationDiagnosisDetailList != null && zlfaSubordinationDiagnosisDetailList.size() > 0) {
                for (ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail : zlfaSubordinationDiagnosisDetailList) {
                    zlfaSubordinationDiagnosisDetail.setZlfaModel(zlfaModel);
                    ZlfaOrderModel zlfaOrderModel = zlfaSubordinationDiagnosisDetail.getZlfaOrderModel();
                    Optional.ofNullable(zlfaOrderModel).ifPresent(s -> zlfaOrderModel.setZlfaSubordinationDiagnosisDetail(zlfaSubordinationDiagnosisDetail));
                }
            }
            //增加
            List<ZlfaUpdateAddModel> increaseList = zlfaModel.getIncreaseList();
            if (increaseList != null && increaseList.size() > 0) {
                for (ZlfaUpdateAddModel zlfnUpdateAddModel : increaseList) {
                    zlfnUpdateAddModel.setZlfaModel(zlfaModel);
                    //事件模型
                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateAddModel.getZlfaIncidentModelList();
                    if (zlfaIncidentModelList != null) {

                        for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
                            zlfaIncidentModel.setZlfaUpdateAddModel(zlfnUpdateAddModel);
                        }
                    }
                    //医嘱模型
                    ZlfaOrderModel zlfaOrderModel = zlfnUpdateAddModel.getZlfaOrderModel();
                    zlfaOrderModel.setZlfaUpdateAddModel(zlfnUpdateAddModel);
                }
            }
            //减少
            List<ZlfaUpdateDeleteModel> decreaseList = zlfaModel.getDecreaseList();
            if (decreaseList != null && !decreaseList.isEmpty()) {

                for (ZlfaUpdateDeleteModel zlfnUpdateDeleteModel : decreaseList) {
                    zlfnUpdateDeleteModel.setZlfaModel(zlfaModel);
                    //治疗方案事件模型
                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateDeleteModel.getZlfaIncidentModelList();
                    if (zlfaIncidentModelList != null) {

                        for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
                            zlfaIncidentModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModel);
                        }
                    }
                    ZlfaOrderModel zlfaOrderModel = zlfnUpdateDeleteModel.getZlfaOrderModel();
                    zlfaOrderModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModel);
                }
            }

        }
        return zhubiao;
    }

    public ZlfaZhubiao getZlfaZhubiaoResult(ZlfaZhubiao zhubiao) {
        //治疗方案模型
        List<ZlfaModel> zlfaModelList = zhubiao.getZlfaModelList();
        for (ZlfaModel zlfaModel : zlfaModelList) {
            zlfaModel.setZlfaZhubiao(zhubiao);
            //主疾病治疗方案明细
            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaModel.getZlfaMianDiagnosisDetailList();
            if (zlfaMianDiagnosisDetailList != null) {
                for (ZlfaMianDiagnosisDetail bean : zlfaMianDiagnosisDetailList) {
                    bean.setZlfaModel(zlfaModel);
                    ZlfaOrderModel zlfaOrderModel = bean.getZlfaOrderModel();
                    Optional.ofNullable(zlfaOrderModel).ifPresent(s -> zlfaOrderModel.setZlfaMianDiagnosisDetail(bean));
                }
            }

            //伴随疾病治疗方案明细
            List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList = zlfaModel.getZlfaSubordinationDiagnosisDetailList();
            if (zlfaSubordinationDiagnosisDetailList != null && zlfaSubordinationDiagnosisDetailList.size() > 0) {
                for (ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail : zlfaSubordinationDiagnosisDetailList) {
                    zlfaSubordinationDiagnosisDetail.setZlfaModel(zlfaModel);
                    ZlfaOrderModel zlfaOrderModel = zlfaSubordinationDiagnosisDetail.getZlfaOrderModel();
                    Optional.ofNullable(zlfaOrderModel).ifPresent(s -> zlfaOrderModel.setZlfaSubordinationDiagnosisDetail(zlfaSubordinationDiagnosisDetail));
                }
            }
            //增加
            List<ZlfaUpdateAddModel> increaseList = zlfaModel.getIncreaseList();
            if (increaseList != null && increaseList.size() > 0) {
                for (ZlfaUpdateAddModel zlfnUpdateAddModel : increaseList) {
                    zlfnUpdateAddModel.setZlfaModel(zlfaModel);
                    //事件模型
                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateAddModel.getZlfaIncidentModelList();
                    if (zlfaIncidentModelList != null) {

                        for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
                            zlfaIncidentModel.setZlfaUpdateAddModel(zlfnUpdateAddModel);
                        }
                    }
                    //医嘱模型
                    ZlfaOrderModel zlfaOrderModel = zlfnUpdateAddModel.getZlfaOrderModel();
                    zlfaOrderModel.setZlfaUpdateAddModel(zlfnUpdateAddModel);
                }
            }
            //减少
            List<ZlfaUpdateDeleteModel> decreaseList = zlfaModel.getDecreaseList();
            if (decreaseList != null && !decreaseList.isEmpty()) {

                for (ZlfaUpdateDeleteModel zlfnUpdateDeleteModel : decreaseList) {
                    zlfnUpdateDeleteModel.setZlfaModel(zlfaModel);
                    //治疗方案事件模型
                    List<ZlfaIncidentModel> zlfaIncidentModelList = zlfnUpdateDeleteModel.getZlfaIncidentModelList();
                    if (zlfaIncidentModelList != null) {

                        for (ZlfaIncidentModel zlfaIncidentModel : zlfaIncidentModelList) {
                            zlfaIncidentModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModel);
                        }
                    }
                    ZlfaOrderModel zlfaOrderModel = zlfnUpdateDeleteModel.getZlfaOrderModel();
                    zlfaOrderModel.setZlfaUpdateDeleteModel(zlfnUpdateDeleteModel);
                }
            }

        }
        return zhubiao;
    }

    public ZlfaZhubiao rule2ZlfaZhubiao(Rule rule) {
        ZlfaZhubiao zhubiao = new ZlfaZhubiao();
        String patientId = rule.getPatient_id();
        String visitId = rule.getVisit_id();
        Binganshouye binganshouye = rule.getBinganshouye();
        //todo  骨科
//        List<Shouyeshoushu> shouyeshoushu = rule.getShouyeshoushu();

        List<Yizhu> yizhuList = rule.getYizhu();
        List<Shouyeshoushu> shouyeshoushu = rule.getShouyeshoushu();
        String rycz = rule.getRycz();
        String cyzd = rule.getCyzd();
        if (binganshouye != null) {
            zhubiao.setDoctorId(binganshouye.getPat_visit_dept_request_doctor_name());
            zhubiao.setAdmissionMainDiagnosis(rycz);
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setDeptName(binganshouye.getDept_admission_to_name());
            zhubiao.setCreateTime(new Date());
            zhubiao.setHospitalName("北医三院");
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setPatientId(patientId);
            zhubiao.setVisitId(visitId);
            zhubiao.setAdmissionTime(binganshouye.getAdmission_time());
            zhubiao.setDischargeTime(binganshouye.getDischarge_time());
            zhubiao.setInHospitalDays(rule.getHospitalDay());
            zhubiao.setTotalCosts(rule.getTotal_costs());
            //患者病情分类
//            zhubiao.setPatientConditionClassification();
        }
        Set<String> dayTimeSet = new HashSet<>();
        /**
         * 将数据的daytime放入set中 ，排序，知道数据 就知道有几种变化情况
         */
        for (Yizhu bean : yizhuList) {
            String dayTime = bean.getOrder_begin_time().replaceAll("-", "").substring(0, 8);
            if (bean.getOrder_end_time() != null) {
                String endDayTime = bean.getOrder_end_time().replaceAll("-", "").substring(0, 8);
                bean.setEndDayTime(endDayTime);
                dayTimeSet.add(endDayTime);
            }


            bean.setDayTime(dayTime);
            dayTimeSet.add(dayTime);
        }
        //排序
        ArrayList<String> dayTimeList = new ArrayList(dayTimeSet);
        Collections.sort(dayTimeList);
        Collections.sort(yizhuList, CompareUtil.createComparator(-1, "dayTime"));
        //将数据放入治疗方案
//        for (String key : dayTimeList) {
//            List<Yizhu> tempYizhu = new ArrayList<>();
//            for (Yizhu bean : yizhuList) {
//                if (key.equals(bean.getDayTime())) {
//                    tempYizhu.add(bean);
//                }
//            }
        //todo 返回所有治疗方案
        List<ZlfaModel> zlfaModelList = getZlfaModelList(dayTimeList, yizhuList, shouyeshoushu);
        //todo 返回初始治疗方案
//        List<ZlfaModel> zlfaModelList = getZlfaModel(dayTimeList, yizhuList, shouyeshoushu);
        zlfaModelList.forEach(s -> s.setZlfaZhubiao(zhubiao));
        zhubiao.setZlfaModelList(zlfaModelList);
        return zhubiao;
    }

    public ZlfaZhubiao ruleToZlfaZhubiao(Rule rule) {
        ZlfaZhubiao zhubiao = new ZlfaZhubiao();
        String patientId = rule.getPatient_id();
        String visitId = rule.getVisit_id();
        String id = rule.getId();
        Binganshouye binganshouye = rule.getBinganshouye();
        List<Yizhu> yizhuList = rule.getYizhu();
        List<Shouyeshoushu> shouyeshoushu = rule.getShouyeshoushu();
//        List<Shouyezhenduan> shouyezhenduan = rule.getShouyezhenduan();
        String rycz = rule.getRycz();
        String cyzd = rule.getCyzd();
        if (binganshouye != null) {
            zhubiao.setDoctorId(binganshouye.getPat_visit_dept_request_doctor_name());
            zhubiao.setAdmissionMainDiagnosis(rycz);
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setDeptName(binganshouye.getDept_admission_to_name());
            zhubiao.setCreateTime(new Date());
            zhubiao.setHospitalName("北医三院");
            zhubiao.setDischargeMainDiagnosis(cyzd);
            zhubiao.setPatientId(patientId);
            zhubiao.setVisitId(visitId);
            //患者病情分类
//            zhubiao.setPatientConditionClassification();
        }
        Set<String> dayTimeSet = new HashSet<>();
        /**
         * 将数据的daytime放入set中 ，排序，知道数据 就知道有几种变化情况
         */
        for (Yizhu bean : yizhuList) {
            String dayTime = bean.getOrder_begin_time().replaceAll("-", "").substring(0, 8);
            try {
                String order_end_time = bean.getOrder_end_time();
                if (StringUtils.isNotBlank(order_end_time)) {
                    String endDayTime = order_end_time.replaceAll("-", "").substring(0, 8);
                    bean.setEndDayTime(endDayTime);
                    dayTimeSet.add(endDayTime);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            bean.setDayTime(dayTime);
            dayTimeSet.add(dayTime);
        }
        //排序
        ArrayList<String> dayTimeList = new ArrayList(dayTimeSet);
        Collections.sort(dayTimeList);
//        Collections.sort(yizhuList, CompareUtil.createComparator(-1, "dayTime"));
        List<ZlfaModel> zlfaModelList = getZlfaModelList(dayTimeList, yizhuList,shouyeshoushu);
        zhubiao.setZlfaModelList(zlfaModelList);
        return zhubiao;
    }


    /**
     * 将医嘱按时间排序  放入map中
     *
     * @param yizhuList
     * @return
     */
    public Map<String, List<Yizhu>> analyzeYizhu2Map(List<Yizhu> yizhuList) {
        List<CalculateZlfa> calculateZlfaList = new ArrayList<>();
        Set<String> timeSet = new HashSet<>();
        //增加医嘱
        //减少医嘱
        //初始医嘱
        Map<String, List<Yizhu>> increaseYizhuMap = new HashMap<>();
        Map<String, List<Yizhu>> decreaseYizhuMap = new HashMap<>();
        Map<String, List<Yizhu>> tempYizhuMap = new HashMap<>();
        Map<String, List<Yizhu>> initYizhuMap = new HashMap<>();
        for (int i = 0; i < yizhuList.size(); i++) {
            Yizhu yizhu = yizhuList.get(i);
            //医嘱执行时间
            String dayTime = yizhu.getDayTime();
            //医嘱结束时间
            String endDayTime = yizhu.getEndDayTime();
            timeSet.add(dayTime);
            timeSet.add(endDayTime);
            //长期/临时
            String order_properties_name = yizhu.getOrder_properties_name();
//                calculateZlfaList.
            if (increaseYizhuMap.containsKey(dayTime)) {
                List<Yizhu> yizhus = increaseYizhuMap.get(dayTime);
                yizhus.add(yizhu);
                increaseYizhuMap.put(dayTime, yizhus);
            } else {
                List<Yizhu> yizhus = new ArrayList<>(1);
                yizhus.add(yizhu);
                increaseYizhuMap.put(dayTime, yizhus);
            }
            if (decreaseYizhuMap.containsKey(endDayTime)) {
                List<Yizhu> yizhus = decreaseYizhuMap.get(dayTime);
                yizhus.add(yizhu);
                decreaseYizhuMap.put(dayTime, yizhus);
            } else {
                List<Yizhu> yizhus = new ArrayList<>(1);
                yizhus.add(yizhu);
                decreaseYizhuMap.put(dayTime, yizhus);
            }
        }
        ArrayList<String> strings = new ArrayList<>(timeSet);
        Collections.sort(strings);
        for (String time : strings) {
            if (increaseYizhuMap.containsKey(time)) {
                List<Yizhu> yizhus = increaseYizhuMap.get(time);
            }
            if (decreaseYizhuMap.containsKey(time)) {
                List<Yizhu> yizhus = decreaseYizhuMap.get(time);
            }
        }

        return null;
    }


    /**
     * @param orderTimeList 治疗时间
     * @param yizhuList
     * @return
     */
    public List<ZlfaModel> getZlfaModelList(List<String> orderTimeList, List<Yizhu> yizhuList, List<Shouyeshoushu> shouyeshoushuList) {
        List<ZlfaModel> resultList = new ArrayList<>();
        //
        for (int i = 1; i <= orderTimeList.size(); i++) {
            //时间
            String orderTime = orderTimeList.get(i - 1);
            ZlfaModel zlfaModel = new ZlfaModel();

            //治疗方案num
            zlfaModel.setTreatmentPlanNum(String.valueOf(i));
            //将数据放入治疗方案
            List<Yizhu> tempYizhu = new ArrayList<>();
            for (Yizhu bean : yizhuList) {
                //如果医嘱开始时间 在要比对的医嘱之前  则加入集合 进行对比
                if (orderTime.compareTo(bean.getDayTime()) >= 0) {
                    tempYizhu.add(bean);
                }
            }
            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = null;
            if (i == 1) {
                zlfaMianDiagnosisDetailList = getZlfaMianDiagnosisDetail(orderTime, tempYizhu, shouyeshoushuList);
            } else {
                zlfaMianDiagnosisDetailList = getZlfaMianDiagnosisDetail(orderTime, tempYizhu);
            }
            zlfaModel.setZlfaMianDiagnosisDetailList(zlfaMianDiagnosisDetailList);
            List<ZlfaUpdateAddModel> zlfaUpdateAddModelList = getZlfaUpdateAddModel(orderTime, tempYizhu);
            zlfaModel.setIncreaseList(zlfaUpdateAddModelList);
            List<ZlfaUpdateDeleteModel> zlfaUpdateDeleteModelList = getZlfaUpdateDeleteModel(orderTime, tempYizhu);
            zlfaModel.setDecreaseList(zlfaUpdateDeleteModelList);
            resultList.add(zlfaModel);
        }
        return resultList;
    }

//    public List<ZlfaModel> getZlfaModel(List<String> orderTimeList, List<Yizhu> yizhuList) {
//        List<ZlfaModel> resultList = new ArrayList<>();
//        //
//        //第一天开医嘱时间
//        String orderTime = orderTimeList.get(0);
//        ZlfaModel zlfaModel = new ZlfaModel();
//        //治疗方案num
//        zlfaModel.setTreatmentPlanNum("1");
//        //将数据放入治疗方案
//        List<Yizhu> tempYizhu = new ArrayList<>();
//        for (Yizhu bean : yizhuList) {
//            if (orderTime.compareTo(bean.getDayTime()) >= 0) {
//                tempYizhu.add(bean);
//            }
//        }
//        List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = getZlfaMianDiagnosisDetail(orderTime, tempYizhu);
//        zlfaModel.setZlfaMianDiagnosisDetailList(zlfaMianDiagnosisDetailList);
//
//        List<ZlfaUpdateAddModel> zlfaUpdateAddModelList = getZlfaUpdateAddModel(orderTime, tempYizhu);
//        zlfaModel.setIncreaseList(zlfaUpdateAddModelList);
//        List<ZlfaUpdateDeleteModel> zlfaUpdateDeleteModelList = getZlfaUpdateDeleteModel(orderTime, tempYizhu);
//        zlfaModel.setDecreaseList(zlfaUpdateDeleteModelList);
//        resultList.add(zlfaModel);
//        return resultList;
//    }

    public List<ZlfaModel> getZlfaModel(List<String> orderTimeList, List<Yizhu> yizhuList, List<Shouyeshoushu> shouyeshoushuList) {
        List<ZlfaModel> resultList = new ArrayList<>();
        //
        //第一天开医嘱时间
        if (orderTimeList.size() > 0) {
            String orderTime = orderTimeList.get(0);
            ZlfaModel zlfaModel = new ZlfaModel();
            //治疗方案num
            zlfaModel.setTreatmentPlanNum("1");
            //将数据放入治疗方案
            List<Yizhu> tempYizhu = new ArrayList<>();
            Set<String> tempNames = new HashSet<>();
            for (Yizhu bean : yizhuList) {
                if (orderTime.compareTo(bean.getDayTime()) >= 0 && !tempNames.contains(bean.getOrder_item_name())) {
                    tempNames.add(bean.getOrder_item_name());
                    tempYizhu.add(bean);
                }
            }
            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = getZlfaMianDiagnosisDetail(orderTime, tempYizhu, shouyeshoushuList);
            zlfaModel.setZlfaMianDiagnosisDetailList(zlfaMianDiagnosisDetailList);
            List<ZlfaUpdateAddModel> zlfaUpdateAddModelList = getZlfaUpdateAddModel(orderTime, tempYizhu);
            zlfaModel.setIncreaseList(zlfaUpdateAddModelList);
            List<ZlfaUpdateDeleteModel> zlfaUpdateDeleteModelList = getZlfaUpdateDeleteModel(orderTime, tempYizhu);
            zlfaModel.setDecreaseList(zlfaUpdateDeleteModelList);
            resultList.add(zlfaModel);
        }

        return resultList;
    }

    /**
     * 返回比对时间当天结束的医嘱集合
     *
     * @param orderTime 比对时间
     * @param yizhuList
     * @return
     */

    private List<ZlfaUpdateDeleteModel> getZlfaUpdateDeleteModel(String orderTime, List<Yizhu> yizhuList) {
        List<ZlfaUpdateDeleteModel> resultList = new ArrayList<>();
        for (int j = 0; j < yizhuList.size(); j++) {
            Yizhu yizhu = yizhuList.get(j);
            //主疾病治疗方案
            ZlfaUpdateDeleteModel zlfaUpdateDeleteModel = new ZlfaUpdateDeleteModel();
            //医嘱模型
            if (orderTime.equals(yizhuList.get(j).getEndDayTime())) {
                //将主疾病理疗方案放入治疗方案model
                ZlfaOrderModel zlfaModel = getZlfaOrderModel(yizhu);
                zlfaUpdateDeleteModel.setZlfaOrderModel(zlfaModel);
                resultList.add(zlfaUpdateDeleteModel);
            }
        }
        return resultList;
    }

    /**
     * 更改增加模型
     *
     * @param orderTime 第一天开医嘱时间
     * @param yizhuList 所有医嘱
     * @return
     */

    private List<ZlfaUpdateAddModel> getZlfaUpdateAddModel(String orderTime, List<Yizhu> yizhuList) {
        List<ZlfaUpdateAddModel> resultList = new ArrayList<>();
        for (int j = 0; j < yizhuList.size(); j++) {
            Yizhu yizhu = yizhuList.get(j);
            //主疾病治疗方案
            ZlfaUpdateAddModel zlfaUpdateAddModel = new ZlfaUpdateAddModel();
            //医嘱模型
            if (orderTime.equals(yizhuList.get(j).getDayTime())) {
                //将主疾病理疗方案放入治疗方案model
                ZlfaOrderModel zlfaModel = getZlfaOrderModel(yizhu);
                zlfaUpdateAddModel.setZlfaOrderModel(zlfaModel);
                resultList.add(zlfaUpdateAddModel);
            }
        }
        return resultList;
    }

    /**
     * 主疾病治疗方案明细  当天开的+当天之前的长期且未结束的医嘱
     *
     * @param orderTime 医嘱时间
     * @param yizhuList
     * @return
     */

    public List<ZlfaMianDiagnosisDetail> getZlfaMianDiagnosisDetail(String orderTime, List<Yizhu> yizhuList) {
        List<ZlfaMianDiagnosisDetail> resultList = new ArrayList<>();
        for (int j = 0; j < yizhuList.size(); j++) {
            Yizhu yizhu = yizhuList.get(j);
            //主疾病治疗方案
            ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = new ZlfaMianDiagnosisDetail();
            //医嘱模型  当天开的医嘱+之前开的长期且未结束（结束时间>比对时间）的医嘱
            if (orderTime.equals(yizhu.getDayTime()) || ("长期".equals(yizhu.getOrder_properties_name()) && orderTime.compareTo(yizhu.getEndDayTime()) < 0)) {
                //将主疾病理疗方案放入治疗方案model
                ZlfaOrderModel zlfaModel = getZlfaOrderModel(yizhu);
                String order_item_name = yizhu.getOrder_item_name();
                if (yizhuMap.containsKey(order_item_name)) {
                    ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail1 = yizhuMap.get(order_item_name);
                    zlfaMianDiagnosisDetail.setMedicineTreatment(zlfaMianDiagnosisDetail1.getMedicineTreatment());
                    zlfaMianDiagnosisDetail.setTreatmentGoals(zlfaMianDiagnosisDetail1.getTreatmentGoals());
                }
                zlfaMianDiagnosisDetail.setZlfaOrderModel(zlfaModel);
                resultList.add(zlfaMianDiagnosisDetail);
            }
        }
        return resultList;
    }

    public List<ZlfaMianDiagnosisDetail> getZlfaMianDiagnosisDetail(String orderTime, List<Yizhu> yizhuList, List<Shouyeshoushu> shouyeshoushuList) {
        List<ZlfaMianDiagnosisDetail> resultList = new ArrayList<>();
        for (int j = 0; j < yizhuList.size(); j++) {
            Yizhu yizhu = yizhuList.get(j);
            //主疾病治疗方案
            ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = new ZlfaMianDiagnosisDetail();
            //医嘱模型  当天开的医嘱+之前开的长期且未结束（结束时间>比对时间）的医嘱
            if (orderTime.equals(yizhu.getDayTime()) || ("长期".equals(yizhu.getOrder_properties_name()) && orderTime.compareTo(yizhu.getEndDayTime()) < 0)) {
                //将主疾病理疗方案放入治疗方案model
                ZlfaOrderModel zlfaModel = getZlfaOrderModel(yizhu);
                String order_item_name = yizhu.getOrder_item_name();
                if (yizhuMap.containsKey(order_item_name)) {
                    ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail1 = yizhuMap.get(order_item_name);
                    zlfaMianDiagnosisDetail.setMedicineTreatment(zlfaMianDiagnosisDetail1.getMedicineTreatment());
                    zlfaMianDiagnosisDetail.setTreatmentGoals(zlfaMianDiagnosisDetail1.getTreatmentGoals());
                }
                zlfaMianDiagnosisDetail.setZlfaOrderModel(zlfaModel);
                resultList.add(zlfaMianDiagnosisDetail);
            }
        }
        /**
         * 骨科 手术也作为主诊断第一次治疗
         */
        Set<String> shoushuSet = new HashSet<>();
        for (Shouyeshoushu shouyeshoushu : shouyeshoushuList) {
            shoushuSet.add(shouyeshoushu.getOperation_name());
        }
        for (String name : shoushuSet) {
            ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail = new ZlfaMianDiagnosisDetail();
            zlfaMianDiagnosisDetail.setTreatmentGoals("手术治疗");
            zlfaMianDiagnosisDetail.setMedicineTreatment(name);
            resultList.add(zlfaMianDiagnosisDetail);

        }

        return resultList;
    }


    public ZlfaOrderModel getZlfaOrderModel(Yizhu yizhu) {
        ZlfaOrderModel zlfaOrderModel = new ZlfaOrderModel();
        if (yizhu == null) {
            return null;
        }
        Optional.ofNullable(yizhu.getOrder_item_name()).ifPresent(s -> zlfaOrderModel.setOrderItemName(s));
        Optional.ofNullable(yizhu.getOrder_item_code()).ifPresent(s -> zlfaOrderModel.setOrderItemCode(s));
        Optional.ofNullable(yizhu.getOrder_class_name()).ifPresent(s -> zlfaOrderModel.setOrderClassName(s));
        Optional.ofNullable(yizhu.getOrder_class_code()).ifPresent(s -> zlfaOrderModel.setOrderClassCode(s));
        Optional.ofNullable(yizhu.getOrder_begin_time()).ifPresent(s -> zlfaOrderModel.setOrderBeginTime(s));
        Optional.ofNullable(yizhu.getOrder_end_time()).ifPresent(s -> zlfaOrderModel.setOrderEndTime(s));
        Optional.ofNullable(yizhu.getOrder_properties_name()).ifPresent(s -> zlfaOrderModel.setOrderPropertiesName(s));
        Optional.ofNullable(yizhu.getOrder_status_name()).ifPresent(s -> zlfaOrderModel.setOrderStatusName(s));
        Optional.ofNullable(yizhu.getFrequency_name()).ifPresent(s -> zlfaOrderModel.setFrequencyName(s));
        Optional.ofNullable(yizhu.getFrequency_code()).ifPresent(s -> zlfaOrderModel.setFrequencyCode(s));
        Optional.ofNullable(yizhu.getDosage_value()).ifPresent(s -> zlfaOrderModel.setDosageValue(s));
        Optional.ofNullable(yizhu.getDosage_value_unit()).ifPresent(s -> zlfaOrderModel.setDosageValueUnit(s));
        Optional.ofNullable(yizhu.getOrder_class_convert_name()).ifPresent(s -> zlfaOrderModel.setOrderClassConvertName(s));
        Optional.ofNullable(yizhu.getChina_approved_drug_name()).ifPresent(s -> zlfaOrderModel.setChinaApprovedDrugName(s));
        Optional.ofNullable(yizhu.getDrug_trade_name()).ifPresent(s -> zlfaOrderModel.setDrugTradeName(s));
        Optional.ofNullable(yizhu.getPrint_name()).ifPresent(s -> zlfaOrderModel.setPrintName(s));
        Optional.ofNullable(yizhu.getParent_order_no()).ifPresent(s -> zlfaOrderModel.setParentOrderNo(s));
        Optional.ofNullable(yizhu.getOrder_no()).ifPresent(s -> zlfaOrderModel.setOrderNo(s));
        Optional.ofNullable(yizhu.getDuration_value()).ifPresent(s -> zlfaOrderModel.setDurationValue(s));
        Optional.ofNullable(yizhu.getDuration_unit()).ifPresent(s -> zlfaOrderModel.setDurationUnit(s));
        Optional.ofNullable(yizhu.getOrder_time()).ifPresent(s -> zlfaOrderModel.setOrderTime(s));
        Optional.ofNullable(yizhu.getStop_order_time()).ifPresent(s -> zlfaOrderModel.setStopOrderTime(s));
        Optional.ofNullable(yizhu.getDosage_form()).ifPresent(s -> zlfaOrderModel.setDosageForm(s));
        Optional.ofNullable(yizhu.getDrug_production_classification()).ifPresent(s -> zlfaOrderModel.setDrugProductionClassification(s));
        Optional.ofNullable(yizhu.getTotal_dosage_value()).ifPresent(s -> zlfaOrderModel.setTotalDosageValue(s));
        Optional.ofNullable(yizhu.getTotal_dosage_unit()).ifPresent(s -> zlfaOrderModel.setTotalDosageUnit(s));
        Optional.ofNullable(yizhu.getSpecification()).ifPresent(s -> zlfaOrderModel.setSpecification(s));
        Optional.ofNullable(yizhu.getDrug_amount_value()).ifPresent(s -> zlfaOrderModel.setDrugAmountValue(s));
        Optional.ofNullable(yizhu.getDrug_amount_value_unit()).ifPresent(s -> zlfaOrderModel.setDrugAmountValueUnit(s));
        Optional.ofNullable(yizhu.getPharmacy_way_name()).ifPresent(s -> zlfaOrderModel.setPharmacyWayName(s));
        Optional.ofNullable(yizhu.getDischarge_medicine_indicator()).ifPresent(s -> zlfaOrderModel.setDischargeMedicineIndicator(s));
        Optional.ofNullable(yizhu.getPresc_time()).ifPresent(s -> zlfaOrderModel.setPrescTime(s));

        return zlfaOrderModel;
    }


    public ZlfaZhubiao analyzeZlfaZhubiao(ZlfaZhubiao zlfaZhubiao) {
        List<ZlfaModel> zlfaModelList = zlfaZhubiao.getZlfaModelList();
        for (ZlfaModel zlfaModel : zlfaModelList) {
            zlfaModel.setZlfaZhubiao(null);
            zlfaModel.getZlfaMianDiagnosisDetailList().forEach(s -> s.setZlfaModel(null));
            zlfaModel.getZlfaSubordinationDiagnosisDetailList().forEach(s -> s.setZlfaModel(null));
            zlfaModel.getDecreaseList().forEach(s -> s.setZlfaModel(null));
            zlfaModel.getIncreaseList().forEach(s -> s.setZlfaModel(null));
            List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaModel.getZlfaMianDiagnosisDetailList();
            for (ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail : zlfaMianDiagnosisDetailList) {
//                zlfaMianDiagnosisDetail.get
            }
        }
        return zlfaZhubiao;
    }
}
