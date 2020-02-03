package com.springboot.chapter13.service.impl;

import com.springboot.chapter13.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: jianglei
 * @date: 2020/2/1 16:48
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void generateReport() {
        System.out.println("报表线程名称：【" + Thread.currentThread().getName() + "】");
    }
}
