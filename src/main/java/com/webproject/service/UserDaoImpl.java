//package com.webproject.service;
//
//import com.webproject.domain.User;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Shaurav on 4/28/2017.
// */
//public class UserDaoImpl {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @SuppressWarnings("unchecked")
//    public User findByUserName(String username) {
//
//        List<User> users = new ArrayList<User>();
//
//        users = sessionFactory.getCurrentSession()
//                .createQuery("from User where username=?")
//                .setParameter(0, username)
//                .list();
//
//        if (users.size() > 0) {
//            return users.get(0);
//        } else {
//            return null;
//        }
//
//    }
//}
