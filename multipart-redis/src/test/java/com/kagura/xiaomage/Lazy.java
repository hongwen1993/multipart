package com.kagura.xiaomage;

/**
 * 此处会出现锁竞争,简单的理解就是类加载器被wait了
 * 连main方法都无法执行到
 *
 * @author Karas
 * @date 2019/7/22 13:43
 */
public class Lazy {

    private static boolean initialized = false;

    static {
        System.out.println(1);
        Thread t = new Thread(() -> {
            System.out.println("other " + Thread.currentThread());
            initialized = true;
        });
        System.out.println(2);
        t.start();
        try {
            System.out.println(3);
            t.join();
            System.out.println(4);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(5);
        System.out.println("main " + Thread.currentThread());
        System.out.println(initialized);
    }

}
