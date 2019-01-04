package com.jhmk.model.bean.rule;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.util.MapUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/7/24 13:55
 */

public class Rule implements Serializable {

    private String id;
    private String doctor_id;
    private String doctor_name;
    private String dept_code;
    private String warnSource;
    private String patient_id;
    private String visit_id;
    private String pageSource;
    //入院时间
    private String admission_time;
    //出院时间
    private String discharge_time;
    private String rycz;
    //入院等于出院
    private String cyzd;
    //入院主诊断与出院主诊断是否相同，相同为1，不相同为0
    private int reqc;
    //    确诊项目与出院诊断是否一致
    private int qzeqc;
    //    模型的推荐结果，按推荐次序排列
    private String modelList;
    //模型命中出院诊断的序号
    private int numRate;
    private int hospitalDay;//住院时长天
    private int qzDay;//确诊时长
    private Binganshouye binganshouye;
    private Ruyuanjilu ruyuanjilu;
    private List<Jianyanbaogao> jianyanbaogao;
    private List<Jianchabaogao> jianchabaogao;
    private List<Binglizhenduan> binglizhenduan;
    private List<Shouyezhenduan> shouyezhenduan;
    private List<Yizhu> yizhu;
    private List<Shangjiyishichafanglu> shangjiyishichafangluList;
    private List<Shouyeshoushu> shouyeshoushu;
    private Shoucibingchengjilu shoucibingchengjilu;

    public int getQzDay() {
        return qzDay;
    }

