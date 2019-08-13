package com.kagura.controller;

import com.kagura.stream.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/13 22:55
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    RabbitmqSender rabbitmqSender;

    @RequestMapping("/01")
    public void test01() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("number", 1234567);
        rabbitmqSender.sendMessage("i love you ", map);
    }
}
