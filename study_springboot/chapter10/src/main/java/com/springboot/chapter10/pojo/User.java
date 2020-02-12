package com.springboot.chapter10.pojo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/1/30 0:30
 */
@Data
public class User {
    private Long id;
    private String userName;
    private String note;
}