package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.BiaozhuZhubiao;
import com.jhmk.model.bean.sqlbean.repository.BiaozhuZhubiaoRepository;
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
public class BiaozhuZhubiaoRepService extends BaseRepService<BiaozhuZhubiao, Integer> {
    @Autowired
    BiaozhuZhubiaoRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BiaozhuZhubiao save(BiaozhuZhubiao bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<BiaozhuZhubiao> save(List<BiaozhuZhubiao> list) {
        Iterable<BiaozhuZhubiao> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(BiaozhuZhubiao user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<BiaozhuZhubiao> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public BiaozhuZhubiao findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<BiaozhuZhubiao> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<BiaozhuZhubiao> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
