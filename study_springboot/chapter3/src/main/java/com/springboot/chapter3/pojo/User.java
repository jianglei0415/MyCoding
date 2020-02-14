package com.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:36
 */
@Data
@Component("user")
public class User {
    @Value("1")
    private Long id;

    @Value("user_name_1")
    private String userName;

    @Value("note_1")
    private String note;
}
