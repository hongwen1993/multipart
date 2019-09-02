package com.kagura.consumer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关键点
 * 使用 Exchanger
 * - 队列只有1条消息
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 14:47
 * @since 1.0.0
 */
public class Test02 {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 生产者
        executor.execute(() -> {
            System.err.println("生产者开始生产");
            int i = 0;
            for (;;) {
                try {
                    String message = "i am " + i;
                    // 发送完会阻塞
                    exchanger.exchange(message);
                    ++i;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 消费者
        executor.execute(() -> {
            System.err.println("消费者开始消费");
            for (;;) {
                try {
                    // 等待接收会阻塞
                    String message = exchanger.exchange(null);
                    System.err.println("接收到 : " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
