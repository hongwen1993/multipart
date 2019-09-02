package com.kagura.consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 关键点
 * BlockingQueue
 * - 可以存放多个消息
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 15:10
 * @since 1.0.0
 */
public class Test03 {

    static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 1号生产者
        service.execute(() -> {
            int i = 0;
            for (;;) {
                try {
                    queue.put(((int)(Math.random() * 10) + "=>" + i));
                    ++i;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 2号生产者
        service.execute(() -> {
            int i = 0;
            for (;;) {
                try {
                    queue.put(((int)(Math.random() * 10) + "=>" + i));
                    ++i;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 消费者
        service.execute(() -> {
            for (;;) {
                try {
                    String message = queue.take();
                    System.err.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
