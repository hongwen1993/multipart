package com.netty.client.example.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<SPIService> loaders = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = loaders.iterator();
        while (iterator.hasNext()) {
            SPIService spiService =  iterator.next();
            spiService.show("TT");
        }
    }

}
