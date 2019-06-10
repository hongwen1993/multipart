package com.netty.client.example.spi;

public class SPIServiceImpl02 implements SPIService{
    @Override
    public void show(String name) {
        System.out.println("SPIServiceImpl02 : " + name);
    }
}
