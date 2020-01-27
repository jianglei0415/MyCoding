package com.springboot.chapter5.service;

import com.springboot.chapter5.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:22
 */
public interface JdbcTmplUserService {
    User getUser(Long id);

    List<User> findUser(String userName, String note);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
