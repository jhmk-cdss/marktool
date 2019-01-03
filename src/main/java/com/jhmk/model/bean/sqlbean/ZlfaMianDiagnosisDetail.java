package com.jhmk.model.bean.sqlbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:20
 */

@Entity
@JsonIgnoreProperties(value = {"zlfaModel"})
@Table(name = "zlfn_mian_diagnosis_detail")
public class ZlfaMianDiagnosisDetail implements Serializable {
    private int id;
    private String treatmentGoals;
    private String medicineTreatment;
    private int notIncludedOrderIndicator;
    @JSONField(serialize=false)
    private  ZlfaModel zlfaModel;
    //    private List<ZlfaOrderModel>zlfaOrderModelList;//医嘱模型
    private ZlfaOrderModel zlfaOrderModel;//医嘱模型

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "treatment_goals", nullable = true, length = 255)
    public String getTreatmentGoals() {
        return treatmentGoals;
    }

    public void setTreatmentGoals(String treatmentGoals) {
        this.treatmentGoals = treatmentGoals;
    }

    @Basic
    @Column(name = "medicine_treatment", nullable = true, length = 255)
    public String getMedicineTreatment() {
        return medicineTreatment;
    }

    public void setMedicineTreatment(String medicineTreatment) {
        this.medicineTreatment = medicineTreatment;
    }


    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn(name = "zlfn_model_id")
    public ZlfaModel getZlfaModel() {
        return zlfaModel;
    }

    public void setZlfaModel(ZlfaModel zlfaModel) {
        this.zlfaModel = zlfaModel;
    }

    @Basic
    @Column(name = "not_included_order_indicator")
    public int getNotIncludedOrderIndicator() {
        return notIncludedOrderIndicator;
    }

    public void setNotIncludedOrderIndicator(int notIncludedOrderIndicator) {
        this.notIncludedOrderIndicator = notIncludedOrderIndicator;
    }

    //    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "zlfaMianDiagnosisDetail")
//    public List<ZlfaOrderModel> getZlfaOrderModelList() {
//        return zlfaOrderModelList;
//    }
//
//    public void setZlfaOrderModelList(List<ZlfaOrderModel> zlfaOrderModelList) {
//        this.zlfaOrderModelList = zlfaOrderModelList;
//    }

//    @OneToOne(mappedBy = "zlfaUpdateDeleteModel")
    @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "order_model_id", referencedColumnName = "id")//people中的address_id字段参考address表中的id字段
    public ZlfaOrderModel getZlfaOrderModel() {
        return zlfaOrderModel;
    }

    public void setZlfaOrderModel(ZlfaOrderModel zlfaOrderModel) {
        this.zlfaOrderModel = zlfaOrderModel;
    }

    @Override
    public String toString() {
        return "ZlfaMianDiagnosisDetail{" +
                "id=" + id +
                ", treatmentGoals='" + treatmentGoals + '\'' +
                ", medicineTreatment='" + medicineTreatment + '\'' +
                ", zlfaOrderModel=" + zlfaOrderModel +
                '}';
    }
}
