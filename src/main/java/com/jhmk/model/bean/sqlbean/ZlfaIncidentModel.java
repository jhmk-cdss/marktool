package com.jhmk.model.bean.sqlbean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/13 19:20
 * 治疗方案事件模型
 */

@Entity
@JsonIgnoreProperties(value = {"zlfaUpdateAddModel","zlfaUpdateDeleteModel"})
@Table(name = "zlfn_incident_model")
public class ZlfaIncidentModel implements Serializable {
    private int id;
    private String eventType;
    private String eventName;
    private String eventQuantizationLow;
    private String eventQuantizationHigh;
    private String eventQuantizationUnit;
    private String eventQuantizationResult;
    private String eventQualResult;
    @JSONField(serialize=false)
    private ZlfaUpdateAddModel zlfaUpdateAddModel;
    @JSONField(serialize=false)
    private ZlfaUpdateDeleteModel zlfaUpdateDeleteModel;

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
    @Column(name = "event_type", nullable = true, length = 255)
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "event_name", nullable = true, length = 255)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Basic
    @Column(name = "event_quantization_low", nullable = true, length = 255)
    public String getEventQuantizationLow() {
        return eventQuantizationLow;
    }

    public void setEventQuantizationLow(String eventQuantizationLow) {
        this.eventQuantizationLow = eventQuantizationLow;
    }

    @Basic
    @Column(name = "event_quantization_high", nullable = true, length = 255)
    public String getEventQuantizationHigh() {
        return eventQuantizationHigh;
    }

    public void setEventQuantizationHigh(String eventQuantizationHigh) {
        this.eventQuantizationHigh = eventQuantizationHigh;
    }

    @Basic
    @Column(name = "event_quantization_unit", nullable = true, length = 255)
    public String getEventQuantizationUnit() {
        return eventQuantizationUnit;
    }

    public void setEventQuantizationUnit(String eventQuantizationUnit) {
        this.eventQuantizationUnit = eventQuantizationUnit;
    }

    @Basic
    @Column(name = "event_quantization_result", nullable = true, length = 255)
    public String getEventQuantizationResult() {
        return eventQuantizationResult;
    }

    public void setEventQuantizationResult(String eventQuantizationResult) {
        this.eventQuantizationResult = eventQuantizationResult;
    }

    @Basic
    @Column(name = "event_qual_result", nullable = true, length = 255)
    public String getEventQualResult() {
        return eventQualResult;
    }

    public void setEventQualResult(String eventQualResult) {
        this.eventQualResult = eventQualResult;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfa_update_add_id")//设置在article表中的关联字段(外键)
    public ZlfaUpdateAddModel getZlfaUpdateAddModel() {
        return zlfaUpdateAddModel;
    }

    public void setZlfaUpdateAddModel(ZlfaUpdateAddModel zlfaUpdateAddModel) {
        this.zlfaUpdateAddModel = zlfaUpdateAddModel;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfa_update_delelte_id")//设置在article表中的关联字段(外键)
    public ZlfaUpdateDeleteModel getZlfaUpdateDeleteModel() {
        return zlfaUpdateDeleteModel;
    }

    public void setZlfaUpdateDeleteModel(ZlfaUpdateDeleteModel zlfaUpdateDeleteModel) {
        this.zlfaUpdateDeleteModel = zlfaUpdateDeleteModel;
    }
}
