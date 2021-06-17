package com.kagura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/15 20:28
 * @since 1.0.0
 */
@RestController
public class TestController {

    @GetMapping(path = "/test01")
    public String test01() {
        return "test01";
    }



}
