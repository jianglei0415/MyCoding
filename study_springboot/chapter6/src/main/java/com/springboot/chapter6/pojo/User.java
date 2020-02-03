package com.springboot.chapter6.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:33
 */
@Data
@Alias(value = "user")
public class User {
    private Long id = null;
    private String userName = null;
    private String note = null;
}
