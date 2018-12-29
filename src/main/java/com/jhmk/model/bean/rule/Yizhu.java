package com.jhmk.model.bean.rule;

import java.io.Serializable;

/**
 * @author ziyu.zhou
 * @date 2018/7/30 11:46
 */


public class Yizhu implements Serializable {
    private String order_item_name;
    private String order_begin_time;
    private String order_end_time;
    private String order_properties_name;//长期 临时医嘱
    private String order_status_name;//停止
    private String frequency_name;//频次
    private String dosage_value;//剂量
    private String dosage_value_unit;//单位
    private String order_class_name;//医嘱类别名称
    private String order_class_convert_name;//医嘱转化类别名称
    private String order_class_code;//医嘱类别编码
    private String china_approved_drug_name;//药品通用名
    private String drug_trade_name;//药品商品名
    private String print_name;//药品成分名
    private String order_item_code;//医嘱项编码
    private String parent_order_no;//父医嘱号
    private String order_no;//医嘱号
    private String frequency_code;//执行频次编码
    private String duration_value;//持续时间值
    private String   duration_unit;//持续时间单位
    private String order_time ;//开医嘱日期及时间
    private String  stop_order_time;//停医嘱时间
    private String  dosage_form;//药品剂型
    private String drug_production_classification ;//药品生产方式分类
    private String  total_dosage_value;//总剂量值
    private String  total_dosage_unit;//总剂量单位
    private String  specification;//包装规格说明
    private String drug_amount_value ;//药品数量值
    private String  drug_amount_value_unit;//药品数量值单位
    private String pharmacy_way_name ;//给药途径和方法/用途
    private String  discharge_medicine_indicator;//出院带药标识
    private String  presc_time;//执行时间
    private String  patient_id ;//
    private String  visit_id;//
    //医嘱时间 精确到日
    private String  dayTime;
    private String  endDayTime;


    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public String getOrder_begin_time() {
        return order_begin_time;
    }

    public void setOrder_begin_time(String order_begin_time) {
        this.order_begin_time = order_begin_time;
    }

    public String getOrder_end_time() {
        return order_end_time;
    }

    public void setOrder_end_time(String order_end_time) {
        this.order_end_time = order_end_time;
    }

    public String getOrder_properties_name() {
        return order_properties_name;
    }

    public void setOrder_properties_name(String order_properties_name) {
        this.order_properties_name = order_properties_name;
    }

    public String getOrder_status_name() {
        return order_status_name;
    }

    public void setOrder_status_name(String order_status_name) {
        this.order_status_name = order_status_name;
    }

    public String getFrequency_name() {
        return frequency_name;
    }

    public void setFrequency_name(final String frequency_name) {
        this.frequency_name = frequency_name;
    }

    public String getDosage_value() {
        return dosage_value;
    }

    public void setDosage_value(final String dosage_value) {
        this.dosage_value = dosage_value;
    }

    public String getDosage_value_unit() {
        return dosage_value_unit;
    }

    public void setDosage_value_unit(final String dosage_value_unit) {
        this.dosage_value_unit = dosage_value_unit;
    }

    public String getOrder_class_name() {
        return order_class_name;
    }

    public void setOrder_class_name(final String order_class_name) {
        this.order_class_name = order_class_name;
    }

    public String getOrder_class_convert_name() {
        return order_class_convert_name;
    }

    public void setOrder_class_convert_name(final String order_class_convert_name) {
        this.order_class_convert_name = order_class_convert_name;
    }

    public String getOrder_class_code() {
        return order_class_code;
    }

    public void setOrder_class_code(final String order_class_code) {
        this.order_class_code = order_class_code;
    }

    public String getChina_approved_drug_name() {
        return china_approved_drug_name;
    }

    public void setChina_approved_drug_name(final String china_approved_drug_name) {
        this.china_approved_drug_name = china_approved_drug_name;
    }

    public String getDrug_trade_name() {
        return drug_trade_name;
    }

    public void setDrug_trade_name(final String drug_trade_name) {
        this.drug_trade_name = drug_trade_name;
    }

    public String getPrint_name() {
        return print_name;
    }

    public void setPrint_name(final String print_name) {
        this.print_name = print_name;
    }

    public String getOrder_item_code() {
        return order_item_code;
    }

    public void setOrder_item_code(final String order_item_code) {
        this.order_item_code = order_item_code;
    }

    public String getParent_order_no() {
        return parent_order_no;
    }

    public void setParent_order_no(final String parent_order_no) {
        this.parent_order_no = parent_order_no;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(final String order_no) {
        this.order_no = order_no;
    }

    public String getFrequency_code() {
        return frequency_code;
    }

    public void setFrequency_code(final String frequency_code) {
        this.frequency_code = frequency_code;
    }

    public String getDuration_value() {
        return duration_value;
    }

    public void setDuration_value(final String duration_value) {
        this.duration_value = duration_value;
    }

    public String getDuration_unit() {
        return duration_unit;
    }

    public void setDuration_unit(final String duration_unit) {
        this.duration_unit = duration_unit;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(final String order_time) {
        this.order_time = order_time;
    }

    public String getStop_order_time() {
        return stop_order_time;
    }

    public void setStop_order_time(final String stop_order_time) {
        this.stop_order_time = stop_order_time;
    }

    public String getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(final String dosage_form) {
        this.dosage_form = dosage_form;
    }

    public String getDrug_production_classification() {
        return drug_production_classification;
    }

    public void setDrug_production_classification(final String drug_production_classification) {
        this.drug_production_classification = drug_production_classification;
    }

    public String getTotal_dosage_value() {
        return total_dosage_value;
    }

    public void setTotal_dosage_value(final String total_dosage_value) {
        this.total_dosage_value = total_dosage_value;
    }

    public String getTotal_dosage_unit() {
        return total_dosage_unit;
    }

    public void setTotal_dosage_unit(final String total_dosage_unit) {
        this.total_dosage_unit = total_dosage_unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(final String specification) {
        this.specification = specification;
    }

    public String getDrug_amount_value() {
        return drug_amount_value;
    }

    public void setDrug_amount_value(final String drug_amount_value) {
        this.drug_amount_value = drug_amount_value;
    }

    public String getDrug_amount_value_unit() {
        return drug_amount_value_unit;
    }

    public void setDrug_amount_value_unit(final String drug_amount_value_unit) {
        this.drug_amount_value_unit = drug_amount_value_unit;
    }

    public String getPharmacy_way_name() {
        return pharmacy_way_name;
    }

    public void setPharmacy_way_name(final String pharmacy_way_name) {
        this.pharmacy_way_name = pharmacy_way_name;
    }

    public String getDischarge_medicine_indicator() {
        return discharge_medicine_indicator;
    }

    public void setDischarge_medicine_indicator(final String discharge_medicine_indicator) {
        this.discharge_medicine_indicator = discharge_medicine_indicator;
    }

    public String getPresc_time() {
        return presc_time;
    }

    public void setPresc_time(final String presc_time) {
        this.presc_time = presc_time;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(final String patient_id) {
        this.patient_id = patient_id;
    }

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(final String visit_id) {
        this.visit_id = visit_id;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }


    public String getEndDayTime() {
        return endDayTime;
    }

    public void setEndDayTime(String endDayTime) {
        this.endDayTime = endDayTime;
    }
}