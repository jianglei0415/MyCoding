package com.springboot.chapter5.pojo;

import com.springboot.chapter5.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:11
 */
@Data
@Alias(value = "user")
public class User {
    private Long id = null;
    private String userName = null;
    private SexEnum sex = null;
    private String note = null;
}
