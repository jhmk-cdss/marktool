//package com.jhmk.model.bean.sqlbean;
//
//import javax.persistence.*;
//import java.util.Objects;
//
///**
// * @author ziyu.zhou
// * @date 2018/12/13 19:20
// */
//
//@Entity
//@Table(name = "zlfn_update_diagnosis_detail")
//public class ZlfaUpdateDiagnosisDetail {
//    private int id;
//    private String zlfnModelId;
//    private String medicineTreatment;
//    private String changeReasonId;
//    private String orderCorrespondenceId;
//
//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "zlfn_model_id", nullable = true, length = 50)
//    public String getZlfnModelId() {
//        return zlfnModelId;
//    }
//
//    public void setZlfnModelId(String zlfnModelId) {
//        this.zlfnModelId = zlfnModelId;
//    }
//
//    @Basic
//    @Column(name = "medicine_treatment", nullable = true, length = 50)
//    public String getMedicineTreatment() {
//        return medicineTreatment;
//    }
//
//    public void setMedicineTreatment(String medicineTreatment) {
//        this.medicineTreatment = medicineTreatment;
//    }
//
//    @Basic
//    @Column(name = "change_reason_id", nullable = false, length = 50)
//    public String getChangeReasonId() {
//        return changeReasonId;
//    }
//
//    public void setChangeReasonId(String changeReasonId) {
//        this.changeReasonId = changeReasonId;
//    }
//
//    @Basic
//    @Column(name = "order_correspondence_id", nullable = true, length = 50)
//    public String getOrderCorrespondenceId() {
//        return orderCorrespondenceId;
//    }
//
//    public void setOrderCorrespondenceId(String orderCorrespondenceId) {
//        this.orderCorrespondenceId = orderCorrespondenceId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ZlfaUpdateDiagnosisDetail that = (ZlfaUpdateDiagnosisDetail) o;
//        return id == that.id &&
//                Objects.equals(zlfnModelId, that.zlfnModelId) &&
//                Objects.equals(medicineTreatment, that.medicineTreatment) &&
//                Objects.equals(changeReasonId, that.changeReasonId) &&
//                Objects.equals(orderCorrespondenceId, that.orderCorrespondenceId);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, zlfnModelId, medicineTreatment, changeReasonId, orderCorrespondenceId);
//    }
//}
