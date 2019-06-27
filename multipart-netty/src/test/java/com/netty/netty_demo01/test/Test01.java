package com.netty.netty_demo01.test;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class Test01 {

    public static CountDownLatch latch = new CountDownLatch(2);

    @Test
    public void test01() throws InterruptedException {
        Thread t1 = new Thread(new T1());
        t1.start();
        Thread.sleep(5000);
        Thread t2 = new Thread(new T1());
        t2.start();

        Thread.sleep(10000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        t1.start();
        Thread.sleep(5000);
        Thread t2 = new Thread(new T1());
        t2.start();
    }

   static class T1 implements Runnable {

        @Override
        public void run() {
            System.out.println("123456");
            try {
                System.out.println("开始等待");
                latch.countDown();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待结束");
        }
    }

}

class Test02 {
    class Test03 {

    }

}