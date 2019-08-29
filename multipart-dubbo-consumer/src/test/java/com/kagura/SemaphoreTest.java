package com.kagura;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/29 17:58
 * @since 1.0.0
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(2);
    @Test
    public void test01() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    // 首先会立马输出20个1
                    // 竞争到锁的可以继续执行，只有2把锁
                    System.err.println(1);
                    semaphore.acquire();
                    // 输出2之后，进入等待5秒
                    System.err.println(2);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
        while (true){}
    }

}
