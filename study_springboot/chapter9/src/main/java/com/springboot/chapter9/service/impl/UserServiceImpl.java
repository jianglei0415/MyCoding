package com.springboot.chapter9.service.impl;

import com.springboot.chapter9.mapper.UserMapper;
import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/29 13:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public User insertUser(User user) {
        return null;
    }

    @Override
    public User updateUserName(Long id, String userName) {
        return null;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return userMapper.findUsers(userName, note);
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}
