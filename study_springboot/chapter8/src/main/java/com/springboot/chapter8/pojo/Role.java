package com.springboot.chapter8.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/1/28 22:05
 */
@Document
@ToString
public class Role implements Serializable {
    private static final long serialVersionUID = -4385761710408507288L;

    @Getter
    @Setter
    private Long id;

    @Field("role_name")
    @Getter
    @Setter
    private String roleName;

    @Getter
    @Setter
    private String note = null;
}
