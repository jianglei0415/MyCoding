package com.springboot.chapter13.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author: jianglei
 * @date: 2020/2/1 22:09
 */
@Service
public class ScheduleServiceImpl {
    int count1 = 1;
    int count2 = 1;

    @Scheduled(fixedRate = 1000L)
    @Async
    public void job1() {
        System.out.println("【" + Thread.currentThread().getName() + "】" +
                "【job1】每秒钟执行一次，执行第【" + count1 + "】次");
        count1++;
    }

    @Scheduled(fixedRate = 1000L)
    @Async
    public void job2() {
        System.out.println("【" + Thread.currentThread().getName() + "】" +
                "【job2】每秒钟执行一次，执行第【" + count2 + "】次");
        count2++;
    }
}
