package com.kagura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/12 17:57
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/01")
    public void test01() {

    }

}