package com.springboot.chapter13.rabbit.receiver;

import com.springboot.chapter13.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: jianglei
 * @date: 2020/2/1 22:00
 */
@Component
public class RabbitMessageReceiver {
    @RabbitListener(queues = {"${rabbitmq.queue.msg}"})
    public void receiveMsg(String msg) {
        System.out.println("收到消息：【" + msg + "】");
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveUser(User user) {
        System.out.println("收到用户信息【" + user + "】");
    }
}
