package com.springboot.chapter7.service.impl;

import com.springboot.chapter7.mapper.UserMapper;
import com.springboot.chapter7.pojo.User;
import com.springboot.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 15:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "#result!='null'", key = "'redis_user_'+#id")
    public User updateUserName(Long id, String userName) {
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setUserName(userName);
        userMapper.updateUser(user);
        return user;
    }

    @Override
    @Transactional
    public List<User> findUsers(String userName, String note) {
        return userMapper.findUsers(userName, note);
    }

    @Override
    @Transactional
    @CacheEvict(value = "redisCache", key = "'redis_user_'+#id")
    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }
}
