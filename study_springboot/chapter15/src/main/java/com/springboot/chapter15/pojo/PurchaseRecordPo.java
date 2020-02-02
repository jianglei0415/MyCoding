package com.springboot.chapter15.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: jianglei
 * @date: 2020/2/2 22:53
 */
@Alias("purchaseRecord")
@Data
public class PurchaseRecordPo implements Serializable {
    private static final long serialVersionUID = -7488119055486483060L;
    private Long id;
    private Long userId;
    private Long productId;
    private Double price;
    private Integer quantity;
    private Double sum;
    private Timestamp purchaseTime;
    private String note;
}
