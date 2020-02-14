package com.springboot.chapter4.aspect.service;

import com.springboot.chapter4.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:51
 */
public interface UserService {
    void printUser(User user);

    void manyAspects();
}
