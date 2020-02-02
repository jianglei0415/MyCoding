package com.springboot.chapter15.service.impl;

import com.springboot.chapter15.mapper.ProductMapper;
import com.springboot.chapter15.mapper.PurchaseRecordMapper;
import com.springboot.chapter15.pojo.ProductPo;
import com.springboot.chapter15.pojo.PurchaseRecordPo;
import com.springboot.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/2/2 23:09
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    String purchaseScript = "redis.call('sadd',KEYS[1],ARGV[2]) \n" +
            "local productPurchaseList = KEYS[2]..ARGV[2] \n" +
            "local userId = ARGV[1] \n" +
            "local product = 'product_'..ARGV[2] \n" +
            "local quantity = tonumber(ARGV[3]) \n" +
            "local stock = tonumber(redis.call('hget',product,'stock')) \n" +
            "local price = tonumber(redis.call('hget',product,'price')) \n" +
            "local purchase_date = ARGV[4] \n" +
            "if stock < quantity then return 0 end \n" +
            "stock = stock - quantity \n" +
            "redis.call('hset',product,'stock',tostring(stock)) \n" +
            "local sum = price * quantity \n" +
            "local purchaseRecord = userId..','..quantity..','" +
            "..sum..','..price..','..purchase_date \n" +
            "redis.call('rpush',productPurchaseList,purchaseRecord) \n" +
            "return 1 \n";

    private static final String PURCHASE_PRODUCT_LIST = "purchase_list_";
    private static final String PRODUCT_SCHEDULE_SET = "product_schedule_set";
    private String sha1;

    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = RuntimeException.class)
    public boolean purchase(Long userId, Long productId, int quantity) {
        for (int i = 0; i < 3; i++) {
            ProductPo product = productMapper.getProduct(productId);
            if (product.getStock() < quantity) {
                return false;
            }
            int version = product.getVersion();
            int result = productMapper.decreaseProduct(productId, quantity, version);
            if (result == 0) {
                continue;
            }
            PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
            purchaseRecordMapper.insertPurchaseRecord(pr);
            return true;
        }
        return false;
    }

    @Override
    public boolean purchaseRedis(Long userId, Long productId, int quantity) {
        Long purchaseDate = System.currentTimeMillis();
        Jedis jedis = null;
        try {
            jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
            if (sha1 == null) {
                sha1 = jedis.scriptLoad(purchaseScript);
            }
            Object res = jedis.evalsha(sha1, 2, PRODUCT_SCHEDULE_SET,
                    PURCHASE_PRODUCT_LIST,
                    userId + "", productId + "",
                    quantity + "", purchaseDate + "");
            Long result = (Long) res;
            return result == 1;
        } finally {
            if (jedis != null && jedis.isConnected()) {
                jedis.close();
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = RuntimeException.class)
    public boolean dealRedisPurchase(List<PurchaseRecordPo> prpList) {
        for (PurchaseRecordPo prp : prpList) {
            purchaseRecordMapper.insertPurchaseRecord(prp);
            productMapper.decreaseProduct(prp.getProductId(), prp.getQuantity());
        }
        return true;
    }
}
