package com.kagura;

import sun.reflect.CallerSensitive;

public class Test02 {
    private String name;
    private static Test02 T02;
    private Test02() {

    }

    @CallerSensitive
    public static Test02 getTest02() {
        return T02;
    }

    private static void getAll() {
        System.out.println(1);
    }
}
