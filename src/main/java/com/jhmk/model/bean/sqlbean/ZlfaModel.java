package com.jhmk.model.bean.sqlbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:20
 */

@Entity
@JsonIgnoreProperties(value = {"zlfaZhubiao"})
@Table(name = "zlfn_model")
public class ZlfaModel implements Serializable {
    private int id;
    private String treatmentPlanNum;
    private List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList;//z主疾病治疗方案明细
    private List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList;//伴随疾病治疗方案明细
    private List<ZlfaUpdateAddModel> increaseList;//治疗方案更改模型 加
    private List<ZlfaUpdateDeleteModel> decreaseList;//治疗方案更改模型 减
    @JSONField(serialize=false)
    private  ZlfaZhubiao zlfaZhubiao;

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
    @Column(name = "treatment_plan_num", nullable = true, length = 50)
    public String getTreatmentPlanNum() {
        return treatmentPlanNum;
    }

    public void setTreatmentPlanNum(String treatmentPlanNum) {
        this.treatmentPlanNum = treatmentPlanNum;
    }

    @OneToMany(mappedBy = "zlfaModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ZlfaMianDiagnosisDetail> getZlfaMianDiagnosisDetailList() {
        return zlfaMianDiagnosisDetailList;
    }

    public void setZlfaMianDiagnosisDetailList(List<ZlfaMianDiagnosisDetail> zlfaMianDiagnosisDetailList) {
        this.zlfaMianDiagnosisDetailList = zlfaMianDiagnosisDetailList;
    }

    @OneToMany(mappedBy = "zlfaModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ZlfaSubordinationDiagnosisDetail> getZlfaSubordinationDiagnosisDetailList() {
        return zlfaSubordinationDiagnosisDetailList;
    }

    public void setZlfaSubordinationDiagnosisDetailList(List<ZlfaSubordinationDiagnosisDetail> zlfaSubordinationDiagnosisDetailList) {
        this.zlfaSubordinationDiagnosisDetailList = zlfaSubordinationDiagnosisDetailList;
    }


    @OneToMany(mappedBy = "zlfaModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ZlfaUpdateAddModel> getIncreaseList() {
        return increaseList;
    }

    public void setIncreaseList(List<ZlfaUpdateAddModel> increaseList) {
        this.increaseList = increaseList;
    }

    @OneToMany(mappedBy = "zlfaModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ZlfaUpdateDeleteModel> getDecreaseList() {
        return decreaseList;
    }

    public void setDecreaseList(List<ZlfaUpdateDeleteModel> decreaseList) {
        this.decreaseList = decreaseList;
    }

    //关系维护端  设置外键
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
//    @ManyToOne(fetch = FetchType.EAGER)


    @ManyToOne(fetch = FetchType.LAZY)
//    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "zhubiao_id")
    public ZlfaZhubiao getZlfaZhubiao() {
        return zlfaZhubiao;
    }

    public void setZlfaZhubiao(ZlfaZhubiao zlfaZhubiao) {
        this.zlfaZhubiao = zlfaZhubiao;
    }

    @Override
    public String toString() {
        return "ZlfaModel{" +
                "id=" + id +
                ", treatmentPlanNum='" + treatmentPlanNum + '\'' +
                ", zlfaMianDiagnosisDetailList=" + zlfaMianDiagnosisDetailList +
                ", zlfaSubordinationDiagnosisDetailList=" + zlfaSubordinationDiagnosisDetailList +
                ", increaseList=" + increaseList +
                ", decreaseList=" + decreaseList +
                '}';
    }
}
