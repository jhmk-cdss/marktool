package com.jhmk.model.bean.rule;

import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/10/8 18:31
 */
//出院记录
public class Chuyuanjilu {
    private String src;
    List<Map<String,String>>medicineList;
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<Map<String, String>> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Map<String, String>> medicineList) {
        this.medicineList = medicineList;
    }
}
