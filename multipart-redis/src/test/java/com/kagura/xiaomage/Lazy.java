package com.kagura.xiaomage;

/**
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
