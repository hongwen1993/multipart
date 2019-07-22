package com.kagura.xiaomage;

/**
 * @author Karas
 * @date 2019/7/22 16:12
 */
public class LongDivision {

    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;

    private static final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;

    private static final long MICROS_PER_DAY2 = 24L * 60 * 60 * 1000 * 1000;


    public static void main(String[] args) {
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
        System.out.println(MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }




}
