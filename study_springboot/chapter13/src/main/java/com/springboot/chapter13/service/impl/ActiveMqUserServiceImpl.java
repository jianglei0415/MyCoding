package com.springboot.chapter13.service.impl;

import com.springboot.chapter13.pojo.User;
import com.springboot.chapter13.service.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: jianglei
 * @date: 2020/2/1 21:12
 */
@Service
public class ActiveMqUserServiceImpl implements ActiveMqUserService {
    @Autowired
    private JmsTemplate jmsTemplate;

    private static final String MY_DESTINATION = "my-destination";

    @Override
    public void sendUser(User user) {
        System.out.println("发送消息【" + user + "】");
        jmsTemplate.convertAndSend(MY_DESTINATION, user);
    }

    @Override
    @JmsListener(destination = MY_DESTINATION)
    public void receiveUser(User user) {
        System.out.println("接收到消息【" + user + "】");
    }
}
