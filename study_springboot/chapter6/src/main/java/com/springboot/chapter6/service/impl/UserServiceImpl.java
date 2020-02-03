package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.dao.UserDao;
import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:36
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1, rollbackFor = RuntimeException.class)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
