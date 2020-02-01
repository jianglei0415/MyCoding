package com.springboot.chapter12.service;

import com.springboot.chapter12.pojo.DatabaseRole;
import com.springboot.chapter12.pojo.DatabaseUser;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:42
 */
public interface UserRoleService {
    DatabaseUser getUserByName(String userName);

    List<DatabaseRole> findRolesByUserName(String userName);
}
