package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.BiaozhuJbzdcause;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuJbzdcauseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/12 10:34
 */

@Service
public class BiaozhuJbzdcauseRepService extends BaseRepService<BiaozhuJbzdcause, Integer> {
    @Autowired
    BiaozhuJbzdcauseRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BiaozhuJbzdcause save(BiaozhuJbzdcause bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<BiaozhuJbzdcause> save(List<BiaozhuJbzdcause> list) {
        Iterable<BiaozhuJbzdcause> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(BiaozhuJbzdcause user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<BiaozhuJbzdcause> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public BiaozhuJbzdcause findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<BiaozhuJbzdcause> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<BiaozhuJbzdcause> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
