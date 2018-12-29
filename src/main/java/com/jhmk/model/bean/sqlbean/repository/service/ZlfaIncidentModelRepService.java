package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaIncidentModel;
import com.jhmk.model.bean.sqlbean.repository.ZlfaIncidentModelRepository;
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
public class ZlfaIncidentModelRepService extends BaseRepService<ZlfaIncidentModel, Integer> {
    @Autowired
    ZlfaIncidentModelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaIncidentModel save(ZlfaIncidentModel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaIncidentModel> save(List<ZlfaIncidentModel> list) {
        Iterable<ZlfaIncidentModel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaIncidentModel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaIncidentModel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaIncidentModel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaIncidentModel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaIncidentModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
