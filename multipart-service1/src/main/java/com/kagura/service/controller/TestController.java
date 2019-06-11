package com.kagura.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hw
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/01")
    public String test01() {
        System.out.println("TestController : test01()");
        return "ok";
    }

}
