package com.jhmk.model.bean.rule;

/**
 * @author ziyu.zhou
 * @date 2019/1/3 10:43
 * 鉴别依据-患者特点和 鉴别依据-疾病特点 共用一个实体类
 */

public class Characteristics {
    private String history;//病史特点

    private String sign;  //  体征特点

    private String symptom;        //    症状特点

    private String lab;//    检验结果

    private String exam;//            检查结果

    private String antidiastole_lab;//    鉴别所需检验项目

    private String antidiastole_exam;//            鉴别所需检查项目

    private String total_describe;//    总体描述

    private String differential_diagnostic_no;//            鉴别诊断序号

    public String getHistory() {
        return history;
    }

    public void setHistory(final String history) {
        this.history = history;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(final String sign) {
        this.sign = sign;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(final String symptom) {
        this.symptom = symptom;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(final String lab) {
        this.lab = lab;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(final String exam) {
        this.exam = exam;
    }

    public String getAntidiastole_lab() {
        return antidiastole_lab;
    }

    public void setAntidiastole_lab(final String antidiastole_lab) {
        this.antidiastole_lab = antidiastole_lab;
    }

    public String getAntidiastole_exam() {
        return antidiastole_exam;
    }

    public void setAntidiastole_exam(final String antidiastole_exam) {
        this.antidiastole_exam = antidiastole_exam;
    }

    public String getTotal_describe() {
        return total_describe;
    }

    public void setTotal_describe(final String total_describe) {
        this.total_describe = total_describe;
    }

    public String getDifferential_diagnostic_no() {
        return differential_diagnostic_no;
    }

    public void setDifferential_diagnostic_no(final String differential_diagnostic_no) {
        this.differential_diagnostic_no = differential_diagnostic_no;
    }
}
