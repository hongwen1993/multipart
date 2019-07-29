package com.kagura;

import com.pretty_tools.dde.DDEException;
import com.pretty_tools.dde.DDEMLException;
import com.pretty_tools.dde.client.DDEClientConversation;
import io.netty.channel.Channel;
import org.junit.Ignore;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Ignore
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



    private static final List<Thread> threads = new ArrayList<>();
    @Test
    public void test04() throws InterruptedException {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 1");
                threads.add(Thread.currentThread());
                System.out.println(Thread.currentThread().getName() + " 2");
                Thread.sleep(15000);
                System.out.println(Thread.currentThread().getName() + " 3");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " error");
                e.printStackTrace();
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " 1");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " 2");
        int i = 0;
        while (true) {
            if (i == 0) {
                i += 1;
                System.out.println(threads.get(0).isAlive());
                System.out.println(threads.get(0).getThreadGroup());
                System.out.println(threads.get(0).isDaemon());
                threads.get(0).interrupt();
            }
        }
    }

    @Test
    public void test05() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }, 1000, 2000);

        Boolean tf = true;
        while (true) {
            if (tf) {
                Thread.sleep(10000);
                timer.cancel();
                System.out.println("a");
                tf = false;
            }
        }
    }

    @Test
    public void test06() {
        try {
            final DDEClientConversation conversation = new DDEClientConversation();
            conversation.connect("Excel", "Sheet1");
            try {
                // Requesting A1 value
                System.out.println("R1C1 value: " + conversation.request("R1C1"));
                // Changing cell A1 value to "We did it!"
                //conversation.poke("R1C1", "We did it!");
                // Sending "close()" command
                //conversation.execute("[close()]");
            } finally {
                conversation.disconnect();
            }
        } catch (DDEMLException e) {
            System.out.println("DDEMLException: 0x" + Integer.toHexString(e.getErrorCode())
                    + " " + e.getMessage());
        } catch (DDEException e) {
            System.out.println("DDEException: " + e.getMessage());
        }

    }


}
