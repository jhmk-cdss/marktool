package com.jhmk.model.bean.rule;

/**
 * @author ziyu.zhou
 * @date 2019/1/3 11:25
 * 首程诊断与鉴别诊断
 */

public class FirstCourseDifferentialDiagnosis {
    private String differential_diagnostic_disease_name;
    private String disease_name;
    private String differential_diagnostic_no;
    private Characteristics differential_diagnostic_patient_characteristics;
    private Characteristics differential_diagnostic_disease_characteristics;

    public String getDifferential_diagnostic_disease_name() {
        return differential_diagnostic_disease_name;
    }

    public void setDifferential_diagnostic_disease_name(final String differential_diagnostic_disease_name) {
        this.differential_diagnostic_disease_name = differential_diagnostic_disease_name;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(final String disease_name) {
        this.disease_name = disease_name;
    }

    public String getDifferential_diagnostic_no() {
        return differential_diagnostic_no;
    }

    public void setDifferential_diagnostic_no(final String differential_diagnostic_no) {
        this.differential_diagnostic_no = differential_diagnostic_no;
    }

    public Characteristics getDifferential_diagnostic_patient_characteristics() {
        return differential_diagnostic_patient_characteristics;
    }

    public void setDifferential_diagnostic_patient_characteristics(final Characteristics differential_diagnostic_patient_characteristics) {
        this.differential_diagnostic_patient_characteristics = differential_diagnostic_patient_characteristics;
    }

    public Characteristics getDifferential_diagnostic_disease_characteristics() {
        return differential_diagnostic_disease_characteristics;
    }

    public void setDifferential_diagnostic_disease_characteristics(final Characteristics differential_diagnostic_disease_characteristics) {
        this.differential_diagnostic_disease_characteristics = differential_diagnostic_disease_characteristics;
    }
}
