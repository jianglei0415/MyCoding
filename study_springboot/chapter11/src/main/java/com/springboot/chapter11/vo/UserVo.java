package com.springboot.chapter11.vo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:24
 */
@Data
public class UserVo {
    private Long id;
    private int sexCode;
    private String userName;
    private String sexName;
    private String note;
}
