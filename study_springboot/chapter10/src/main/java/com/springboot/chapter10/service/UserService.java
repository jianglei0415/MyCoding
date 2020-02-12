package com.springboot.chapter10.service;

import com.springboot.chapter10.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/30 0:32
 */
public interface UserService {
    User getUser(Long id);

    int insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);
}
