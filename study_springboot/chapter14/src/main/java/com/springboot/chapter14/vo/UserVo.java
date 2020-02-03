package com.springboot.chapter14.vo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/2/2 14:41
 */
@Data
public class UserVo {
    private Long id;
    private String userName;
    private int sexCode;
    private String sexName;
    private String note;
}
