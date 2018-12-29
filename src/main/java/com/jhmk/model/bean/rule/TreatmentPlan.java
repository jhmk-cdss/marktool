package com.jhmk.model.bean.rule;

import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/10/9 9:58
 */

public class TreatmentPlan {
    private String src;
    private List<Drug2Yizhu> medicine;
    private String file_time_value;
    private String order_item_name;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public List<Drug2Yizhu> getMedicine() {
        return medicine;
    }

    public void setMedicine(List<Drug2Yizhu> medicine) {
        this.medicine = medicine;
    }

    public String getFile_time_value() {
        return file_time_value;
    }

    public void setFile_time_value(String file_time_value) {
        this.file_time_value = file_time_value;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }
}
