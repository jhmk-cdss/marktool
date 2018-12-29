package com.jhmk.model.bean.sqlbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.javafx.geom.transform.Identity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 19:54
 */

@Entity
@Table(name = "biaozhu_zhubiao")
public class BiaozhuZhubiao {
    private int id;
    private String hospitalName;
    private String deptName;
    private String deptStandardName;
    private Integer doctorId;
    private String patientId;
    private String visitId;
    private String admissionMainDiagnosis;
    private String dischargeMainDiagnosis;
    private Date createTime;

    private List<BiaozhuJbzdmodel> biaozhuJbzdmodelList;

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
    @Column(name = "hospital_name", nullable = true, length = 50)
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Basic
    @Column(name = "dept_name", nullable = true, length = 20)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "dept_standard_name", nullable = true, length = 50)
    public String getDeptStandardName() {
        return deptStandardName;
    }

    public void setDeptStandardName(String deptStandardName) {
        this.deptStandardName = deptStandardName;
    }

    @Basic
    @Column(name = "doctor_id", nullable = true)
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "patient_id", nullable = true, length = 50)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "visit_id", nullable = true, length = 10)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    @Basic
    @Column(name = "admission_main_diagnosis", nullable = true, length = 50)
    public String getAdmissionMainDiagnosis() {
        return admissionMainDiagnosis;
    }

    public void setAdmissionMainDiagnosis(String admissionMainDiagnosis) {
        this.admissionMainDiagnosis = admissionMainDiagnosis;
    }

    @Basic
    @Column(name = "discharge_main_diagnosis", nullable = true, length = 50)
    public String getDischargeMainDiagnosis() {
        return dischargeMainDiagnosis;
    }

    public void setDischargeMainDiagnosis(String dischargeMainDiagnosis) {
        this.dischargeMainDiagnosis = dischargeMainDiagnosis;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "biaozhuZhubiao")
    public List<BiaozhuJbzdmodel> getBiaozhuJbzdmodelList() {
        return biaozhuJbzdmodelList;
    }

    public void setBiaozhuJbzdmodelList(List<BiaozhuJbzdmodel> biaozhuJbzdmodelList) {
        this.biaozhuJbzdmodelList = biaozhuJbzdmodelList;
    }

    @Column(name = "create_time", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
