package com.jhmk.model.bean.mongobean.repository;

import com.jhmk.model.bean.mongobean.CollectionType1;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 9:48
 */

public interface CollectionType1Repository extends PagingAndSortingRepository<CollectionType1, String> {
    CollectionType1 findBy_id(String id);
}
