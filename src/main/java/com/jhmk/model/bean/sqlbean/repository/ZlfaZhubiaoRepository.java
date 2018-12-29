package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

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

    List<ZlfaZhubiao> findAllByDischargeMainDiagnosis(String dischargeMainDiagnosis);
}
