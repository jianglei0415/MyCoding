package com.springboot.chapter8.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/28 21:59
 */
@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1777455600461989259L;

    @Id
    private Long id;

    @Field("user_name")
    private String userName=null;
    private String note=null;
    private List<Role> roles=null;
}