    public void setQzDay(int qzDay) {
        this.qzDay = qzDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getWarnSource() {
        return warnSource;
    }

    public void setWarnSource(String warnSource) {
        this.warnSource = warnSource;
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

    public String getPageSource() {
        return pageSource;
    }

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    public String getAdmission_time() {
        return admission_time;
    }

    public void setAdmission_time(String admission_time) {
        this.admission_time = admission_time;
    }

    public String getDischarge_time() {
        return discharge_time;
    }

    public void setDischarge_time(String discharge_time) {
        this.discharge_time = discharge_time;
    }


    public Binganshouye getBinganshouye() {
        return binganshouye;
    }

    public void setBinganshouye(Binganshouye binganshouye) {
        this.binganshouye = binganshouye;
    }

    public Ruyuanjilu getRuyuanjilu() {
        return ruyuanjilu;
    }

    public void setRuyuanjilu(Ruyuanjilu ruyuanjilu) {
        this.ruyuanjilu = ruyuanjilu;
    }

    public List<Jianyanbaogao> getJianyanbaogao() {
        return jianyanbaogao;
    }

    public void setJianyanbaogao(List<Jianyanbaogao> jianyanbaogao) {
        this.jianyanbaogao = jianyanbaogao;
    }

    public List<Jianchabaogao> getJianchabaogao() {
        return jianchabaogao;
    }

    public void setJianchabaogao(List<Jianchabaogao> jianchabaogao) {
        this.jianchabaogao = jianchabaogao;
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

    public List<Shangjiyishichafanglu> getShangjiyishichafangluList() {
        return shangjiyishichafangluList;
    }

    public void setShangjiyishichafangluList(List<Shangjiyishichafanglu> shangjiyishichafangluList) {
        this.shangjiyishichafangluList = shangjiyishichafangluList;
    }

    public Shoucibingchengjilu getShoucibingchengjilu() {
        return shoucibingchengjilu;
    }

    public void setShoucibingchengjilu(Shoucibingchengjilu shoucibingchengjilu) {
        this.shoucibingchengjilu = shoucibingchengjilu;
    }

    public int getReqc() {
        return reqc;
    }

    public void setReqc(int reqc) {
        this.reqc = reqc;
    }

    public int getQzeqc() {
        return qzeqc;
    }

    public void setQzeqc(int qzeqc) {
        this.qzeqc = qzeqc;
    }

    public String getModelList() {
        return modelList;
    }

    public void setModelList(String modelList) {
        this.modelList = modelList;
    }

    public int getNumRate() {
        return numRate;
    }

    public void setNumRate(int numRate) {
        this.numRate = numRate;
    }

    public int getHospitalDay() {
        return hospitalDay;
    }

    public void setHospitalDay(int hospitalDay) {
        this.hospitalDay = hospitalDay;
    }

    public String getRycz() {
        return rycz;
    }

    public void setRycz(String rycz) {
        this.rycz = rycz;
    }

    public String getCyzd() {
        return cyzd;
    }

    public void setCyzd(String cyzd) {
        this.cyzd = cyzd;
    }

    public void setShouyeshoushu(List<Shouyeshoushu> shouyeshoushu) {
        this.shouyeshoushu = shouyeshoushu;
    }

    public List<Shouyeshoushu> getShouyeshoushu() {
        return shouyeshoushu;
    }

    public static Rule fill(JSONObject jo) {
        Rule o = new Rule();

        if (jo.containsKey("doctor_id")) {
            o.setDoctor_id(jo.getString("doctor_id"));
        }
        if (jo.containsKey("doctor_name")) {
            o.setDoctor_name(jo.getString("doctor_name"));
        }
        if (jo.containsKey("patient_id")) {
            o.setPatient_id(jo.getString("patient_id"));
        }
        if (jo.containsKey("visit_id")) {
            o.setVisit_id(jo.getString("visit_id"));
        }

        if (jo.containsKey("discharge_time")) {
            o.setDischarge_time(jo.getString("discharge_time"));
        }
        if (jo.containsKey("admission_time")) {
            o.setAdmission_time(jo.getString("admission_time"));
        }

        if (jo.containsKey("dept_code")) {
            o.setDept_code(jo.getString("dept_code"));
        }

        if (jo.containsKey("warnSource")) {
            o.setWarnSource(jo.getString("warnSource"));
        }
        if (jo.containsKey("pageSource")) {
            o.setPageSource(jo.getString("pageSource"));
        }
        if (jo.containsKey("binganshouye")) {
            Map<String, String> map = (Map<String, String>) jo.get("binganshouye");
            map.put("patient_id", jo.getString("patient_id"));
            map.put("visit_id", jo.getString("visit_id"));
            Binganshouye binganshouye = MapUtil.map2Bean(map, Binganshouye.class);
            o.setBinganshouye(binganshouye);
        }


        if (jo.containsKey("ruyuanjilu")) {
            try {
                Map<String, String> map = (Map<String, String>) jo.get("ruyuanjilu");
                map.put("patient_id", jo.getString("patient_id"));
                map.put("visit_id", jo.getString("visit_id"));
                Ruyuanjilu ruyuanjilu = MapUtil.map2Bean(map, Ruyuanjilu.class);
                o.setRuyuanjilu(ruyuanjilu);
            } catch (Exception e) {
                o.setRuyuanjilu(null);

            }

        }
        if (jo.containsKey("binglizhenduan")) {
            List<Binglizhenduan> beanList = new ArrayList<>();
            List<Map<String, String>> binglizhenduans = (List<Map<String, String>>) jo.get("binglizhenduan");
            for (Map<String, String> m : binglizhenduans) {
                m.put("patient_id", jo.getString("patient_id"));
                m.put("visit_id", jo.getString("visit_id"));
                Binglizhenduan bean = MapUtil.map2Bean(m, Binglizhenduan.class);
                beanList.add(bean);
            }
            o.setBinglizhenduan(beanList);
        }
        if (jo.containsKey("shouyezhenduan")) {
            List<Shouyezhenduan> beanList = new ArrayList<>();
            List<Map<String, String>> shouyezhenduans = (List<Map<String, String>>) jo.get("shouyezhenduan");
            for (Map<String, String> m : shouyezhenduans) {
                m.put("patient_id", jo.getString("patient_id"));
                m.put("visit_id", jo.getString("visit_id"));
                Shouyezhenduan bean = MapUtil.map2Bean(m, Shouyezhenduan.class);
                beanList.add(bean);
            }
            o.setShouyezhenduan(beanList);
        }
        if (jo.containsKey("yizhu")) {
            List<Yizhu> beanList = new ArrayList<>();
            List<Map<String, String>> yizhus = (List<Map<String, String>>) jo.get("yizhu");
            for (Map<String, String> m : yizhus) {
                m.put("patient_id", jo.getString("patient_id"));
                m.put("visit_id", jo.getString("visit_id"));
                Yizhu bean = MapUtil.map2Bean(m, Yizhu.class);
                beanList.add(bean);
            }
            o.setYizhu(beanList);
        }

        if (jo.containsKey("jianyanbaogao")) {
            List<Map<String, String>> jianyanbaogao = (List<Map<String, String>>) jo.get("jianyanbaogao");
            List<Jianyanbaogao> beanList = new LinkedList<>();
            for (Map<String, String> m : jianyanbaogao) {
                Jianyanbaogao bean = MapUtil.map2Bean(m, Jianyanbaogao.class);
                beanList.add(bean);
            }
            o.setJianyanbaogao(beanList);
        }
        if (jo.containsKey("jianchabaogao")) {
            List<Map<String, String>> jianchabaogao = (List<Map<String, String>>) jo.get("jianchabaogao");
            List<Jianchabaogao> beanList = new LinkedList<>();
            for (Map<String, String> m : jianchabaogao) {
                Jianchabaogao bean = MapUtil.map2Bean(m, Jianchabaogao.class);
                beanList.add(bean);
            }
            o.setJianchabaogao(beanList);
        }

        return o;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id='" + id + '\'' +
                ", doctor_id='" + doctor_id + '\'' +
                ", dept_code='" + dept_code + '\'' +
                ", patient_id='" + patient_id + '\'' +
                ", visit_id='" + visit_id + '\'' +
                ", rycz='" + rycz + '\'' +
                ", cyzd='" + cyzd + '\'' +
                ", getAdmission_time=" + binganshouye.getAdmission_time() +
                ", getDischarge_time=" + binganshouye.getDischarge_time() +
                ", doctor_name=" + binganshouye.getPat_visit_dept_request_doctor_name() +
                ", dept_admission_to_name=" + binganshouye.getPat_visit_dept_admission_to_name() +
                ", dept_admission_to_code=" + binganshouye.getPat_visit_dept_admission_to_code() +
                ", shangjiyishichafangluList=" + JSONObject.toJSONString(shangjiyishichafangluList) +
                '}';
    }
}

