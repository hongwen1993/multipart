package com.kagura.xiaomage;

/**
 * @author Karas
 * @date 2019/7/22 15:49
 */
public class Bleep {

    String name = "Bleep";

    void setName(String name) {
        this.name = name;
    }

    void backgroundSetName() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                setName("Blat");
            }
        };
        t.start();
        t.join();
        System.out.println(name);
    }

    public static void main(String[] args) throws InterruptedException {
        new Bleep().backgroundSetName();
    }

}

