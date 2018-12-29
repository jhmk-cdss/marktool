//package com.jhmk.model;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.jpa.HibernateEntityManagerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.support.SharedEntityManagerBean;
//
//
///**
// * @author ziyu.zhou
// * @date 2018/12/7 17:38
// */
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager",
//        basePackages = {"com.jhmk"},
//        enableDefaultTransactions = false)
//@Configuration
//public class Config {
////    @Bean
////    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
////        return hemf.getSessionFactory();
////    }
//
////    @Bean
////    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
////        return hemf.getSessionFactory();
////    }
////
////    @Bean
////    public SharedEntityManagerBean sharedEntityManagerBean() {
////        return  new SharedEntityManagerBean();
////    }
//
//}
