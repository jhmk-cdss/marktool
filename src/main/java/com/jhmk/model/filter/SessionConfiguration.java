//package com.jhmk.model.filter;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @author ziyu.zhou
// * @date 2018/12/7 17:32
// */
//
//@Configuration
//public class SessionConfiguration extends WebMvcConfigurerAdapter
//{
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor((HandlerInterceptor) new OpenSessionInViewFilter()).addPathPatterns("/**");
//    }}
