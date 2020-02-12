package com.springboot.chapter7.mapper;

import com.springboot.chapter7.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 15:38
 */
@Repository
public interface UserMapper {
    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName, @Param("note") String note);

    int deleteUser(Long id);
}
