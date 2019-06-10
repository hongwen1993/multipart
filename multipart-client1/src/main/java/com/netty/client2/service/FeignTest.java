package com.netty.client2.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service", fallback = FeignTestFallback.class)
public interface FeignTest {

    @GetMapping(path = "/user")
    Integer test01();

}
