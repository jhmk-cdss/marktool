package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.base.BaseController;
import com.jhmk.model.base.BaseEntityController;
import com.jhmk.model.bean.rule.Rule;
import com.jhmk.model.bean.sqlbean.*;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaZhubiaoRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaUpdateAddModelDetailRepService;
import com.jhmk.model.bean.tempbean.CollectionCompareBean;
import com.jhmk.model.bean.tempbean.ZlfaCompareBean;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.ZlfaMianDiagnosisDetailService;
import com.jhmk.model.service.ZlfaZhubiaoService;
import com.jhmk.model.util.UrlConstants;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    ZlfaZhubiaoRepService zlfaZhubiaoRepService;
    @Autowired
    ZlfaUpdateAddModelDetailRepService zlfaUpdateAddModelDetailRepService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;
    @Autowired
    ZlfaMianDiagnosisDetailService zlfaMianDiagnosisDetailService;


    @PostMapping("/list")
    public void list(HttpServletResponse response, @RequestBody String map) {
        Map params = (Map) JSONObject.parse(map);
        AtResponse resp = super.listDataByMap(params, zlfaZhubiaoRepService, "createTime");
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
        Object parse = JSONObject.parse(map);
        String s = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getDataByPIdAndVId, parse, String.class);
        Rule rule = JSONObject.parseObject(s, Rule.class);
        ZlfaZhubiao zhubiao = zlfaZhubiaoService.ruleToZlfaZhubiao(rule);
        wirte(response, zhubiao);
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
        List<Integer> idList = new ArrayList<>(allByDischargeMainDiagnosis.size());
        allByDischargeMainDiagnosis.forEach(s -> idList.add(s.getId()));
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
        JSONObject object = JSONObject.parseObject(map);
        String dischargeMainDiagnosis = object.getString("dischargeMainDiagnosis");
        List<ZlfaZhubiao> allByDischargeMainDiagnosis = zlfaZhubiaoRepService.findAllByDischargeMainDiagnosis(dischargeMainDiagnosis);
        List<CollectionCompareBean> list = new ArrayList<>();
        lable:
        for (ZlfaZhubiao zhubiao : allByDischargeMainDiagnosis) {
            //治疗方案
            List<ZlfaCompareBean> zlfaCompareBeanList = new ArrayList<>();
            List<ZlfaModel> zlfaModelList = zhubiao.getZlfaModelList();
            if (zlfaModelList != null && zlfaModelList.size() > 0) {
                for (ZlfaModel zlfaModel : zlfaModelList) {
                    if ("1".equals(zlfaModel.getTreatmentPlanNum())) {
                        List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList = zlfaModel.getZlfaMianDiagnosisDetailList();
                        for (ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail : zlfaMianDiagnosisDetailList) {
                            ZlfaCompareBean zlfaCompareBean = new ZlfaCompareBean();
                            zlfaCompareBean.setMedicineTreatment(zlfaMianDiagnosisDetail.getMedicineTreatment());
                            zlfaCompareBean.setTreatmentGoals(zlfaMianDiagnosisDetail.getTreatmentGoals());
                            ZlfaOrderModel zlfaOrderModel = zlfaMianDiagnosisDetail.getZlfaOrderModel();
                            if (zlfaOrderModel != null) {
                                zlfaCompareBean.setOrderItemName(zlfaOrderModel.getOrderItemName());
                            }
                            zlfaCompareBeanList.add(zlfaCompareBean);
                        }
                        CollectionCompareBean collectionCompareBean = new CollectionCompareBean();
                        collectionCompareBean.setColumnMetaData(zlfaCompareBeanList);
                        list.add(collectionCompareBean);
                        continue lable;
                    }
                }
            }
        }
        wirte(response, list);
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
        ZlfaZhubiao zhubiao = zlfaZhubiaoService.rule2ZlfaZhubiao(rule);
        wirte(response, zhubiao);
    }


}
