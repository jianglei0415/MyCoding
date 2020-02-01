package com.springboot.chapter13.service;

/**
 * @author: jianglei
 * @date: 2020/2/1 20:55
 */
public interface ActiveMqService {
    void sendMsg(String message);

    void receiveMsg(String message);
}
