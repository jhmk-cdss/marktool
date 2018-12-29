package com.jhmk.model.bean.tempbean;

import java.util.Collection;
import java.util.Objects;

/**
 * @author ziyu.zhou
 * @date 2018/12/28 19:20
 */

public class CollectionCompareBean {
    private Collection<ZlfaCompareBean> columnMetaData;

    public Collection<ZlfaCompareBean> getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(Collection<ZlfaCompareBean> columnMetaData) {
        this.columnMetaData = columnMetaData;
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

    @Override
    public int hashCode() {

        return Objects.hash(columnMetaData);
    }
}
