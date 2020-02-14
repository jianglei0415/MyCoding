package com.springboot.chapter7.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/1/28 15:34
 */
@Data
@Alias("user")
public class User implements Serializable {
    private static final long serialVersionUID = -6950611710950159019L;
    private Long id;
    private String userName;
    private String note;
}
