package com.springboot.chapter11.mapper;

import com.springboot.chapter11.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:29
 */
@Mapper
public interface UserMapper {
    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    int updateUserByIdAndName(@Param("id") Long id,
                              @Param("userName") String userName);

    List<User> findUsers(@Param("userName") String userName,
                         @Param("note") String note,
                         @Param("start") int start,
                         @Param("limit") int limit);

    int deleteUser(Long id);
}
