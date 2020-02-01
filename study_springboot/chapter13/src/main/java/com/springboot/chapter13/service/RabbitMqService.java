package com.springboot.chapter13.service;

import com.springboot.chapter13.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/2/1 21:53
 */
public interface RabbitMqService {
    void sendMsg(String msg);

    void sendUser(User user);
}
