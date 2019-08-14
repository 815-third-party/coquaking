//package com.codesquad.coquaking.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Archive {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Category category;
//    private User first;
//    private User second;
//    private User third;
//
//    public Archive() {
//    }
//
//    public Archive(Category category, User first, User second, User third) {
//        this.category = category;
//        this.first = first;
//        this.second = second;
//        this.third = third;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public User getFirst() {
//        return first;
//    }
//
//    public User getSecond() {
//        return second;
//    }
//
//    public User getThird() {
//        return third;
//    }
//}
