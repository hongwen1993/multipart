package com.kagura;

import io.netty.channel.Channel;
import org.junit.Test;
import org.springframework.scheduling.quartz.LocalTaskExecutorThreadPool;
import org.springframework.util.ReflectionUtils;
import sun.misc.Unsafe;
import sun.reflect.Reflection;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " lock");
                    // condition.await();
                    // Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    @Test
    public void test02 () throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Dio("Ta", 1));
        service.execute(new Dio("Tb", 0));
    }

    class Dio implements Runnable {
        private String name;
        private int flag;
        private Dio (String name, int flag) {
            this.name = name;
            this.flag = flag;
        }
        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
                try {
                    lock.lock();
                    if (i % 2 == flag) {
                        System.out.println(name + " : " + i);
                        condition.signalAll();
                        condition.await();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }
    }


    @Test
    public void test03() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        // 通过私有属性获取 ## private static final Unsafe theUnsafe;
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe1 = (Unsafe) field.get(null);
        System.out.println(unsafe1);

        // 通过私有构造器获取对象 ## private Unsafe() {}
        Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Unsafe unsafe2 = constructor.newInstance();
        System.out.println(unsafe2);

    }

}
