package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaOrderModel;
import com.jhmk.model.bean.sqlbean.repository.ZlfaOrderModelRepository;
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
public class ZlfaOrderModelRepService extends BaseRepService<ZlfaOrderModel, Integer> {
    @Autowired
    ZlfaOrderModelRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaOrderModel save(ZlfaOrderModel bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaOrderModel> save(List<ZlfaOrderModel> list) {
        Iterable<ZlfaOrderModel> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaOrderModel user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaOrderModel> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaOrderModel findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaOrderModel> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaOrderModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ZlfaOrderModel> findAllByOrderItemName(String orderItemName) {
        return repository.findAllByOrderItemName(orderItemName);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<String> findDistinctByOrderItemName() {
        return repository.findDistinctByOrderItemName();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public long count() {
        return repository.count();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public int updateStandardName(String standardName, String orderItemName) {
        return repository.updateStandardName(standardName, orderItemName);
    }
}
