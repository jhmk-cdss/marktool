package com.jhmk.model.bean.rule;

import java.io.Serializable;

/**
 * @author ziyu.zhou
 * @date 2018/9/25 17:46
 */

public class Ruyuanjilu implements Serializable {
    private String chief_complaint;
    private String history_of_present_illness;
    private String history_of_past_illness;
    private String social_history;
    private String history_of_family_member_diseases;
    private String menstrual_and_obstetrical_histories;
    private String physical_examination;
    private String auxiliary_examination;

    public String getChief_complaint() {
        return chief_complaint;
    }

    public void setChief_complaint(String chief_complaint) {
        this.chief_complaint = chief_complaint;
    }

    public String getHistory_of_present_illness() {
        return history_of_present_illness;
    }

    public void setHistory_of_present_illness(String history_of_present_illness) {
        this.history_of_present_illness = history_of_present_illness;
    }

    public String getHistory_of_past_illness() {
        return history_of_past_illness;
    }

    public void setHistory_of_past_illness(String history_of_past_illness) {
        this.history_of_past_illness = history_of_past_illness;
    }

    public String getSocial_history() {
        return social_history;
    }

    public void setSocial_history(String social_history) {
        this.social_history = social_history;
    }

    public String getHistory_of_family_member_diseases() {
        return history_of_family_member_diseases;
    }

    public void setHistory_of_family_member_diseases(String history_of_family_member_diseases) {
        this.history_of_family_member_diseases = history_of_family_member_diseases;
    }

    public String getMenstrual_and_obstetrical_histories() {
        return menstrual_and_obstetrical_histories;
    }

    public void setMenstrual_and_obstetrical_histories(String menstrual_and_obstetrical_histories) {
        this.menstrual_and_obstetrical_histories = menstrual_and_obstetrical_histories;
    }

    public String getPhysical_examination() {
        return physical_examination;
    }

    public void setPhysical_examination(String physical_examination) {
        this.physical_examination = physical_examination;
    }

    public String getAuxiliary_examination() {
        return auxiliary_examination;
    }

    public void setAuxiliary_examination(String auxiliary_examination) {
        this.auxiliary_examination = auxiliary_examination;
    }
}
