package com.kagura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/7/19
 * @since 1.0.0
 */
@RestController
@RequestMapping(path = "/test")
public class TestController {

    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public TestController(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @ModelAttribute
    public void before() {
        redisTemplate.opsForValue().set("test", "01");
    }






    /**
     * set
     */
    @GetMapping(path = "/01")
    public void test01(String k, String v) {
        // before set
        long a = currentTimeMillis();
        // set k-v
        redisTemplate.opsForValue().set(k, v);
        // after set
        long b = currentTimeMillis();
        // print minus
        System.out.println("set耗时：" + (b - a));

        // before expire
        a = currentTimeMillis();
        // expire k
        redisTemplate.expire(k, 100, TimeUnit.SECONDS);
        // after expire
        b = currentTimeMillis();
        // print minus
        System.out.println("expire耗时：" + (b - a));
    }

    /**
     * setex
     */
    @GetMapping(path = "/02")
    public void test02(String k, String v) {
        // before setex
        long a = currentTimeMillis();
        // setex k-v-ttl
        redisTemplate.opsForValue().set(k, v, 100, TimeUnit.SECONDS);
        // after setex
        long b = currentTimeMillis();
        // print minus
        System.out.println("setex耗时：" + (b - a));
    }



    /**
     * set
     */
    @GetMapping(path = "/03")
    public void test03(String k1, String v1, String k2, String v2) {
        // before set
        long a = currentTimeMillis();
        // set k-v
        redisTemplate.opsForValue().set(k1, v1);
        redisTemplate.opsForValue().set(k2, v2);
        // after set
        long b = currentTimeMillis();
        // print minus
        System.out.println("set耗时：" + (b - a));

    }

    /**
     * mset
     */
    @GetMapping(path = "/04")
    public void test04(String k1, String v1, String k2, String v2) {
        // k-v map
        Map<String, String> userInfo = new HashMap<>(5);
        userInfo.put(k1, v1);
        userInfo.put(k2, v2);
        // before mset
        long a = currentTimeMillis();
        // mset k-v map
        redisTemplate.opsForValue().multiSet(userInfo);
        // after mset
        long b = currentTimeMillis();
        // print minus
        System.out.println("mset耗时：" + (b - a));
    }


    /**
     * no
     */
    @GetMapping(path = "/00")
    public void test00(String k, String v, String k1, String v1, String k2, String v2) {
        // before
        long a = currentTimeMillis();
        // do something
        redisTemplate.opsForValue().set(k, v);
        redisTemplate.expire(k, 100, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(k1, v1);
        redisTemplate.opsForValue().set(k2, v2);
        // after
        long b = currentTimeMillis();
        // print minus
        System.out.println("耗时：" + (b - a));
    }

    /**
     * pip
     */
    @GetMapping(path = "/05")
    public void test05(String k, String v, String k1, String v1, String k2, String v2) {
        // before pip
        long a = currentTimeMillis();
        // pip
        redisTemplate.executePipelined((RedisCallback<?>) connection -> {
            connection.openPipeline();
            connection.setEx(k.getBytes(), 100L, v.getBytes());
            Map<byte[], byte[]> userInfo = new HashMap<>(5);
            userInfo.put(k1.getBytes(), v1.getBytes());
            userInfo.put(k2.getBytes(), v2.getBytes());
            connection.mSet(userInfo);
            return null;
        });
        // after pip
        long b = currentTimeMillis();
        // print minus
        System.out.println("pip耗时：" + (b - a));
    }

}
