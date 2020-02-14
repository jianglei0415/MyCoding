package com.springboot.chapter11.service.impl;

import com.springboot.chapter11.mapper.UserMapper;
import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:28
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
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserName(Long id, String userName) {
        return userMapper.updateUserByIdAndName(id, userName);
    }

    @Override
    public List<User> findUsers(String userName, String note, Integer start, Integer limit) {
        return userMapper.findUsers(userName, note, start, limit);
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}
