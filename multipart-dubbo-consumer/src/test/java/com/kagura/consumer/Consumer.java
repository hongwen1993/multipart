package com.kagura.consumer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/28 7:19
 * @since 1.0.0
 */
public class Consumer {


    public LinkedList<String> list = new LinkedList<>();



    public static void main(String[] args) throws InterruptedException {

        Consumer consumer = new Consumer();

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
