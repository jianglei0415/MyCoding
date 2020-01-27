package com.springboot.chapter5.service;

import com.springboot.chapter5.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:23
 */
public interface MyBatisUserService {
    User getUser(Long id);
}
