package com.kagura.thread;

import java.util.Objects;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/5/13
 * @since 1.0.0
 */
public class Test01 {

    public static class User {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static  String N = "1";

    public String N2 = "1";

    public static User USER = new User();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("执行线程1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            N = "2";
            USER.setName("zhang");
        }).start();

        new Thread(() -> {
            while (true) {
                if (Objects.equals("2", N)) {
                    System.out.println("我是2啦");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("okok");
                System.out.println(USER.getName());
            }
        }).start();

        while (true) {}
    }

}
