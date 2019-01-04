package com.jhmk.model.bean.sqlbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 19:54
 */

@Entity
@JsonIgnoreProperties(value = {"biaozhuZhubiao"})
@Table(name = "biaozhu_jbzdmodel")
public class BiaozhuJbzdmodel {
    private int id;
    private String differentialDiagnosisNum;
    private String differentialDiagnosisName;
    private String diagnosisName;
    private String differentialDiagnosisCauseDescribe;
    @JSONField(serialize=false)
    private BiaozhuZhubiao biaozhuZhubiao;
    private List<BiaozhuJbzdcause> biaozhuJbzdcauseList;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zhubiao_id")
    public BiaozhuZhubiao getBiaozhuZhubiao() {
        return biaozhuZhubiao;
    }

    public void setBiaozhuZhubiao(BiaozhuZhubiao biaozhuZhubiao) {
        this.biaozhuZhubiao = biaozhuZhubiao;
    }

    @Basic
    @Column(name = "differential_diagnosis_num", nullable = true, length = 50)
    public String getDifferentialDiagnosisNum() {
        return differentialDiagnosisNum;
    }

    public void setDifferentialDiagnosisNum(String differentialDiagnosisNum) {
        this.differentialDiagnosisNum = differentialDiagnosisNum;
    }

    @Basic
    @Column(name = "differential_diagnosis_name", nullable = true, length = 50)
    public String getDifferentialDiagnosisName() {
        return differentialDiagnosisName;
    }

    public void setDifferentialDiagnosisName(String differentialDiagnosisName) {
        this.differentialDiagnosisName = differentialDiagnosisName;
    }


    @Basic
    @Column(name = "diagnosis_name", nullable = true, length = 50)
    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    @Basic
    @Column(name = "differential_diagnosis_cause_describe", nullable = true, length = 50)
    public String getDifferentialDiagnosisCauseDescribe() {
        return differentialDiagnosisCauseDescribe;
    }

    public void setDifferentialDiagnosisCauseDescribe(String differentialDiagnosisCauseDescribe) {
        this.differentialDiagnosisCauseDescribe = differentialDiagnosisCauseDescribe;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "biaozhuJbzdmodel", cascade = CascadeType.ALL)
    public List<BiaozhuJbzdcause> getBiaozhuJbzdcauseList() {
        return biaozhuJbzdcauseList;
    }

    public void setBiaozhuJbzdcauseList(List<BiaozhuJbzdcause> biaozhuJbzdcauseList) {
        this.biaozhuJbzdcauseList = biaozhuJbzdcauseList;
    }


}
