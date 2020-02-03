package com.springboot.chapter8.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.springboot.chapter8.pojo.User;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 22:10
 */
public interface UserService {
    void saveUser(User user);

    DeleteResult deleteUser(Long id);

    List<User> findUser(String userName,String note,int skip,int limit);

    UpdateResult updateUser(Long id,String userName,String note);

    User getUser(Long id);
}
