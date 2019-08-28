package com.kagura;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/28 15:42
 * @since 1.0.0
 */
public class AtomicUser {
    private static class User {
        private String name;
        public User(String name) {
            this.name = name;
        }
        public String getName() { return name; }
    }

    private static AtomicReference<User> atomicReference = new AtomicReference<>();





    private static List<String> LIST = new ArrayList<>();

    private static int test01 () {
        try {
            LIST.add("a");
            int a = 0/0;
            return LIST.size();
        } catch (Exception e) {
            LIST.add("b");
            return 9999;
        } finally {
            LIST.add("b");
        }
    }

    private static int show2 () {
        List<String> list = new ArrayList<>();
        try {
            list.add("a");
            return 100;
        } finally {
            list.add("b");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.err.println(show3());
    }
    private static int show1 () {
        List<String> list = new ArrayList<>();
        try {
            list.add("a");
            return list.size();
        } finally {
            list.add("b");
        }
    }
    private static int show3() {
        List<String> list = new ArrayList<>();
        try {
            list.add("a");
            int n = 0 / 0;
            return list.size();
        } catch (Exception e) {
            return list.size();
        } finally {
            list.add("b");
            //return list.size();
        }
    }

}
