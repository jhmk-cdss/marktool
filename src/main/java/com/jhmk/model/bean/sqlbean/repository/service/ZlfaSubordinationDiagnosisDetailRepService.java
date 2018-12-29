package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaSubordinationDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.repository.ZlfaSubordinationDiagnosisDetailRepository;
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
public class ZlfaSubordinationDiagnosisDetailRepService extends BaseRepService<ZlfaSubordinationDiagnosisDetail, Integer> {
    @Autowired
    ZlfaSubordinationDiagnosisDetailRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaSubordinationDiagnosisDetail save(ZlfaSubordinationDiagnosisDetail bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaSubordinationDiagnosisDetail> save(List<ZlfaSubordinationDiagnosisDetail> list) {
        Iterable<ZlfaSubordinationDiagnosisDetail> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaSubordinationDiagnosisDetail user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaSubordinationDiagnosisDetail> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaSubordinationDiagnosisDetail findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaSubordinationDiagnosisDetail> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaSubordinationDiagnosisDetail> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
