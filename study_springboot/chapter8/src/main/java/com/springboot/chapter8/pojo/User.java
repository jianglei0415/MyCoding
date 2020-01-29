package com.springboot.chapter8.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -1777455600461989259L;

    @Id
    @Getter
    @Setter
    private Long id;

    @Field("user_name")
    @Setter
    @Getter
    private String userName;

    @Getter
    @Setter
    private String note;

    @Getter
    @Setter
    private List<Role> roles=null;
}
