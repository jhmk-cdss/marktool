package com.jhmk.model.bean.sqlbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:20
 */

@Entity
@JsonIgnoreProperties(value = {"zlfaMianDiagnosisDetail", "zlfaUpdateAddModel", "zlfaUpdateDeleteModel", "zlfaSubordinationDiagnosisDetail"})
@Table(name = "zlfn_order_model")
public class ZlfaOrderModel implements Serializable {
    private int id;
    private String orderClassName;
    private String orderClassConvertName;
    private String orderClassCode;
    private String orderPropertiesName;
    private String orderItemName;
    private String chinaApprovedDrugName;
    private String drugTradeName;
    private String printName;
    private String orderItemCode;
    private String parentOrderNo;
    private String orderNo;
    private String orderBeginTime;
    private String orderEndTime;
    private String orderStatusName;
    private String frequencyCode;
    private String frequencyName;
    private String durationValue;
    private String durationUnit;
    private String orderTime;
    private String stopOrderTime;
    private String dosageValue;
    private String dosageValueUnit;
    private String dosageForm;
    private String drugProductionClassification;
    private String totalDosageValue;
    private String totalDosageUnit;
    private String specification;
    private String drugAmountValue;
    private String drugAmountValueUnit;
    private String pharmacyWayName;
    private String dischargeMedicineIndicator;
    private String prescTime;
    private String patientId;
    private String visitId;
    private String standardName;

    @JSONField(serialize = false)
    private ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail;
    @JSONField(serialize = false)
    private ZlfaUpdateDeleteModel zlfaUpdateDeleteModel;
    @JSONField(serialize = false)
    private ZlfaUpdateAddModel zlfaUpdateAddModel;
    @JSONField(serialize = false)
    private ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail;


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
    @Column(name = "order_class_name", nullable = true, length = 255)
    public String getOrderClassName() {
        return orderClassName;
    }

    public void setOrderClassName(String orderClassName) {
        this.orderClassName = orderClassName;
    }

    @Basic
    @Column(name = "order_class_convert_name", nullable = true, length = 255)
    public String getOrderClassConvertName() {
        return orderClassConvertName;
    }

    public void setOrderClassConvertName(String orderClassConvertName) {
        this.orderClassConvertName = orderClassConvertName;
    }

    @Basic
    @Column(name = "order_class_code", nullable = true, length = 255)
    public String getOrderClassCode() {
        return orderClassCode;
    }

    public void setOrderClassCode(String orderClassCode) {
        this.orderClassCode = orderClassCode;
    }

    @Basic
    @Column(name = "order_properties_name", nullable = true, length = 255)
    public String getOrderPropertiesName() {
        return orderPropertiesName;
    }

    public void setOrderPropertiesName(String orderPropertiesName) {
        this.orderPropertiesName = orderPropertiesName;
    }

    @Basic
    @Column(name = "order_item_name", nullable = true, length = 255)
    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    @Basic
    @Column(name = "china_approved_drug_name", nullable = true, length = 255)
    public String getChinaApprovedDrugName() {
        return chinaApprovedDrugName;
    }

    public void setChinaApprovedDrugName(String chinaApprovedDrugName) {
        this.chinaApprovedDrugName = chinaApprovedDrugName;
    }

    @Basic
    @Column(name = "drug_trade_name", nullable = true, length = 255)
    public String getDrugTradeName() {
        return drugTradeName;
    }

    public void setDrugTradeName(String drugTradeName) {
        this.drugTradeName = drugTradeName;
    }

    @Basic
    @Column(name = "print_name", nullable = true, length = 255)
    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    @Basic
    @Column(name = "order_item_code", nullable = true, length = 255)
    public String getOrderItemCode() {
        return orderItemCode;
    }

    public void setOrderItemCode(String orderItemCode) {
        this.orderItemCode = orderItemCode;
    }

    @Basic
    @Column(name = "parent_order_no", nullable = true, length = 50)
    public String getParentOrderNo() {
        return parentOrderNo;
    }

    public void setParentOrderNo(String parentOrderNo) {
        this.parentOrderNo = parentOrderNo;
    }

