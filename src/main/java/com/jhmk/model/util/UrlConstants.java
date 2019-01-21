package com.jhmk.model.util;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 10:59
 */

public class UrlConstants {
    //获取疾病子节点
    public static final String getDiseaseChildrenList = "/med/cdss/getDiseaseChildrenList.json";
    //    //获取疾病父节点
    public static final String getParentList = "/med/cdss/getParentList.json";


    //7088 初始工具
    public static final String getDataByPIdAndVId = "/test/rule/getDataByPIdAndVId";
    public static final String getTotalFeeAndHospitalDay = "/test/rule/getTotalFeeAndHospitalDay";




    //知识库接口

    //  获取一个词的同义词列表
    public static final String sameWord = "/med/cdss/sameWord.json";
    //获取一个词的标准名称
    public static final String standardFromAlias = "/med/cdss/standardFromAlias.json";
    public static final String getAllChildDisease = "/med/cdss/getAllChildDisease.json";
    //根据药品层级，返回该层级的所有药品
    public static final String getMedicineFromLevelName = "/med/cdss/getMedicineFromLevelName.json";

}
