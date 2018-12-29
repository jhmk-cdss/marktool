package com.jhmk.model.bean.sqlbean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/12 11:34
 */

@Entity
@JsonIgnoreProperties({"biaozhuJbzdmodel"})
@Table(name = "biaozhu_jbzdcause")
public class BiaozhuJbzdcause {
    private int id;
    private String differentialDiagnosisLab;
    private String differentialDiagnosisExam;
    private BiaozhuJbzdmodel biaozhuJbzdmodel ;//鉴别诊断疾病特征因素
    private List<BiaozhuTzysmodel> patientFeatures;//患者具有的特征因素
    private List<BiaozhuTzysmodel> differentialDiagnosisFeatures;//鉴别诊断疾病特征因素

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
    @Column(name = "differential_diagnosis_lab", nullable = true, length = 50)
    public String getDifferentialDiagnosisLab() {
        return differentialDiagnosisLab;
    }

    public void setDifferentialDiagnosisLab(String differentialDiagnosisLab) {
        this.differentialDiagnosisLab = differentialDiagnosisLab;
    }

    @Basic
    @Column(name = "differential_diagnosis_exam", nullable = true, length = 50)
    public String getDifferentialDiagnosisExam() {
        return differentialDiagnosisExam;
    }

    public void setDifferentialDiagnosisExam(String differentialDiagnosisExam) {
        this.differentialDiagnosisExam = differentialDiagnosisExam;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patientFeature", cascade = CascadeType.ALL)
    public List<BiaozhuTzysmodel> getPatientFeatures() {
        return patientFeatures;
    }

    public void setPatientFeatures(List<BiaozhuTzysmodel> patientFeatures) {
        this.patientFeatures = patientFeatures;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "differentialDiagnosisFeature", cascade = CascadeType.ALL)
    public List<BiaozhuTzysmodel> getDifferentialDiagnosisFeatures() {
        return differentialDiagnosisFeatures;
    }

    public void setDifferentialDiagnosisFeatures(List<BiaozhuTzysmodel> differentialDiagnosisFeatures) {
        this.differentialDiagnosisFeatures = differentialDiagnosisFeatures;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jbzdmodel_id")
    public BiaozhuJbzdmodel getBiaozhuJbzdmodel() {
        return biaozhuJbzdmodel;
    }

    public void setBiaozhuJbzdmodel(BiaozhuJbzdmodel biaozhuJbzdmodel) {
        this.biaozhuJbzdmodel = biaozhuJbzdmodel;
    }
}
