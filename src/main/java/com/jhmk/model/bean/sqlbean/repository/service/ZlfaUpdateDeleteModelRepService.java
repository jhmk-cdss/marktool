package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaUpdateDeleteModel;
import com.jhmk.model.bean.sqlbean.repository.ZlfaUpdateDeleteModelRepository;
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
public class ZlfaUpdateDeleteModelRepService extends BaseRepService<ZlfaUpdateDeleteModel, Integer> {
    @Autowired
    ZlfaUpdateDeleteModelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaUpdateDeleteModel save(ZlfaUpdateDeleteModel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaUpdateDeleteModel> save(List<ZlfaUpdateDeleteModel> list) {
        Iterable<ZlfaUpdateDeleteModel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaUpdateDeleteModel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaUpdateDeleteModel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaUpdateDeleteModel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaUpdateDeleteModel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaUpdateDeleteModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
