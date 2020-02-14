package com.springboot.chapter4.pojo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:51
 */
@Data
public class User {
    private Long id;
    private String username;
    private String note;
}
