package com.jhmk.model.bean.rule;

import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/7/29 17:36
 */

public class MenZhen {
    private String id;
    private String patient_id;
    private String visit_id;
    private String batchno;
    //部门
    private String dept_code;
    //门诊主疾病
    private String diagnosis;


    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    //主诉
    private String chief_complaint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String getChief_complaint() {
        return chief_complaint;
    }

    public void setChief_complaint(String chief_complaint) {
        this.chief_complaint = chief_complaint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenZhen menZhen = (MenZhen) o;
        return Objects.equals(id, menZhen.id) &&
                Objects.equals(patient_id, menZhen.patient_id) &&
                Objects.equals(visit_id, menZhen.visit_id) &&
                Objects.equals(chief_complaint, menZhen.chief_complaint);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, patient_id, visit_id, chief_complaint);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "MenZhen{" +
                "id='" + id + '\'' +
                ", patient_id='" + patient_id + '\'' +
                ", visit_id='" + visit_id + '\'' +
                ", batchno='" + batchno + '\'' +
                ", dept_code='" + dept_code + '\'' +
                ", chief_complaint='" + chief_complaint + '\'' +
                '}';
    }
}
