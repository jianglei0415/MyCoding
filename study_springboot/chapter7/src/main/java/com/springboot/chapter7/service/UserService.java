package com.springboot.chapter7.service;

import com.springboot.chapter7.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 15:54
 */
public interface UserService {
    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);
}
