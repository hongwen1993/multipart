package com.kagura.thread;

import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/1 15:29
 * @since 1.0.0
 */
public class ThreadPoolTest {

    @Test
    public void test01() throws InterruptedException {
        DelayQueue<User> queue = new DelayQueue<>();
        queue.add(new User(System.currentTimeMillis() + 5000L));
        // 结果为1
        System.err.println(queue.size());
        // 阻塞5秒
        queue.take();
        // 结果为2
        System.err.println(queue.size());
    }

    private class User implements Delayed {

        private String name;
        private Long time;

        public User(Long time) {
            this.time = time;
        }

        /**
         * 必须要实现的方法
         */
        @Override
        public long getDelay(TimeUnit unit) {
            // 第一个参数为剩余时间
            // 第二个参数为第一个参数的时间单位
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /**
         * 延迟队列的排序，可以自定义实现排序规则
         */
        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }


}
