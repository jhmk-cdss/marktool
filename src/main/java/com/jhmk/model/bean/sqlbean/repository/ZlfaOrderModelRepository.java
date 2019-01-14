package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface ZlfaOrderModelRepository extends PagingAndSortingRepository<ZlfaOrderModel, Integer>, JpaSpecificationExecutor<ZlfaOrderModel> {
    List<ZlfaOrderModel>findAllByOrderItemName(String orderItemName);


}
