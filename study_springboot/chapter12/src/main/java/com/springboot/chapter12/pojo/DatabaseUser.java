package com.springboot.chapter12.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:44
 */
@Data
@Alias("databaseUser")
public class DatabaseUser {
    private Long id;
    private String userName;
    private String pwd;
    private Integer available;
    private String note;
}
