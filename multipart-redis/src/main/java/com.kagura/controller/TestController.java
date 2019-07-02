package com.kagura.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping(path = "/01")
    public Object test01() throws Exception {

        //performanceService.createAllEmptyRecord();
        //performanceService.start(0);


        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.watch("hyh");
        int n = (int) redisTemplate.opsForValue().get("hyh");
        if (n < 20) {
            System.out.println("n1 : " + n);
            redisTemplate.multi();
            n = n + 1;
            System.out.println("n2 : " + n);
            redisTemplate.opsForValue().set("hyh", n);
            List<Object> list = redisTemplate.exec();
            System.out.println("n3 : " + n);
            System.out.println(list!=null && !list.isEmpty());
        }

        //redisTemplate.multi();
        //int n = (int) redisTemplate.opsForValue().get("hyh");
        //System.out.println("before : " + n);
        //n = n + 1;
        //redisTemplate.opsForValue().set("hyh", n);
        //redisTemplate.opsForValue().increment("hyh", 1);
        //System.out.println("after : " + n);
        //redisTemplate.exec();


        return 0;
    }


    @GetMapping(path = "/02")
    public Object test02() {
        //performanceService.rank("2019-07");
        redisTemplate.opsForValue().set("hyh", 1L);

        Queue<String> queue = new LinkedBlockingQueue<>();
        return 1;
    }


}
