package com.jhmk.model.bean.tempbean;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.util.CompareUtil;

import java.util.*;

/**
 * @author ziyu.zhou
 * @date 2018/12/28 19:20
 */

public class CollectionCompareBean {
    private Collection<ZlfaCompareBean> columnMetaData;
    //聚合次数
    private Integer count;
    //病历id
    private String id;
    private Float totalFee;
    private List<Float> totalFeeList;
    private int inHospitalDay;
    private List<Integer> inHospitalDayList;
    private int avgInHospitalDay;
    private Float avgTotalFee;
    private Set<String> idList = new HashSet<>();

    public Collection<ZlfaCompareBean> getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(Collection<ZlfaCompareBean> columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public List<Float> getTotalFeeList() {
        return totalFeeList;
    }

    public void setTotalFeeList(List<Float> totalFeeList) {
        this.totalFeeList = totalFeeList;
    }

    public int getInHospitalDay() {
        return inHospitalDay;
    }

    public void setInHospitalDay(int inHospitalDay) {
        this.inHospitalDay = inHospitalDay;
    }

    public List<Integer> getInHospitalDayList() {
        return inHospitalDayList;
    }

    public void setInHospitalDayList(List<Integer> inHospitalDayList) {
        this.inHospitalDayList = inHospitalDayList;
    }

    public int getAvgInHospitalDay() {
        return avgInHospitalDay;
    }

    public void setAvgInHospitalDay(int avgInHospitalDay) {
        this.avgInHospitalDay = avgInHospitalDay;
    }

    public Float getAvgTotalFee() {
        return avgTotalFee;
    }

    public void setAvgTotalFee(Float avgTotalFee) {
        this.avgTotalFee = avgTotalFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionCompareBean that = (CollectionCompareBean) o;
        if (columnMetaData.size() != that.getColumnMetaData().size()) {
            return false;
        }
        return columnMetaData.containsAll(that.getColumnMetaData());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getIdList() {
        return idList;
    }

    public void setIdList(Set<String> idList) {
        this.idList = idList;
    }

    @Override
    public int hashCode() {

        return Objects.hash(columnMetaData);
    }


    public static void main(String[] args) {
        List<CollectionCompareBean> list = new ArrayList<>();
        CollectionCompareBean collectionCompareBean1 = new CollectionCompareBean();
        collectionCompareBean1.setCount(1);

        List<ZlfaCompareBean> list1 = new ArrayList<>();
        ZlfaCompareBean zlfaCompareBean = new ZlfaCompareBean();
        zlfaCompareBean.setOrderItemName("1");
        zlfaCompareBean.setMedicineTreatment("1");
        zlfaCompareBean.setTreatmentGoals("1");
        ZlfaCompareBean zlfaCompareBean2 = new ZlfaCompareBean();
        zlfaCompareBean2.setOrderItemName("2");
        zlfaCompareBean2.setMedicineTreatment("2");
        zlfaCompareBean2.setTreatmentGoals("2");
        list1.add(zlfaCompareBean2);
        list1.add(zlfaCompareBean);
        collectionCompareBean1.setColumnMetaData(list1);
        list.add(collectionCompareBean1);

        CollectionCompareBean collectionCompareBean2 = new CollectionCompareBean();
        collectionCompareBean2.setCount(1);
        List<ZlfaCompareBean> list2 = new ArrayList<>();
        ZlfaCompareBean zlfaCompareBean3 = new ZlfaCompareBean();
        zlfaCompareBean3.setOrderItemName("1");
        zlfaCompareBean3.setMedicineTreatment("1");
        zlfaCompareBean3.setTreatmentGoals("1");
        ZlfaCompareBean zlfaCompareBean44 = new ZlfaCompareBean();
        zlfaCompareBean44.setOrderItemName("2");
        zlfaCompareBean44.setMedicineTreatment("2");
        zlfaCompareBean44.setTreatmentGoals("2");
        list2.add(zlfaCompareBean3);
        list2.add(zlfaCompareBean44);
        collectionCompareBean2.setColumnMetaData(list2);
        list.add(collectionCompareBean2);
//        Map<CollectionCompareBean, Integer> map = new HashMap<>();
//        map.put(collectionCompareBean1,1);
//        if (list.contains(collectionCompareBean2)){
//            int i = list.indexOf(collectionCompareBean2);
//            CollectionCompareBean collectionCompareBean = list.get(i);
//            collectionCompareBean.setCount(collectionCompareBean.getCount()+1);
//        }
        //重写  重复次数
        List<CollectionCompareBean> resultList = new ArrayList<>();
        for (CollectionCompareBean bean : list) {
            if (resultList.contains(bean)) {
                int i = resultList.indexOf(bean);
                CollectionCompareBean collectionCompareBean = list.get(i);
                collectionCompareBean.setCount(collectionCompareBean.getCount() + 1);
            } else {
                bean.setCount(1);
                resultList.add(bean);
            }
        }
        Collections.sort(resultList, CompareUtil.createComparator(-1, "count"));

        System.out.println(list.contains(collectionCompareBean2));
        int i = list.indexOf(collectionCompareBean2);
        System.out.println(i);
//        boolean b = map.containsKey(collectionCompareBean2);
//        System.out.println(b);
//        System.out.println(collectionCompareBean1.equals(collectionCompareBean2));
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(columnMetaData);
    }
}
