package com.netty.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
public class UserController {

    @GetMapping(path = "/user")
    public Integer test01() {
        System.out.println(123456);
        return 1;
    }

}
