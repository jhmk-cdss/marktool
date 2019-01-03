package com.jhmk.model.bean.tempbean;

import com.alibaba.fastjson.JSONObject;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;

import java.util.*;

/**
 * @author ziyu.zhou
 * @date 2018/12/28 19:20
 */

public class CollectionCompareBean {
    private Collection<ZlfaCompareBean> columnMetaData;
    private Integer count;
    private String id;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(columnMetaData);
    }
}
