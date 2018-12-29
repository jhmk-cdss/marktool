package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.BiaozhuJbzdmodel;
import com.jhmk.model.bean.sqlbean.BiaozhuJbzdmodel;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuJbzdmodelRepository;
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
public class BiaozhuJbzdmodelRepService extends BaseRepService<BiaozhuJbzdmodel,Integer> {
    @Autowired
    BiaozhuJbzdmodelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BiaozhuJbzdmodel save(BiaozhuJbzdmodel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<BiaozhuJbzdmodel> save(List<BiaozhuJbzdmodel> list) {
        Iterable<BiaozhuJbzdmodel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(BiaozhuJbzdmodel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<BiaozhuJbzdmodel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public BiaozhuJbzdmodel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<BiaozhuJbzdmodel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<BiaozhuJbzdmodel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
