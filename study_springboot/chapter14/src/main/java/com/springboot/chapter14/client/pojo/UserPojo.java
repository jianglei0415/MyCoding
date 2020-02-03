package com.springboot.chapter14.client.pojo;

import lombok.Data;

/**
 * @author: jianglei
 * @date: 2020/2/2 20:56
 */
@Data
public class UserPojo {
    private Long id;
    private String userName;
    private int sex = 1;
    private String note;
}
