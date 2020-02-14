package com.springboot.chapter6.dao;

import com.springboot.chapter6.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:34
 */
@Repository
public interface UserDao {
    User getUser(Long id);

    int insertUser(User user);
}
