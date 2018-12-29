package com.jhmk.model.bean.mongobean;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author ziyu.zhou
 * @date 2018/12/5 17:26
 */
@Document(collection = "collection_type3")
public class CollectionType3 implements Serializable {
    @Id
    private String _id;
    private String dept_name;
    private String admission_time;
    private String patient_id;
    private String visit_id;
    private String 入院诊断;
    private String 出院诊断;
    private String 模型结果;
    private String batchno;
    private String 异常原因;
    private int status;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getAdmission_time() {
        return admission_time;
    }

    public void setAdmission_time(String admission_time) {
        this.admission_time = admission_time;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public String get入院诊断() {
        return 入院诊断;
    }

    public void set入院诊断(String 入院诊断) {
        this.入院诊断 = 入院诊断;
    }

    public String get出院诊断() {
        return 出院诊断;
    }

    public void set出院诊断(String 出院诊断) {
        this.出院诊断 = 出院诊断;
    }

    public String get模型结果() {
        return 模型结果;
    }

    public void set模型结果(String 模型结果) {
        this.模型结果 = 模型结果;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String get异常原因() {
        return 异常原因;
    }

    public void set异常原因(String 异常原因) {
        this.异常原因 = 异常原因;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

