package com.springboot.chapter12.mapper;

import com.springboot.chapter12.pojo.DatabaseRole;
import com.springboot.chapter12.pojo.DatabaseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/1 14:03
 */
@Mapper
public interface DatabaseMapper {
    DatabaseUser getUserByName(String userName);

    List<DatabaseRole> findRolesByUserName(String userName);
}
