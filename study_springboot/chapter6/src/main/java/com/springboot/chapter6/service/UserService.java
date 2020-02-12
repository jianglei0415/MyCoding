package com.springboot.chapter6.service;

import com.springboot.chapter6.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:35
 */
public interface UserService {
    User getUser(Long id);

    int insertUser(User user);
}
