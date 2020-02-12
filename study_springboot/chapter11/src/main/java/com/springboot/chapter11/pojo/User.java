package com.springboot.chapter11.pojo;

import com.springboot.chapter11.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:23
 */
@Alias("user")
@Data
public class User {
    private Long id;
    private String userName;
    private String note;
    private SexEnum sex;
}
