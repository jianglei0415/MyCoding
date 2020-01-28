package com.springboot.chapter7.main;

import com.springboot.chapter7.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: jianglei
 * @date: 2020/1/28 11:50
 */
public class Chapter7Main {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
        redisTemplate.opsForValue().set("key11","value11");
        redisTemplate.opsForHash().put("hash","field","h_value_2");
        redisTemplate.convertAndSend("topic1","啊哈哈");
    }
}
