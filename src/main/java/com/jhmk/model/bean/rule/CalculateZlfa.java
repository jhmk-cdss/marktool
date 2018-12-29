package com.jhmk.model.bean.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/25 16:57
 * 计算治疗方案计划
 */

public class CalculateZlfa {
    private String orderBeginTime;
    private String orderEndTime;
    //增加长期医嘱
    private List<Yizhu> increaseYizhuList = new ArrayList<>();
    //当天临时医嘱
    private List<Yizhu> tempYizhuList = new ArrayList<>();
    //减少医嘱
    private List<Yizhu> decreaseYizhuList = new ArrayList<>();
    //计划医嘱
    private List<Yizhu> planYizhuList = new ArrayList<>();

    //下一个
    private CalculateZlfa nextCalculateZlfa;
    //上一个
    private CalculateZlfa lastCalculateZlfa;

    public CalculateZlfa getNextCalculateZlfa() {
        return nextCalculateZlfa;
    }

    public void setNextCalculateZlfa(CalculateZlfa nextCalculateZlfa) {
        this.nextCalculateZlfa = nextCalculateZlfa;
    }

    public String getOrderBeginTime() {
        return orderBeginTime;
    }

    public void setOrderBeginTime(String orderBeginTime) {
        this.orderBeginTime = orderBeginTime;
    }

    public String getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public List<Yizhu> getIncreaseYizhuList() {
        return increaseYizhuList;
    }

    public void setIncreaseYizhuList(List<Yizhu> increaseYizhuList) {
        this.increaseYizhuList = increaseYizhuList;
    }

    public List<Yizhu> getDecreaseYizhuList() {
        return decreaseYizhuList;
    }

    public void setDecreaseYizhuList(List<Yizhu> decreaseYizhuList) {
        this.decreaseYizhuList = decreaseYizhuList;
    }

    public List<Yizhu> getPlanYizhuList() {
        return planYizhuList;
    }

    public void setPlanYizhuList(List<Yizhu> planYizhuList) {
        this.planYizhuList = planYizhuList;
    }

    public List<Yizhu> getTempYizhuList() {
        return tempYizhuList;
    }

    public void setTempYizhuList(List<Yizhu> tempYizhuList) {
        this.tempYizhuList = tempYizhuList;
    }
}
