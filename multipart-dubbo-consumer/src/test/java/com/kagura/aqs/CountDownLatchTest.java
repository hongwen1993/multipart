package com.kagura.aqs;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/30 14:31
 * @since 1.0.0
 */
public class CountDownLatchTest {

    @Test
    public void test01() {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {

                latch.await();
                System.err.println("111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {

                latch.await();
                System.err.println("222");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            latch.countDown();
            //Thread.sleep(5000);
            System.err.println("333");
        }).start();

        while (true) {

        }
    }
}
