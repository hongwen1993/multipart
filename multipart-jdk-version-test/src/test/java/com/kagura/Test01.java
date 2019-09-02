package com.kagura;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/18 9:07
 * @since 1.0.0
 */
public class Test01 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        CountDownLatch countDownLatch = new CountDownLatch(1);
    }
}
