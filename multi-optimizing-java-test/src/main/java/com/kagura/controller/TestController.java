package com.kagura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/1/15 20:28
 * @since 1.0.0
 */
@RestController
public class TestController {

    @GetMapping(path = "/test01")
    public String test01() throws InterruptedException {

        return "test01";
    }


    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + "执行完成");
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        Thread t3 = new Thread(runnable, "t3");
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
