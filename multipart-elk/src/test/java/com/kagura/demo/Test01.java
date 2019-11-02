package com.kagura.demo;

import com.kagura.ElkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ElkApplication.class)
public class Test01 {

    //@Resource
    //private RestTemplate restTemplate;

    @Test
    public void demo01() {
        //Object object = restTemplate.getForObject("http://localhost:9200/_analyze", Object.class);
        //System.out.println(object);

        //Map<String, String> param = new HashMap<>();
        //param.put("analyzer", "ik_max_word");
        //param.put("text", "我是中国人");
        //
        //Object object = restTemplate.postForLocation("http://localhost:9200/_analyze", Object.class, param);
        //System.out.println(object);

    }

    //@Test
    //public void demo02() throws InterruptedException {
    //    // 0,1 线程交替打印
    //    Thread thread0 = new Thread(new Print("thread0", 0));
    //    Thread thread1 = new Thread(new Print("thread1", 1));
    //    thread0.start();
    //    Thread.sleep(1000);
    //    thread1.start();
    //}

    public static void main(String[] args) throws InterruptedException {
        // 0,1 线程交替打印
        Thread thread0 = new Thread(new Print("thread0", 0));
        Thread thread1 = new Thread(new Print("thread1", 1));
        thread0.start();
        Thread.sleep(1000);
        thread1.start();
    }

    public static final Object LOCK = new Object();

    private static class Print implements Runnable {

        private String name;
        private int index;

        public Print(String name, int index) {
            this.name = name;
            this.index = index;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                synchronized (LOCK) {
                    if (i % 2 == index) {
                        System.err.println(name + ":" + i);
                    }
                    try {
                        LOCK.notifyAll();
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


}
