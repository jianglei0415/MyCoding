package com.springboot.chapter9.pojo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/1/29 13:57
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String note;
}
