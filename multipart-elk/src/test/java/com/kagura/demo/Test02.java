package com.kagura.demo;

import org.junit.Test;

import java.math.BigDecimal;

public class Test02 {

    @Test
    public void test01() {
        BigDecimal b1 = new BigDecimal("0.1");
        System.out.println(b1.setScale(-1, BigDecimal.ROUND_DOWN));
        System.out.println(b1.setScale(0, BigDecimal.ROUND_DOWN));
        System.out.println(b1.setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(b1.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println(b1.setScale(3, BigDecimal.ROUND_DOWN));
        BigDecimal b2 = new BigDecimal("1.1");
        System.out.println(b2.setScale(-1, BigDecimal.ROUND_DOWN));
        System.out.println(b2.setScale(0, BigDecimal.ROUND_DOWN));
        System.out.println(b2.setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(b2.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println(b2.setScale(3, BigDecimal.ROUND_DOWN));
        BigDecimal b3 = new BigDecimal("1.5");
        System.out.println(b3.setScale(-1, BigDecimal.ROUND_DOWN));
        System.out.println(b3.setScale(0, BigDecimal.ROUND_DOWN));
        System.out.println(b3.setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(b3.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println(b3.setScale(3, BigDecimal.ROUND_DOWN));
    }
}
