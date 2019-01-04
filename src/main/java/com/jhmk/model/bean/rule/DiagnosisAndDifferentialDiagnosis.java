package com.jhmk.model.bean.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziyu.zhou
 * @date 2019/1/3 11:12
 * 诊断与鉴别诊断
 */

public class DiagnosisAndDifferentialDiagnosis {
    private String src;
    private List<FirstCourseDifferentialDiagnosis> firstCourseDifferentialDiagnosisList = new ArrayList<>();//鉴别依据-患者特点'

    public String getSrc() {
        return src;
    }

    public void setSrc(final String src) {
        this.src = src;
    }

    public List<FirstCourseDifferentialDiagnosis> getFirstCourseDifferentialDiagnosisList() {
        return firstCourseDifferentialDiagnosisList;
    }

    public void setFirstCourseDifferentialDiagnosisList(final List<FirstCourseDifferentialDiagnosis> firstCourseDifferentialDiagnosisList) {
        this.firstCourseDifferentialDiagnosisList = firstCourseDifferentialDiagnosisList;
    }
}
