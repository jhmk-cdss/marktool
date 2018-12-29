package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaModel;
import com.jhmk.model.bean.sqlbean.repository.ZlfaModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/14 17:15
 */
@Service
public class ZlfaModelRepService extends BaseRepService<ZlfaModel, Integer> {
    @Autowired
    ZlfaModelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaModel save(ZlfaModel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaModel> save(List<ZlfaModel> list) {
        Iterable<ZlfaModel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaModel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaModel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaModel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaModel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
