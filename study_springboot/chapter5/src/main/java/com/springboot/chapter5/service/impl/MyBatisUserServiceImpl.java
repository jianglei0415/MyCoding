package com.springboot.chapter5.service.impl;

import com.springboot.chapter5.dao.MybatisUserDao;
import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:23
 */
@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MybatisUserDao mybatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return mybatisUserDao.getUser(id);
    }
}
