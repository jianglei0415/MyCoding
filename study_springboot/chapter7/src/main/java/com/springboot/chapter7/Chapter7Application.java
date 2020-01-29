package com.springboot.chapter7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.Duration;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter7")
@MapperScan(basePackages = "com.springboot.chapter7.mapper", annotationClass = Repository.class)
@EnableCaching
public class Chapter7Application {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private MessageListener redisMsgListener;

    private ThreadPoolTaskScheduler taskScheduler;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (taskScheduler != null) {
            return taskScheduler;
        }
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());
        Topic topic = new ChannelTopic("topic1");
        container.addMessageListener(redisMsgListener, topic);
        return container;
    }

//    /**
//     * 自定义缓存管理器
//     * @return
//     */
//    @Bean("redisCacheManager")
//    public RedisCacheManager initRedisCacheManager() {
//        RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
//        config = config.disableKeyPrefix();
//        config = config.entryTtl(Duration.ofMinutes(1));
//        RedisCacheManager redisCacheManager = new RedisCacheManager(writer, config);
//        return redisCacheManager;
//    }

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter7Application.class, args);
    }

}
