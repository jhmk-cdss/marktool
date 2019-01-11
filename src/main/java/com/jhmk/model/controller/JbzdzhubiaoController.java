package com.jhmk.model.controller;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.base.BaseEntityController;
import com.jhmk.model.bean.rule.Rule;
import com.jhmk.model.bean.sqlbean.BiaozhuZhubiao;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.bean.sqlbean.repository.service.BiaozhuZhubiaoRepService;
import com.jhmk.model.config.UrlPropertiesConfig;
import com.jhmk.model.model.AtResponse;
import com.jhmk.model.model.ResponseCode;
import com.jhmk.model.service.JbzdZhubiaoService;
import com.jhmk.model.util.UrlConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:47
 * 鉴别诊断主表
 */
@Controller
@RequestMapping("jbzdZhubiao")
@Api("JbzdzhubiaoController相关API")
public class JbzdzhubiaoController extends BaseEntityController<BiaozhuZhubiao> {
    private static final Logger logger = LoggerFactory.getLogger(BaseEntityController.class);

    @Autowired
    JbzdZhubiaoService jbzdZhubiaoService;
    @Autowired
    BiaozhuZhubiaoRepService biaozhuZhubiaoRepService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UrlPropertiesConfig urlPropertiesConfig;

    /**
     * 条件查询
     * @param response
     * @param map
     */
    @PostMapping("/list")
    public void list(HttpServletResponse response, @RequestBody String map) {
        Map params = (Map) JSONObject.parse(map);
        AtResponse resp = super.listData(params, biaozhuZhubiaoRepService, "createTime");
        wirte(response, resp);
    }

    /**
     * 主键查询
     * @param response
     * @param map
     */
    @PostMapping("/findOne")
    @ApiOperation(value = "主键查询", notes = "主键查询")
    public void findOne(HttpServletResponse response, @RequestBody String map) {
        JSONObject object = JSONObject.parseObject(map);
        Integer id = object.getInteger("id");
        BiaozhuZhubiao one = biaozhuZhubiaoRepService.findOne(id);
        wirte(response, one);
    }

    @PostMapping("/test")
    public void test(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        Iterable<BiaozhuZhubiao> all = biaozhuZhubiaoRepService.findAll();
//        String string = JSONObject.toJSONString(all);
        resp.setData(all);
        wirte(response, resp);
    }

    //    @PostMapping("/save")
//    public void save(HttpServletResponse response, @RequestBody String map) {
//        BiaozhuZhubiao biaozhuZhubiao = JSONObject.parseObject(map, BiaozhuZhubiao.class);
//        BiaozhuZhubiao save = biaozhuZhubiaoRepService.save(biaozhuZhubiao);
//        biaozhuZhubiaoRepService.save(save);
//
//        wirte(response, save);
//    }

    @PostMapping("/returnMainInitData")
    @ApiOperation(value = "根据ID查询鉴别诊断数据", notes = "根据ID查询鉴别诊断数据")
    public void returnFirstInitData(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse(System.currentTimeMillis());
        Object parse = JSONObject.parse(map);
        logger.info("接受到的数据为：{}", map);

        //先从msyql查询，有值直接返回，没值从mongo查询
        JSONObject jsonObject = JSONObject.parseObject(map);
        String pid = jsonObject.getString("pid");
        String vid = jsonObject.getString("vid");
        String id = jsonObject.getString("id");
        String[] ids = null;
        if(id!=null && id.length()>0){
            ids=id.split("#");
        }
        if(ids.length==3){
            pid = ids[1];
            vid = ids[2];
        }else{
            resp.setData("参数有误");
            resp.setResponseCode(ResponseCode.COMERROR);
            wirte(response, resp);
        }
        if(pid ==null || pid=="" || vid==null || vid==""){
            resp.setData("参数有误");
            resp.setResponseCode(ResponseCode.COMERROR);
            wirte(response, resp);
        }
        Map maps = new HashMap();
        maps.put("patientId",pid);
        maps.put("visitId",vid);

        AtResponse atResponse = super.listDataByMap(maps, biaozhuZhubiaoRepService, "id");
        //解析mysql查询到的数据结果
        Map<String,Object> data = (HashMap) atResponse.getData();
        List listData = null;
        for (Map.Entry<String,Object> entry : data.entrySet()){
            if(entry.getKey().equals("listData")){
                 listData = (List)entry.getValue();
            }
        }
        int num = listData.size();
        BiaozhuZhubiao biaozhuZhubiao;
        //mysql查询不到数据，查询mongodb
        if(num<1){
            String s = restTemplate.postForObject(urlPropertiesConfig.getTestToolUrl() + UrlConstants.getDataByPIdAndVId, parse, String.class);
            Rule rule = JSONObject.parseObject(s, Rule.class);
            biaozhuZhubiao = jbzdZhubiaoService.rule2JbzdZhubiao(rule);
        }else{
            biaozhuZhubiao = (BiaozhuZhubiao)listData.get(0);
        }
        resp.setData(biaozhuZhubiao);
        resp.setResponseCode(ResponseCode.OK);
        wirte(response, resp);
    }


    @PostMapping("/save")
    public void saveAll(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse();
        BiaozhuZhubiao biaozhuZhubiaoResult = jbzdZhubiaoService.getBiaozhuZhubiaoResult(map);
        biaozhuZhubiaoResult.setCreateTime(new Date());
        try {
            biaozhuZhubiaoRepService.save(biaozhuZhubiaoResult);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResponseCode(ResponseCode.INERERROR);

        }
        wirte(response, resp);
    }

    @PostMapping("/delete")
    public void delete(HttpServletResponse response, @RequestBody String map) {
        AtResponse resp = new AtResponse();
        JSONObject parse = JSONObject.parseObject(map);
        Integer id = parse.getInteger("id");

        try {
            biaozhuZhubiaoRepService.delete(id);
            resp.setResponseCode(ResponseCode.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResponseCode(ResponseCode.INERERROR);

        }
        wirte(response, resp);
    }
}
