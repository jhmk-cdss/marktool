package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.base.BaseEntityController;
import com.jhmk.model.bean.rule.Rule;
import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaMianDiagnosisDetailRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaOrderModelRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaUpdateAddModelDetailRepService;
import com.jhmk.model.bean.sqlbean.repository.service.ZlfaZhubiaoRepService;
import com.jhmk.model.bean.tempbean.CollectionCompareBean;
import com.jhmk.model.bean.tempbean.ZlfaCompareBean;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.ZlfaMianDiagnosisDetailService;
import com.jhmk.model.service.ZlfaZhubiaoService;
import com.jhmk.model.util.CompareUtil;
import com.jhmk.model.util.DocumentUtil;
import com.jhmk.model.util.ThreadUtil;
import com.jhmk.model.util.UrlConstants;
import io.swagger.annotations.*;
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
@RequestMapping("zlfaOrderModel")
@Api(value = "治疗方案医嘱模型相关功能", description = "治疗方案医嘱模型相关功能")
public class ZlfaOrderModelController extends BaseEntityController<ZlfaZhubiao> {
    private static final Logger logger = LoggerFactory.getLogger(ZlfaOrderModelController.class);
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
    DocumentUtil documentUtil;
    @Autowired
    ZlfaMianDiagnosisDetailService zlfaMianDiagnosisDetailService;


    @GetMapping("/addStandardName")
    @ApiOperation(value = "添加医嘱标准名", notes = "无参数",
            httpMethod = "GET", responseContainer = "Map")
    @ApiResponses({@ApiResponse(code = 200, message = "成功")})
    public void addStandardName(HttpServletResponse response) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        List<String> distinctByOrderItemName = zlfaOrderModelRepService.findDistinctByOrderItemName();
        for (String name : distinctByOrderItemName) {
            String standardFromAlias = documentUtil.getStandardFromAlias(name);
            zlfaOrderModelRepService.updateStandardName(standardFromAlias, name);
            logger.info(standardFromAlias.equals(name)+"====医嘱项名为：{}==更新为：{}", name, standardFromAlias);
        }
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);

    }


}
