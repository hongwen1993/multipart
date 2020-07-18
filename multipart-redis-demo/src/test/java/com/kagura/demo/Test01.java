package com.kagura.demo;

import com.kagura.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/7/18 19:15
 * @since 1.0.0
 */
public class Test01 extends BaseTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test01() {
        redisTemplate.opsForValue().set("charge", "123456");
        Object charge = redisTemplate.opsForValue().get("charge");
        System.out.println(charge);
    }



}
