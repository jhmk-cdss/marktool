package com.jhmk.model.bean.sqlbean.repository;

import com.jhmk.model.bean.sqlbean.ZlfaMianDiagnosisDetail;
import com.jhmk.model.bean.sqlbean.ZlfaZhubiao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2018/12/7 16:11
 */

public interface ZlfaMianDiagnosisDetailRepository extends PagingAndSortingRepository<ZlfaMianDiagnosisDetail, Integer>, JpaSpecificationExecutor<ZlfaMianDiagnosisDetail> {
//        @Query("select  d from ZlfaMianDiagnosisDetail d where d.medicineTreatment !='手术治疗' and ")
//    List<ZlfaMianDiagnosisDetail> getZlfaMianDiagnosisDetail();
}
