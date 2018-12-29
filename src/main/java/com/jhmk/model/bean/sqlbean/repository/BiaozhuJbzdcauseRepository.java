package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.BiaozhuJbzdcause;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface BiaozhuJbzdcauseRepository extends PagingAndSortingRepository<BiaozhuJbzdcause, Integer>, JpaSpecificationExecutor<BiaozhuJbzdcause> {
}