    @Basic
    @Column(name = "order_no", nullable = true, length = 50)
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "order_begin_time", nullable = true)
    public String getOrderBeginTime() {
        return orderBeginTime;
    }

    public void setOrderBeginTime(String orderBeginTime) {
        this.orderBeginTime = orderBeginTime;
    }

    @Basic
    @Column(name = "order_end_time", nullable = true)
    public String getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    @Basic
    @Column(name = "order_status_name", nullable = true, length = 255)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    @Basic
    @Column(name = "frequency_code", nullable = true, length = 255)
    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    @Basic
    @Column(name = "frequency_name", nullable = true, length = 255)
    public String getFrequencyName() {
        return frequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        this.frequencyName = frequencyName;
    }

    @Basic
    @Column(name = "duration_value", nullable = true, length = 255)
    public String getDurationValue() {
        return durationValue;
    }

    public void setDurationValue(String durationValue) {
        this.durationValue = durationValue;
    }

    @Basic
    @Column(name = "duration_unit", nullable = true, length = 255)
    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    @Basic
    @Column(name = "order_time", nullable = true)
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "stop_order_time", nullable = true)
    public String getStopOrderTime() {
        return stopOrderTime;
    }

    public void setStopOrderTime(String stopOrderTime) {
        this.stopOrderTime = stopOrderTime;
    }

    @Basic
    @Column(name = "dosage_value", nullable = true, length = 255)
    public String getDosageValue() {
        return dosageValue;
    }

    public void setDosageValue(String dosageValue) {
        this.dosageValue = dosageValue;
    }

    @Basic
    @Column(name = "dosage_value_unit", nullable = true, length = 255)
    public String getDosageValueUnit() {
        return dosageValueUnit;
    }

    public void setDosageValueUnit(String dosageValueUnit) {
        this.dosageValueUnit = dosageValueUnit;
    }

    @Basic
    @Column(name = "dosage_form", nullable = true, length = 255)
    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    @Basic
    @Column(name = "drug_production_classification", nullable = true, length = 255)
    public String getDrugProductionClassification() {
        return drugProductionClassification;
    }

    public void setDrugProductionClassification(String drugProductionClassification) {
        this.drugProductionClassification = drugProductionClassification;
    }

    @Basic
    @Column(name = "total_dosage_value", nullable = true, length = 255)
    public String getTotalDosageValue() {
        return totalDosageValue;
    }

    public void setTotalDosageValue(String totalDosageValue) {
        this.totalDosageValue = totalDosageValue;
    }

    @Basic
    @Column(name = "total_dosage_unit", nullable = true, length = 255)
    public String getTotalDosageUnit() {
        return totalDosageUnit;
    }

    public void setTotalDosageUnit(String totalDosageUnit) {
        this.totalDosageUnit = totalDosageUnit;
    }

    @Basic
    @Column(name = "specification", nullable = true, length = 255)
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Basic
    @Column(name = "drug_amount_value", nullable = true, length = 255)
    public String getDrugAmountValue() {
        return drugAmountValue;
    }

    public void setDrugAmountValue(String drugAmountValue) {
        this.drugAmountValue = drugAmountValue;
    }

    @Basic
    @Column(name = "drug_amount_value_unit", nullable = true, length = 255)
    public String getDrugAmountValueUnit() {
        return drugAmountValueUnit;
    }

    public void setDrugAmountValueUnit(String drugAmountValueUnit) {
        this.drugAmountValueUnit = drugAmountValueUnit;
    }

    @Basic
    @Column(name = "pharmacy_way_name", nullable = true, length = 255)
    public String getPharmacyWayName() {
        return pharmacyWayName;
    }

    public void setPharmacyWayName(String pharmacyWayName) {
        this.pharmacyWayName = pharmacyWayName;
    }

    @Basic
    @Column(name = "discharge_medicine_indicator", nullable = true, length = 255)
    public String getDischargeMedicineIndicator() {
        return dischargeMedicineIndicator;
    }

    public void setDischargeMedicineIndicator(String dischargeMedicineIndicator) {
        this.dischargeMedicineIndicator = dischargeMedicineIndicator;
    }

    @Basic
    @Column(name = "presc_time", nullable = true)
    public String getPrescTime() {
        return prescTime;
    }

    public void setPrescTime(String prescTime) {
        this.prescTime = prescTime;
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
    @Column(name = "visit_id", nullable = true, length = 50)
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfn_update_add_model_id")//设置在article表中的关联字段(外键)
    public ZlfaUpdateAddModel getZlfaUpdateAddModel() {
        return zlfaUpdateAddModel;
    }

    public void setZlfaUpdateAddModel(ZlfaUpdateAddModel zlfaUpdateAddModel) {
        this.zlfaUpdateAddModel = zlfaUpdateAddModel;
    }


    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfn_update_delete_model_id")//设置在article表中的关联字段(外键)
    public ZlfaUpdateDeleteModel getZlfaUpdateDeleteModel() {
        return zlfaUpdateDeleteModel;
    }

    public void setZlfaUpdateDeleteModel(ZlfaUpdateDeleteModel zlfaUpdateDeleteModel) {
        this.zlfaUpdateDeleteModel = zlfaUpdateDeleteModel;
    }


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfa_subordination_diagnosis_detail_id")//设置在article表中的关联字段(外键)
    public ZlfaSubordinationDiagnosisDetail getZlfaSubordinationDiagnosisDetail() {
        return zlfaSubordinationDiagnosisDetail;
    }

    public void setZlfaSubordinationDiagnosisDetail(ZlfaSubordinationDiagnosisDetail zlfaSubordinationDiagnosisDetail) {
        this.zlfaSubordinationDiagnosisDetail = zlfaSubordinationDiagnosisDetail;
    }


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfa_mian_diagnosis_detail_id")//设置在article表中的关联字段(外键)
    public ZlfaMianDiagnosisDetail getZlfaMianDiagnosisDetail() {
        return zlfaMianDiagnosisDetail;
    }

    public void setZlfaMianDiagnosisDetail(ZlfaMianDiagnosisDetail zlfaMianDiagnosisDetail) {
        this.zlfaMianDiagnosisDetail = zlfaMianDiagnosisDetail;
    }


    @Basic
    @Column(name = "standard_name", nullable = true, length = 255)
    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZlfaOrderModel that = (ZlfaOrderModel) o;
        return Objects.equals(orderItemName, that.orderItemName) &&
                Objects.equals(patientId, that.patientId) &&
                Objects.equals(visitId, that.visitId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderItemName, patientId, visitId);
    }
}
