package com.jhmk.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ziyu.zhou
 * @date 2018/12/10 15:00
 */
@Component
@ConfigurationProperties()
@PropertySource(value = "classpath:urlConfig.yml")
public class UrlPropertiesConfig {

    private String cdssurl;
    private String pageurl;
    private String participleurl;
    private String earlywarnurl;
    private String pagetesturl;
    private String testToolUrl;

    public String getCdssurl() {
        return cdssurl;
    }

    public void setCdssurl(String cdssurl) {
        this.cdssurl = cdssurl;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    public String getParticipleurl() {
        return participleurl;
    }

    public void setParticipleurl(String participleurl) {
        this.participleurl = participleurl;
    }

    public String getEarlywarnurl() {
        return earlywarnurl;
    }

    public void setEarlywarnurl(String earlywarnurl) {
        this.earlywarnurl = earlywarnurl;
    }

    public String getPagetesturl() {
        return pagetesturl;
    }

    public void setPagetesturl(String pagetesturl) {
        this.pagetesturl = pagetesturl;
    }

    public String getTestToolUrl() {
        return testToolUrl;
    }

    public void setTestToolUrl(String testToolUrl) {
        this.testToolUrl = testToolUrl;
    }
}
