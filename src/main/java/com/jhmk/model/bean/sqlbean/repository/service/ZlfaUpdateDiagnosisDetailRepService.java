//package com.jhmk.model.bean.sqlbean.repository.service;
//
//import com.jhmk.model.base.BaseRepService;
//import com.jhmk.model.bean.sqlbean.ZlfaUpdateDiagnosisDetail;
//import com.jhmk.model.bean.sqlbean.repository.ZlfaUpdateDiagnosisDetailRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @author ziyu.zhou
// * @date 2018/12/14 17:15
// */
//@Service
//public class ZlfaUpdateDiagnosisDetailRepService extends BaseRepService<ZlfaUpdateDiagnosisDetail, Integer> {
//    @Autowired
//    ZlfaUpdateDiagnosisDetailRepository repository;
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public ZlfaUpdateDiagnosisDetail save(ZlfaUpdateDiagnosisDetail bean) {
//        return repository.save(bean);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public Iterable<ZlfaUpdateDiagnosisDetail> save(List<ZlfaUpdateDiagnosisDetail> list) {
//        Iterable<ZlfaUpdateDiagnosisDetail> save = repository.save(list);
//        return save;
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void delete(Integer id) {
//        repository.delete(id);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void delete(ZlfaUpdateDiagnosisDetail user) {
//        repository.delete(user);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void delete(List<ZlfaUpdateDiagnosisDetail> list) {
//        repository.delete(list);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public ZlfaUpdateDiagnosisDetail findOne(Integer id) {
//        return repository.findOne(id);
//    }
//
//
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public Iterable<ZlfaUpdateDiagnosisDetail> findAll() {
//        return repository.findAll();
//    }
//
//
//    @Override
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    public Page<ZlfaUpdateDiagnosisDetail> findAll(Pageable pageable) {
//        return repository.findAll(pageable);
//    }
//
//
//}
