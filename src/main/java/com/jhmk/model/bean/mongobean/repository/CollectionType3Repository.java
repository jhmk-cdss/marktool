package com.jhmk.model.bean.mongobean.repository;

import com.jhmk.model.bean.mongobean.CollectionType3;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 9:48
 */

public interface CollectionType3Repository extends PagingAndSortingRepository<CollectionType3, String> {
    CollectionType3 findBy_id(String id);

}
