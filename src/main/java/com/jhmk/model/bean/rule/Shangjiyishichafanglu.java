package com.jhmk.model.bean.rule;

/**
 * @author ziyu.zhou
 * @date 2018/9/11 16:39
 */

public class Shangjiyishichafanglu {
    private String clear_diagnose_name;//确诊名
    private String clear_diagnose;//是否确诊
    private String last_modify_date_time;//修改时间
    private String jbmc;//疾病名称
    private String zjsrc;//张杰src

    public String getClear_diagnose_name() {
        return clear_diagnose_name;
    }

    public void setClear_diagnose_name(String clear_diagnose_name) {
        this.clear_diagnose_name = clear_diagnose_name;
    }

    public String getClear_diagnose() {
        return clear_diagnose;
    }

    public void setClear_diagnose(String clear_diagnose) {
        this.clear_diagnose = clear_diagnose;
    }

    public String getLast_modify_date_time() {
        return last_modify_date_time;
    }

    public void setLast_modify_date_time(String last_modify_date_time) {
        this.last_modify_date_time = last_modify_date_time;
    }

    public String getJbmc() {
        return jbmc;
    }

    public void setJbmc(String jbmc) {
        this.jbmc = jbmc;
    }

    public String getZjsrc() {
        return zjsrc;
    }

    public void setZjsrc(String zjsrc) {
        this.zjsrc = zjsrc;
    }
}
