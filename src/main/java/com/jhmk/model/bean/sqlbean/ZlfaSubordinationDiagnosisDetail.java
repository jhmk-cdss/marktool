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
@Table(name = "zlfn_subordination_diagnosis_detail")
public class ZlfaSubordinationDiagnosisDetail implements Serializable {
    private int id;
    @JSONField(serialize=false)
    private ZlfaModel zlfaModel;
    private String treatmentGoals;
    private String medicineTreatment;
    private String associateDiseaseName;
    //    private List<ZlfaOrderModel> zlfaOrderModelList;//医嘱模型
    private  ZlfaOrderModel zlfaOrderModel;//医嘱模型

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
    @Column(name = "treatment_goals", nullable = true, length = 50)
    public String getTreatmentGoals() {
        return treatmentGoals;
    }

    public void setTreatmentGoals(String treatmentGoals) {
        this.treatmentGoals = treatmentGoals;
    }

    @Basic
    @Column(name = "medicine_treatment", nullable = true, length = 50)
    public String getMedicineTreatment() {
        return medicineTreatment;
    }

    public void setMedicineTreatment(String medicineTreatment) {
        this.medicineTreatment = medicineTreatment;
    }

    @Basic
    @Column(name = "associate_disease_name", nullable = true, length = 50)
    public String getAssociateDiseaseName() {
        return associateDiseaseName;
    }

    public void setAssociateDiseaseName(String associateDiseaseName) {
        this.associateDiseaseName = associateDiseaseName;
    }



    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfn_model_id")//设置在article表中的关联字段(外键)
    public ZlfaModel getZlfaModel() {
        return zlfaModel;
    }

    public void setZlfaModel(ZlfaModel zlfaModel) {
        this.zlfaModel = zlfaModel;
    }

    //    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "zlfaSubordinationDiagnosisDetail")
//    public List<ZlfaOrderModel> getZlfaOrderModelList() {
//        return zlfaOrderModelList;
//    }
//
//    public void setZlfaOrderModelList(List<ZlfaOrderModel> zlfaOrderModelList) {
//        this.zlfaOrderModelList = zlfaOrderModelList;
//    }

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
        return "ZlfaSubordinationDiagnosisDetail{" +
                "id=" + id +
                ", treatmentGoals='" + treatmentGoals + '\'' +
                ", medicineTreatment='" + medicineTreatment + '\'' +
                ", associateDiseaseName='" + associateDiseaseName + '\'' +
                ", zlfaOrderModel=" + zlfaOrderModel +
                '}';
    }
}
