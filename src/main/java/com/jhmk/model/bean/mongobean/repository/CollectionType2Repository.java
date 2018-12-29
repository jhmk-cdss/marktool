package com.jhmk.model.bean.mongobean.repository;

import com.jhmk.model.bean.mongobean.CollectionType2;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 9:48
 */

public interface CollectionType2Repository extends PagingAndSortingRepository<CollectionType2, String> {
    CollectionType2 findBy_id(String id);

}
