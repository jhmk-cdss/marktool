package com.jhmk.model.bean.sqlbean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 20:15
 */

@Entity
@JsonIgnoreProperties( {"patientFeature","differentialDiagnosisFeature"})
@Table(name = "biaozhu_tzysmodel")
public class BiaozhuTzysmodel {
    private int id;
    private String featuresType;
    private String featuresName;
    private String featuresQuantizationLow;
    private String featuresQuantizationHigh;
    private String featuresQuantizationUnit;
    private String featuresQuantizationResult;
    private String featuresQualResult;
    private BiaozhuJbzdcause patientFeature;
    private BiaozhuJbzdcause differentialDiagnosisFeature;

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
    @Column(name = "features_type", nullable = true, length = 50)
    public String getFeaturesType() {
        return featuresType;
    }

    public void setFeaturesType(String featuresType) {
        this.featuresType = featuresType;
    }

    @Basic
    @Column(name = "features_name", nullable = true, length = 20)
    public String getFeaturesName() {
        return featuresName;
    }

    public void setFeaturesName(String featuresName) {
        this.featuresName = featuresName;
    }

    @Basic
    @Column(name = "features_quantization_low", nullable = true, length = 20)
    public String getFeaturesQuantizationLow() {
        return featuresQuantizationLow;
    }

    public void setFeaturesQuantizationLow(String featuresQuantizationLow) {
        this.featuresQuantizationLow = featuresQuantizationLow;
    }

    @Basic
    @Column(name = "features_quantization_high", nullable = true, length = 20)
    public String getFeaturesQuantizationHigh() {
        return featuresQuantizationHigh;
    }

    public void setFeaturesQuantizationHigh(String featuresQuantizationHigh) {
        this.featuresQuantizationHigh = featuresQuantizationHigh;
    }

    @Basic
    @Column(name = "features_quantization_unit", nullable = true, length = 20)
    public String getFeaturesQuantizationUnit() {
        return featuresQuantizationUnit;
    }

    public void setFeaturesQuantizationUnit(String featuresQuantizationUnit) {
        this.featuresQuantizationUnit = featuresQuantizationUnit;
    }

    @Basic
    @Column(name = "features_quantization_result", nullable = true, length = 20)
    public String getFeaturesQuantizationResult() {
        return featuresQuantizationResult;
    }

    public void setFeaturesQuantizationResult(String featuresQuantizationResult) {
        this.featuresQuantizationResult = featuresQuantizationResult;
    }

    @Basic
    @Column(name = "features_qual_result", nullable = true, length = 20)
    public String getFeaturesQualResult() {
        return featuresQualResult;
    }

    public void setFeaturesQualResult(String featuresQualResult) {
        this.featuresQualResult = featuresQualResult;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_features_id")
    public BiaozhuJbzdcause getPatientFeature() {
        return patientFeature;
    }

    public void setPatientFeature(BiaozhuJbzdcause patientFeature) {
        this.patientFeature = patientFeature;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "differential_diagnosis_features_id")
    public BiaozhuJbzdcause getDifferentialDiagnosisFeature() {
        return differentialDiagnosisFeature;
    }

    public void setDifferentialDiagnosisFeature(BiaozhuJbzdcause differentialDiagnosisFeature) {
        this.differentialDiagnosisFeature = differentialDiagnosisFeature;
    }
}
