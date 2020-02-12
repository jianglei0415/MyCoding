package com.springboot.chapter10.service.impl;

import com.springboot.chapter10.mapper.UserMapper;
import com.springboot.chapter10.pojo.User;
import com.springboot.chapter10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/30 0:32
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
    public int insertUser(User user) {
        return userMapper.insertUser(user);
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
