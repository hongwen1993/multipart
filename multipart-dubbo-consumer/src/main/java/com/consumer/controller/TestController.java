package com.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.api.service.TestService;
import com.kagura.service.UserService;
import com.kagura2.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/15 13:46
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference
    private UserService userService;
    @Reference
    private FoodService foodService;
    @Reference
    private TestService testService;



    @GetMapping(path = "/01")
    public void test01() {
        System.out.println(userService.saveUser(1L));
        System.out.println(foodService.saveFood(2L));
        System.err.println(testService.getOne());
    }

}
