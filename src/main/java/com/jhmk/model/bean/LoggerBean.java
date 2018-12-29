package com.jhmk.model.bean;

/**
 * @author ziyu.zhou
 * @date 2018/12/18 17:49
 */

public class LoggerBean {
    //请求地址
    private String uri;
    //请求参数
    private String params;
    //
    private String ip;
    private Long startTime;
    //请求时长
    private Long requestTime;
    //响应
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }


    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

//    @Override
//    public String toString() {
//        return "LoggerBean{" +
//                "startDate='" + startDate + '\'' +
//                ", requestTime=" + requestTime +
//                ", uri='" + uri + '\'' +
//                ", ip='" + ip + '\'' +
//                ", params='" + params + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "AOP日志信息{" +
                "requestTime=" + requestTime +
                ", uri='" + uri + '\'' +
                ", params='" + params + '\'' +
                ", ip='" + ip + '\'' +
                ", startTime=" + startTime +
                ", result='" + result + '\'' +
                '}';
    }
}
