package com.springboot.chapter13.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/2/1 21:01
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2659792130462735136L;
    private Long id;
    private String userName;
    private String note;

    public User(Long id, String userName, String note) {
        this.id = id;
        this.userName = userName;
        this.note = note;
    }
}
