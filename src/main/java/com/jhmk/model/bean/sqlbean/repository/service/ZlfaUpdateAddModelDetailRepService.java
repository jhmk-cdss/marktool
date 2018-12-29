package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaUpdateAddModel;
import com.jhmk.model.bean.sqlbean.repository.ZlfaUpdateAddModelRepository;
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
public class ZlfaUpdateAddModelDetailRepService extends BaseRepService<ZlfaUpdateAddModel, Integer> {
    @Autowired
    ZlfaUpdateAddModelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaUpdateAddModel save(ZlfaUpdateAddModel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaUpdateAddModel> save(List<ZlfaUpdateAddModel> list) {
        Iterable<ZlfaUpdateAddModel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaUpdateAddModel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaUpdateAddModel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaUpdateAddModel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaUpdateAddModel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaUpdateAddModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
