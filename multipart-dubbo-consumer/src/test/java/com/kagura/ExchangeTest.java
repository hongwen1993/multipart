package com.kagura;

import org.junit.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/30 17:01
 * @since 1.0.0
 */
public class ExchangeTest {

    private final Exchanger<String> exchanger = new Exchanger<>();

    @Test
    public void test01() {

        Executor executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> {
            System.err.println("执行A");
            String a = "A数据";
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String data = exchanger.exchange(a);
                System.err.println("我是A，我接收到数据：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            System.err.println("执行B");
            String b = "B数据";
            try {
                String data = exchanger.exchange(b);
                System.err.println("我是B，我接收到数据：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (true) {

        }

    }
}
