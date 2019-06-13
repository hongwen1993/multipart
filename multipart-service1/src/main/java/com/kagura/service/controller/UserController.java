package com.kagura.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/user")
    public Integer test01() throws InterruptedException {
        //Thread.sleep(3000);
        System.out.println("service1 : test01()");
        return 1;
    }

}
