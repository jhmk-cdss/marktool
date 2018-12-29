package com.jhmk.model.bean.rule;

/**
 * @author ziyu.zhou
 * @date 2018/9/25 17:27
 */

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 病历信息
 */
public class CaseBean implements Serializable{
    private String id;
    private String patient_id;
    private String visit_id;
    private Binganshouye binganshouye;
    private List<Binglizhenduan> binglizhenduan;
    private List<Shouyezhenduan> shouyezhenduan;
    private Ruyuanjilu ruyuanjilu;
    private List<Yizhu> yizhu;
    private List<Shangjiyishichafanglu>shangjiyishichafanglu;
    private List<Map<String, String>> jianyanbaogao;
    private List<Jianchabaogao>jianchabaogao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Binganshouye getBinganshouye() {
        return binganshouye;
    }

    public void setBinganshouye(Binganshouye binganshouye) {
        this.binganshouye = binganshouye;
    }

    public List<Binglizhenduan> getBinglizhenduan() {
        return binglizhenduan;
    }

    public void setBinglizhenduan(List<Binglizhenduan> binglizhenduan) {
        this.binglizhenduan = binglizhenduan;
    }

    public List<Shouyezhenduan> getShouyezhenduan() {
        return shouyezhenduan;
    }

    public void setShouyezhenduan(List<Shouyezhenduan> shouyezhenduan) {
        this.shouyezhenduan = shouyezhenduan;
    }

    public List<Yizhu> getYizhu() {
        return yizhu;
    }

    public void setYizhu(List<Yizhu> yizhu) {
        this.yizhu = yizhu;
    }

    public List<Shangjiyishichafanglu> getShangjiyishichafanglu() {
        return shangjiyishichafanglu;
    }

    public void setShangjiyishichafanglu(List<Shangjiyishichafanglu> shangjiyishichafanglu) {
        this.shangjiyishichafanglu = shangjiyishichafanglu;
    }

    public List<Map<String, String>> getJianyanbaogao() {
        return jianyanbaogao;
    }

    public void setJianyanbaogao(List<Map<String, String>> jianyanbaogao) {
        this.jianyanbaogao = jianyanbaogao;
    }

    public List<Jianchabaogao> getJianchabaogao() {
        return jianchabaogao;
    }

    public void setJianchabaogao(List<Jianchabaogao> jianchabaogao) {
        this.jianchabaogao = jianchabaogao;
    }

    public Ruyuanjilu getRuyuanjilu() {
        return ruyuanjilu;
    }

    public void setRuyuanjilu(Ruyuanjilu ruyuanjilu) {
        this.ruyuanjilu = ruyuanjilu;
    }
}
