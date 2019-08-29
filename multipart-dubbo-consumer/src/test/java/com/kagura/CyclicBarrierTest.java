package com.kagura;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/29 16:08
 * @since 1.0.0
 */
public class CyclicBarrierTest {

    private CyclicBarrier barrier = new CyclicBarrier(2);
    @Test
    public void test01() throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                System.err.println(1);
                barrier.await();
                System.err.println(2);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        barrier.await();
        System.err.println(3);
    }

    @Test
    public void test02() throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(2, new A());

        new Thread(() -> {
            try {
                System.err.println(1);
                barrier.await();
                System.err.println(2);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        barrier.await();
        System.err.println(3);
    }

    private class A implements Runnable {
        @Override
        public void run() {
            try {
                System.err.println(5);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
