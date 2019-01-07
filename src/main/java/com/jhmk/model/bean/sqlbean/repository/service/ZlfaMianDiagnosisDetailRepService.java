package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.repository.ZlfaMianDiagnosisDetailRepository;
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
public class ZlfaMianDiagnosisDetailRepService extends BaseRepService<ZlfaMianDiagnosisDetail, Integer> {
    @Autowired
    ZlfaMianDiagnosisDetailRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaMianDiagnosisDetail save(ZlfaMianDiagnosisDetail bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaMianDiagnosisDetail> save(List<ZlfaMianDiagnosisDetail> list) {
        Iterable<ZlfaMianDiagnosisDetail> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaMianDiagnosisDetail user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaMianDiagnosisDetail> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaMianDiagnosisDetail findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaMianDiagnosisDetail> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaMianDiagnosisDetail> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ZlfaMianDiagnosisDetail> findAllByMedicineTreatmentIsNull() {
        return repository.findAllByMedicineTreatmentIsNull();
    }


}
