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
 * @date 2018/12/14 10:50
 */

@Entity
@JsonIgnoreProperties(value = {"zlfaModel"})
@Table(name = "zlfn_update_add_model")
public class ZlfaUpdateAddModel implements Serializable {
    private int id;
    @JSONField(serialize=false)
    private ZlfaModel zlfaModel;
    private String medicineTreatment;
    private List<ZlfaIncidentModel> zlfaIncidentModelList;//事件模型
    //    private List<ZlfaOrderModel> zlfaOrderModelList;//医嘱模型
    private   ZlfaOrderModel zlfaOrderModel;//医嘱模型

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
    @Column(name = "medicine_treatment", nullable = true, length = 50)
    public String getMedicineTreatment() {
        return medicineTreatment;
    }

    public void setMedicineTreatment(String medicineTreatment) {
        this.medicineTreatment = medicineTreatment;
    }



    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "zlfn_model_id")//设置在article表中的关联字段(外键)
    public ZlfaModel getZlfaModel() {
        return zlfaModel;
    }


    public void setZlfaModel(ZlfaModel zlfaModel) {
        this.zlfaModel = zlfaModel;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "zlfaUpdateAddModel")
    public List<ZlfaIncidentModel> getZlfaIncidentModelList() {
        return zlfaIncidentModelList;
    }

    public void setZlfaIncidentModelList(List<ZlfaIncidentModel> zlfaIncidentModelList) {
        this.zlfaIncidentModelList = zlfaIncidentModelList;
    }


    //    @OneToOne(mappedBy = "zlfaUpdateDeleteModel")

    @OneToOne(cascade = CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "order_model_id", referencedColumnName = "id")//people中的address_id字段参考address表中的id字段
    public ZlfaOrderModel getZlfaOrderModel() {
        return zlfaOrderModel;
    }

    public void setZlfaOrderModel(ZlfaOrderModel zlfaOrderModel) {
        this.zlfaOrderModel = zlfaOrderModel;
    }
}
