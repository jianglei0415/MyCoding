package com.springboot.chapter9.service;

import com.springboot.chapter9.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/29 13:56
 */
public interface UserService {
    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);
}
