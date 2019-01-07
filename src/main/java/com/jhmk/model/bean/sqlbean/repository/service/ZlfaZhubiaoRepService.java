package com.jhmk.model.bean.sqlbean.repository.service;

import com.jhmk.model.base.BaseRepService;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import com.jhmk.model.bean.sqlbean.repository.ZlfaUpdateDeleteModelRepository;
import com.jhmk.model.bean.sqlbean.repository.ZlfaZhubiaoRepository;
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
public class ZlfaZhubiaoRepService extends BaseRepService<ZlfaZhubiao, Integer> {
    @Autowired
    ZlfaZhubiaoRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ZlfaZhubiao save(ZlfaZhubiao bean) {
        return repository.save(bean);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<ZlfaZhubiao> save(List<ZlfaZhubiao> list) {
        Iterable<ZlfaZhubiao> save = repository.save(list);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(ZlfaZhubiao user) {
        repository.delete(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(List<ZlfaZhubiao> list) {
        repository.delete(list);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaZhubiao findOne(Integer id) {
        return repository.findOne(id);
    }


    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Iterable<ZlfaZhubiao> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Page<ZlfaZhubiao> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<String> getDistinctDischargeMainDiagnosis() {
        return repository.getDistinctDischargeMainDiagnosis();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ZlfaZhubiao> findAllByDischargeMainDiagnosis(String name) {
        return repository.findAllByDischargeMainDiagnosis(name);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Integer> getGtIdList(Integer id) {
        return repository.getGtIdList(id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ZlfaZhubiao findFirstByPatientIdAndVisitId(String pid, String vid) {
        return repository.findFirstByPatientIdAndVisitId(pid, vid);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ZlfaZhubiao> findByPatientIdAndVisitId(String pid, String vid) {
        return repository.findByPatientIdAndVisitId(pid, vid);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteGtById(Integer id) {
        repository.deleteGtById(id);
    }


}
