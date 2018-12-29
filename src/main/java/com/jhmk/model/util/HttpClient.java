//package com.jhmk.model.util;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.ParseException;
//import org.apache.http.StatusLine;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//
///**
// * @author ziyu.zhou
// * @date 2018/9/15 19:46
// */
//
//public class HttpClient {
//    static Logger logger = LoggerFactory.getLogger(HttpClient.class);
//
//    static final RequestConfig requestConfig = null;
//
//    static {
//        RequestConfig.custom()
//                .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
//                .setSocketTimeout(5000).build();
//    }
//
//    public static String doPost(String Url, String expression) {
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(Url);
//        httpPost.setConfig(requestConfig);
//        CloseableHttpResponse response = null;
//        if (StringUtils.isNotBlank(expression)) {
//            StringEntity entity = new StringEntity(expression, "UTF-8");
//            entity.setContentEncoding("UTF-8");
//            entity.setContentType("application/json");
//            httpPost.setEntity(entity);
//        }
//
//        httpPost.setHeader("content-Type", "application/json;charset=UTF-8");
//        try {
//            response = httpClient.execute(httpPost);
//            StatusLine statusLine = response.getStatusLine();
//            if (statusLine.getStatusCode() == 200) {
//                return EntityUtils.toString(response.getEntity(), "UTF-8");
//            } else {
//                logger.error("数据接口访问异常:" + Url);
//                throw new RuntimeException("啊喔,数据服务出问题了.");
//            }
//        } catch (ParseException | IOException e) {
//            e.printStackTrace();
//            logger.error("httpClient请求超时.");
//            throw new RuntimeException("啊喔,数据服务出问题了.");
//        } finally {
//            if (httpClient != null) {
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
