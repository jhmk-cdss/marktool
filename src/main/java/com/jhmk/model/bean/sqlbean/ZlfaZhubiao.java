package com.jhmk.model.bean.sqlbean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:20
 */

@Entity
@Table(name = "zlfn_zhubiao")
public class ZlfaZhubiao implements Serializable{
    private int id;
    private String hospitalName;
    private String deptName;
    private String deptStandardName;
    private String doctorId;
    private String patientId;
    private String visitId;
    private String admissionMainDiagnosis;
    private String dischargeMainDiagnosis;
    private String patientConditionClassification;
    private Date createTime;
    private List<ZlfaModel> zlfaModelList;

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
    @Column(name = "dept_name", nullable = true, length = 50)
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
    @Column(name = "doctor_id", nullable = true, length = 30)
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "patient_id", nullable = true, length = 30)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "visit_id", nullable = true, length = 30)
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

    @Basic
    @Column(name = "patient_condition_classification", nullable = true, length = 50)
    public String getPatientConditionClassification() {
        return patientConditionClassification;
    }

    public void setPatientConditionClassification(String patientConditionClassification) {
        this.patientConditionClassification = patientConditionClassification;
    }
    @Column(name = "create_time", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 主表id是主键 ZlfaModel表的zhubiaoId是外键
     *
     * @return
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "zlfaZhubiao")
    public List<ZlfaModel> getZlfaModelList() {
        return zlfaModelList;
    }

    public void setZlfaModelList(List<ZlfaModel> zlfaModelList) {
        this.zlfaModelList = zlfaModelList;
    }

    @Override
    public String toString() {
        return "ZlfaZhubiao{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptStandardName='" + deptStandardName + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", visitId='" + visitId + '\'' +
                ", admissionMainDiagnosis='" + admissionMainDiagnosis + '\'' +
                ", dischargeMainDiagnosis='" + dischargeMainDiagnosis + '\'' +
                ", patientConditionClassification='" + patientConditionClassification + '\'' +
                ", createTime=" + createTime +
                ", zlfaModelList=" + zlfaModelList +
                '}';
    }
}