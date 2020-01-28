package com.springboot.chapter7.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author: jianglei
 * @date: 2020/1/28 14:03
 */
@Slf4j
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        String body = new String(message.getBody());
        log.info("RedisMessageListener body: {}", body);
        String topic = new String(bytes);
        log.info("RedisMessageListener topic: {}", topic);
        String channel = new String(message.getChannel());
        log.info("RedisMessageListener channel: {}", channel);
    }
}
