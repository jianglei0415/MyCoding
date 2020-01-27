package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.HelloService;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:01
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (null == name || name.trim() == "") {
            throw new RuntimeException("parameter is null!!");
        }
        System.out.println("hello " + name);
    }
}
