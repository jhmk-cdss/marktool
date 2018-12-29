package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface ZlfaModelRepository extends PagingAndSortingRepository<ZlfaModel, Integer>, JpaSpecificationExecutor<ZlfaModel> {
}
