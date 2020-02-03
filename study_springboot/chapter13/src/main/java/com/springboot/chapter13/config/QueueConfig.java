package com.springboot.chapter13.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jianglei
 * @date: 2020/2/1 22:29
 */
@Configuration
public class QueueConfig {
    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @Bean
    public Queue createQueueMsg() {
        return new Queue(msgQueueName, true);
    }

    @Bean
    public Queue createQueueUser() {
        return new Queue(userQueueName, true);
    }
}
