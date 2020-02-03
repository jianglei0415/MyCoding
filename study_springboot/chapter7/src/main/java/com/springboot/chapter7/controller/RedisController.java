package com.springboot.chapter7.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author: jianglei
 * @date: 2020/1/28 12:13
 */
@Slf4j
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 1);
        Jedis jedis = (Jedis) stringRedisTemplate.
                getConnectionFactory().
                getConnection().
                getNativeConnection();
        Long decr = jedis.decr("int");
        log.info("StringAndHash decr: {}", decr);

        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1", "field2");
        hashOps.put("field4", "value5");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> testList() {
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");
        BoundListOperations<String, String> listOps =
                stringRedisTemplate.boundListOps("list2");
        String result1 = listOps.rightPop();
        log.info("List result1: {}", result1);
        String result2 = listOps.index(1);
        log.info("List result2: {}", result2);
        listOps.leftPush("v0");
        Long size = listOps.size();
        log.info("List size: {}", size);
        List<String> elements = listOps.range(0, size - 2);
        log.info("List elements: {}");
        System.out.println(elements);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @ResponseBody
    @RequestMapping("/set")
    public Map<String, Object> testSet() {
        stringRedisTemplate.opsForSet().add("set1", "v1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v6", "v8");
        BoundSetOperations<String, String> setOps =
                stringRedisTemplate.boundSetOps("set1");
        setOps.add("v6", "v7");
        setOps.remove("v1", "v7");
        Set<String> set1 = setOps.members();
        log.info("Set set1: {}", set1);

        Long size = setOps.size();
        log.info("Set size: {}", size);

        //求交集
        Set<String> inter = setOps.intersect("set2");
        log.info("Set inter: {}", inter);
        //求交集，并用新集合inter保存
        setOps.intersectAndStore("set2", "inter");

        //求差集
        Set<String> diff = setOps.diff("set2");
        log.info("Set diff: {}", diff);
        //求差集，并用新集合diff保存
        setOps.diffAndStore("set2", "diff");

        //求并集
        Set<String> union = setOps.union("set2");
        log.info("Set union: {}", union);
        //求并集，并用新集合union保存
        setOps.unionAndStore("set2", "union");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> testZset() {
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            double score = i * 0.1;
            ZSetOperations.TypedTuple<String> typedTuple =
                    new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }
        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
        BoundZSetOperations<String, String> zSetOps =
                stringRedisTemplate.boundZSetOps("zset1");
        zSetOps.add("value10", 0.26);
        Set<String> setRange = zSetOps.range(1, 6);
        log.info("Zset setRange: {}", setRange);

        //按分数获取有序集合
        Set<String> setScore = zSetOps.rangeByScore(0.2, 0.6);
        log.info("Zset setScore: {}", setScore);

        //定义值范围
        RedisZSetCommands.Range range = new RedisZSetCommands.Range();
        //大于
        range.gt("value3");
        //大于等于
        //range.gte("value3");
        //小于
        //range.lt("value3");
        //小于等于
        range.lte("value8");

        //按值排序，按字符串排序
        Set<String> setLex = zSetOps.rangeByLex(range);
        log.info("Zset setLex: {}", setLex);

        zSetOps.remove("value9", "value2");
        Double score = zSetOps.score("value8");
        log.info("Zset score: {}", score);

        //按下标区间排序
        Set<ZSetOperations.TypedTuple<String>> rangeSet =
                zSetOps.rangeWithScores(1, 6);
        log.info("Zset rangeSet: {}", rangeSet);

        //按分数区间排序
        Set<ZSetOperations.TypedTuple<String>> scoreSet =
                zSetOps.rangeByScoreWithScores(1, 6);
        log.info("Zset scoreSet: {}", scoreSet);

        //按从大到小排序
        Set<String> reverseSet = zSetOps.reverseRange(2, 8);
        log.info("Zset reverseSet: {}", reverseSet);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

//    @ResponseBody
//    @RequestMapping("/multi")
//    public Map<String, Object> testMulti() {
//        redisTemplate.opsForValue().set("key1", "value1");
//        List list = (List) redisTemplate.execute((RedisOperations operations) -> {
//            operations.watch("key1");
//            operations.multi();
//            operations.opsForValue().set("key2", "value2");
//            Object value2 = operations.opsForValue().get("key2");
//            log.info("命令在队列，所以value为null【{}】", value2);
//
//            operations.opsForValue().set("key3", "value3");
//            Object value3 = operations.opsForValue().get("key3");
//            log.info("命令在队列，所以value为null【{}】", value3);
//
//            return operations.exec();
//        });
//
//        log.info("multi list: {}", list);
//        Map<String, Object> map = new HashMap<>();
//        map.put("success", true);
//        return map;
//    }

//    @RequestMapping("/pipeline")
//    @ResponseBody
//    public Map<String, Object> testPipeline() {
//        long start = System.currentTimeMillis();
//        List list = (List) redisTemplate.executePipelined((RedisOperations operations) -> {
//            for (int i = 1; i <= 100000; i++) {
//                operations.opsForValue().set("pipeline_" + i, "value_" + i);
//                String value = (String) operations.opsForValue().get("pipeline_" + i);
//                if (i == 100000) {
//                    System.out.println("命令只是进入队列，所以值为空【" + value + "】");
//                }
//            }
//            return null;
//        });
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start) + "毫秒");
//        Map<String, Object> map = new HashMap<>();
//        map.put("sueccess", true);
//        return map;
//    }

    @ResponseBody
    @RequestMapping("/lua")
    public Map<String, Object> testLua() {
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        rs.setScriptText("return 'Hello Redis'");
        rs.setResultType(String.class);
        RedisSerializer stringSerializer =
                redisTemplate.getStringSerializer();
        String str =
                (String) redisTemplate.execute(rs, stringSerializer, stringSerializer, null);
        Map<String, Object> map = new HashMap<>();
        map.put("str", str);
        return map;
    }

    @RequestMapping("/lua2")
    @ResponseBody
    public Map<String, Object> testLua2(String key1, String key2, String value1, String value2) {
        String lua = "redis.call('set',KEYS[1],ARGV[1]) \n" +
                "redis.call('set',KEYS[2],ARGV[2]) \n" +
                "local str1=redis.call('get',KEYS[1]) \n" +
                "local str2=redis.call('get',KEYS[2]) \n" +
                "if str1==str2 then \n" +
                "return 1 \n" +
                "end \n" +
                "return 0 \n";
        System.out.println(lua);
        DefaultRedisScript<Long> rs = new DefaultRedisScript<>();
        rs.setScriptText(lua);
        rs.setResultType(Long.class);
        RedisSerializer<String> stringRedisSerializer =
                redisTemplate.getStringSerializer();
        List<String> keyList = new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);
        Long result =
                (Long) redisTemplate.execute(rs, stringRedisSerializer, stringRedisSerializer, keyList, value1, value2);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return map;
    }
}
