package com.springboot.chapter12.service.impl;

import com.springboot.chapter12.mapper.DatabaseMapper;
import com.springboot.chapter12.pojo.DatabaseRole;
import com.springboot.chapter12.pojo.DatabaseUser;
import com.springboot.chapter12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:42
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private DatabaseMapper databaseMapper;

    @Override
    public DatabaseUser getUserByName(String userName) {
        return databaseMapper.getUserByName(userName);
    }

    @Override
    public List<DatabaseRole> findRolesByUserName(String userName) {
        return databaseMapper.findRolesByUserName(userName);
    }
}
