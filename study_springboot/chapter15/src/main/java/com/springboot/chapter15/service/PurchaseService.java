package com.springboot.chapter15.service;

import com.springboot.chapter15.pojo.PurchaseRecordPo;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/2 23:08
 */
public interface PurchaseService {
    boolean purchase(Long userId, Long productId, int quantity);

    boolean purchaseRedis(Long userId, Long productId, int quantity);

    boolean dealRedisPurchase(List<PurchaseRecordPo> prpList);
}
