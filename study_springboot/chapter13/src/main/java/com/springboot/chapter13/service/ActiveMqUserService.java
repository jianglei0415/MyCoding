package com.springboot.chapter13.service;

import com.springboot.chapter13.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/2/1 21:11
 */
public interface ActiveMqUserService {
    void sendUser(User user);

    void receiveUser(User user);
}
