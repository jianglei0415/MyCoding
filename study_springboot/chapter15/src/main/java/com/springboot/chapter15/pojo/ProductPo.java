package com.springboot.chapter15.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author: jianglei
 * @date: 2020/2/2 22:52
 */
@Alias("product")
@Data
public class ProductPo implements Serializable {
    private static final long serialVersionUID = 2415357120603982296L;
    private Long id;
    private String productName;
    private Integer stock;
    private Double price;
    private Integer version;
    private String note;
}
