package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.BiaozhuTzysmodel;
import com.jhmk.model.bean.sqlbean.BiaozhuTzysmodel;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuTzysmodelRepository;
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
public class BiaozhuTzysRepService extends BaseRepService<BiaozhuTzysmodel,Integer> {
    @Autowired
    BiaozhuTzysmodelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BiaozhuTzysmodel save(BiaozhuTzysmodel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<BiaozhuTzysmodel> save(List<BiaozhuTzysmodel> list) {
        Iterable<BiaozhuTzysmodel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(BiaozhuTzysmodel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<BiaozhuTzysmodel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public BiaozhuTzysmodel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<BiaozhuTzysmodel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<BiaozhuTzysmodel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}

