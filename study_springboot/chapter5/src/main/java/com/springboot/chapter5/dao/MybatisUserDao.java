package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:19
 */
@Repository
public interface MybatisUserDao {
    User getUser(Long id);
}
