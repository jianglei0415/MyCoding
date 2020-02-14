package com.springboot.chapter6.service;

import com.springboot.chapter6.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:34
 */
public interface JdbcService {
    User getUser(Long id);

    List<User> findUser(String userName, String note);

    int insertUser(String userName, String note);

    int updateUser(User user);

    int deleteUser(Long id);
}
