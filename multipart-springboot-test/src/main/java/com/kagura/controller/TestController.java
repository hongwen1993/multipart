package com.kagura.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/11/3 12:15
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Value("${test.env:kt}")
    String ip;

    @GetMapping("/test01")
    public void test01() {
        System.err.println("ip : " + ip);
    }

}
