package com.jhmk.model.bean.tempbean;

import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/28 19:13
 */

public class ZlfaCompareBean {
    //治疗目的
    private String treatmentGoals;
    //用药&治疗项目
    private String medicineTreatment;
    //医嘱
    private String orderItemName;


    public String getTreatmentGoals() {
        return treatmentGoals;
    }

    public void setTreatmentGoals(String treatmentGoals) {
        this.treatmentGoals = treatmentGoals;
    }

    public String getMedicineTreatment() {
        return medicineTreatment;
    }

    public void setMedicineTreatment(String medicineTreatment) {
        this.medicineTreatment = medicineTreatment;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZlfaCompareBean that = (ZlfaCompareBean) o;
        return Objects.equals(treatmentGoals, that.treatmentGoals) &&
                Objects.equals(medicineTreatment, that.medicineTreatment) &&
                Objects.equals(orderItemName, that.orderItemName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(treatmentGoals, medicineTreatment, orderItemName);
    }
}
