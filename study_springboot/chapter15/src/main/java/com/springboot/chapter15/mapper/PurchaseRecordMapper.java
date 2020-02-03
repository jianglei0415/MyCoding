package com.springboot.chapter15.mapper;

import com.springboot.chapter15.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: jianglei
 * @date: 2020/2/2 23:04
 */
@Mapper
public interface PurchaseRecordMapper {
    int insertPurchaseRecord(PurchaseRecordPo pr);
}
