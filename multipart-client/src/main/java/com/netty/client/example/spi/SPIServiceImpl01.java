package com.netty.client.example.spi;

public class SPIServiceImpl01 implements SPIService{

    private String name;

    public SPIServiceImpl01(String name) {
        this.name = name;
    }

    @Override
    public void show(String name) {
        System.out.println("SPIServiceImpl01 : " + name);
    }
}
