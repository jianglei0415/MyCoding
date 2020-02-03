package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:37
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {
    @Autowired
    private UserService userService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED, rollbackFor = RuntimeException.class)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for (User user : userList) {
            count += userService.insertUser(user);
        }
        return count;
    }
}
