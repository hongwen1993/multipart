package com.netty.client2.service;

import org.springframework.stereotype.Component;

@Component
public class FeignTestFallback implements FeignTest {
    @Override
    public Integer test01() {
        System.out.println("asdfasdf");
        return 999;
    }
}
