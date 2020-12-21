package com.kagura.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/2 22:08
 * @since 1.0.0
 */
public class TestVolatile {

    private  static volatile int state ;

    public void setState(int newState) {
        state = newState;
    }

    public static void main(String[] args) {

        final User user = new User();


        new Thread(()->{
            while (true) {
                if (user.getAge() == 1){
                    System.out.println("判断标志位为1，退出循环");
                    break;
                }

            }
        },"listen").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            user.setAge(1);
            System.out.println("将标志修改为1");
        },"update").start();

        while (true) {

        }


    }


}
