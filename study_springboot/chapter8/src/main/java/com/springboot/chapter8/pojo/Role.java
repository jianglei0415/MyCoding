package com.springboot.chapter8.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/1/28 22:05
 */
@Document
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -4385761710408507288L;
    private Long id;
    @Field("role_name")
    private String roleName = null;
    private String note = null;
}
