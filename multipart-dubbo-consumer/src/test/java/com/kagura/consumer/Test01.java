package com.kagura.consumer;

import java.util.LinkedList;

/**
 * 关键点：
 * 对象锁synchronized自旋 + LinkedList链表结构
 * （当然可以使用其他阻塞锁来实现）
 * - 队列只有1条消息
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/28 7:19
 * @since 1.0.0
 */
public class Test01 {
    public LinkedList<String> list = new LinkedList<>();
    public static void main(String[] args) throws InterruptedException {
        Test01 consumer = new Test01();
        // 生产者
        new Thread(() -> {
            while (true) {
                synchronized (consumer) {
                    consumer.list.offer(System.currentTimeMillis() + "===>" + "karas");
                    consumer.notifyAll();
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(1500);
        // 消费者
        new Thread(() -> {
            while (true) {
                synchronized (consumer) {
                    System.err.println(consumer.list.poll());
                    consumer.notifyAll();
                    try {
                        consumer.wait();
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
