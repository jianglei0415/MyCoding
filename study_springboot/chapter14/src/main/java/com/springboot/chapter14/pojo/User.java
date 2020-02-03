package com.springboot.chapter14.pojo;

import com.springboot.chapter14.enumeration.SexEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/2/2 14:22
 */
@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1014311250160240123L;

    @Id
    private Long id;

    private SexEnum sex;

    @Field("user_name")
    private String userName;

    private String note;
}
