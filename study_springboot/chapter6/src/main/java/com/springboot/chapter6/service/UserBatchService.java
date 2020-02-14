package com.springboot.chapter6.service;

import com.springboot.chapter6.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:36
 */
public interface UserBatchService {
    int insertUsers(List<User> userList);
}
