package com.kagura.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/11 19:26
 * @since 1.0.0
 */
public class TestThread {

    List<HanLi> hanLis = new ArrayList<>();

    static final Object object = new Object();

    public static void main(String[] args) {

        new HanLi("1").start();
        new HanLi("2").start();


    }


    static class HanLi extends Thread {

        private String name;

        public HanLi(String name) {
            this.name = name;
        }

        @Override
        public void run() {

        }

    }


}
