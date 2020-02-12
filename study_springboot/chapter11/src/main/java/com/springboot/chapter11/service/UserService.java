package com.springboot.chapter11.service;

import com.springboot.chapter11.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:28
 */
public interface UserService {
    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    int updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note,Integer start,Integer limit);

    int deleteUser(Long id);
}
