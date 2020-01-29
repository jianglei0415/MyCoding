package com.springboot.chapter10.mapper;

import com.springboot.chapter10.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/30 0:30
 */
@Mapper
public interface UserMapper {
    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName, @Param("note") String note);

    int deleteUser(Long id);
}
