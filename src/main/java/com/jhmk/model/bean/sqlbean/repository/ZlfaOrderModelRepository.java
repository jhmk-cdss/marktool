package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface ZlfaOrderModelRepository extends PagingAndSortingRepository<ZlfaOrderModel, Integer>, JpaSpecificationExecutor<ZlfaOrderModel> {
    List<ZlfaOrderModel> findAllByOrderItemName(String orderItemName);

    @Override
    long count();

    /**
     * 查询所有不同医嘱项名称
     * @return
     */
    @Query("select distinct (m.orderItemName) from ZlfaOrderModel  m")
    List<String> findDistinctByOrderItemName();


    /**
     * 更新医嘱项名称的标准名
     * @param standardName
     * @param orderItemName
     * @return
     */

    @Modifying
    @Transactional
    @Query("update ZlfaOrderModel z set z.standardName=?1 where z.orderItemName=?2")
    int updateStandardName(String standardName, String orderItemName);
}
