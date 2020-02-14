package com.springboot.chapter12.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author: jianglei
 * @date: 2020/2/1 13:57
 */
@Data
@Alias("databaseRole")
public class DatabaseRole {
    private Long id;
    private String roleName;
    private String note;
}
