package com.jhmk.model.bean.rule;

import java.io.Serializable;

/**
 * @author ziyu.zhou
 * @date 2018/9/25 17:37
 */

public class Shoucibingchengjilu implements Serializable {

    private String differential_diagnostic_disease_name;//鉴别诊断疾病名
    private String disease_name;//鉴别原疾病'
    private DiagnosisAndDifferentialDiagnosis diagnosisAndDifferentialDiagnosis;//鉴别依据-疾病特点'
    private TreatmentPlan treatmentPlan;//诊疗计划



    public String getDifferential_diagnostic_disease_name() {
        return differential_diagnostic_disease_name;
    }

    public void setDifferential_diagnostic_disease_name(String differential_diagnostic_disease_name) {
        this.differential_diagnostic_disease_name = differential_diagnostic_disease_name;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public DiagnosisAndDifferentialDiagnosis getDiagnosisAndDifferentialDiagnosis() {
        return diagnosisAndDifferentialDiagnosis;
    }

    public void setDiagnosisAndDifferentialDiagnosis(final DiagnosisAndDifferentialDiagnosis diagnosisAndDifferentialDiagnosis) {
        this.diagnosisAndDifferentialDiagnosis = diagnosisAndDifferentialDiagnosis;
    }
}
