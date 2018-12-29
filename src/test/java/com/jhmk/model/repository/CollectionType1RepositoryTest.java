//package com.jhmk.model.repository;
////
////import com.alibaba.fastjson.JSONObject;
////import com.jhmk.model.bean.mongobean.CollectionType1;
////import com.jhmk.model.model.WebPage;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.test.context.junit4.SpringRunner;
////
////import java.util.Iterator;
////import java.util.List;
////import java.util.Optional;
////
/////**
//// * @author ziyu.zhou
//// * @date 2018/12/7 9:50
//// */
////@RunWith(SpringRunner.class)
////@SpringBootTest
////public class CollectionType1RepositoryTest {
////    @Autowired
////    CollectionType1Repository collectionType1Repository;
////
////    @Test
////    public void testFindAll() {
////        Iterable<CollectionType1> all = collectionType1Repository.findAll();
////        Iterator<CollectionType1> iterator = all.iterator();
////    }
////
////    @Test
////    public void testFindOne() {
//////        Optional<CollectionType1> byId = collectionType1Repository.findById("111111");
//////        byId.ifPresent(s -> System.out.println(JSONObject.toJSONString(s)));
////    }
////
////    @Test
////    public void findBy_id() {
////        CollectionType1 by_id = collectionType1Repository.findBy_id("111111");
////        System.out.println(JSONObject.toJSONString(by_id));
////    }
////    @Test
////    public void findAll() {
////        WebPage webPage = new WebPage();
////        Pageable pageable =PageRequest.of(1, webPage.getPageSize());
////        Page<CollectionType1> all = collectionType1Repository.findAll(pageable);
////        long totalElements = all.getTotalElements();
////        int totalPages = all.getTotalPages();
////        List<CollectionType1> content = all.getContent();
////        System.out.println(JSONObject.toJSONString(content));
////    }
////
////
////
////}