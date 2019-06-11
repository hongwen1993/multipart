package com.kagura.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${name}")
    private String name;

    @GetMapping(path = "/test01")
    public Integer test01() {
        System.out.println(123456);
        System.out.println("name : " + name);
        return 1;
    }

}
