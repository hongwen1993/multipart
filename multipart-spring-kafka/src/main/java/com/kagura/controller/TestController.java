package com.kagura.controller;

import com.kagura.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/16 17:03
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping(path = "/01")
    public Object test01() {
        kafkaSender.send();
        return "0";
    }

    @GetMapping(path = "/02")
    public Object test02() {
        return "1";
    }

}
