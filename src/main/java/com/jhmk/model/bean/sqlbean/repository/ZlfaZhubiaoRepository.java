package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface ZlfaZhubiaoRepository extends JpaRepository<ZlfaZhubiao, Integer>, PagingAndSortingRepository<ZlfaZhubiao, Integer>, JpaSpecificationExecutor<ZlfaZhubiao> {
    /**
     * 获取所有治疗方案疾病名 去重
     *
     * @return
     */
    @Query("select distinct (z.dischargeMainDiagnosis) from ZlfaZhubiao z ")
    List<String> getDistinctDischargeMainDiagnosis();

    @Query("select z.id from ZlfaZhubiao z where z.id>?1")
    List<Integer> getGtIdList(Integer id);


    List<ZlfaZhubiao> findAllByDischargeMainDiagnosis(String dischargeMainDiagnosis);

    ZlfaZhubiao findFirstByPatientIdAndVisitId(String patientId, String visitId);

    List<ZlfaZhubiao> findByPatientIdAndVisitId(String patientId, String visitId);

    @Modifying
    @Transactional
    @Query("delete from ZlfaZhubiao z where z.id>?1")
    void deleteGtById(Integer id);

    /**
     * 查询重复项
     *
     * @param
     * @return
     */
    @Query("select count(z), z.patientId,z.visitId from ZlfaZhubiao z group by z.patientId,z.visitId having count (z) >1")
    List<Object> getMapGt2Count();



}
