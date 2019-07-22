package com.kagura.xiaomage;

import java.util.Objects;

/**
 * 小马哥每日一问
 *
 * @author Karas
 * @date 2019/7/22 9:40
 */
public class Confusing {

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Confusing(int a) {
        this.a = a;
    }

    //public Confusing(int[] array) {
    //    System.out.println("int");
    //}
    public Confusing(double[] array) {
        System.out.println("double");
    }
    public Confusing(Object object) {
        System.out.println("object");
    }
    public static void main(String[] args) {
        // 就近原则,所以先匹配double[], 而不是Object
        new Confusing(null);

        // Integer.Max_VALUE + 1会变成Integer.Min_VALUE,循环会一直循环下去。
        //final int start = Integer.MAX_VALUE - 100;
        //final int end = Integer.MAX_VALUE;
        //int count = 0;
        //for (int i = start; i <= end; i++)
        //    count++;
        //System.out.println(count);

        Confusing confusing = new Confusing(1);
        System.out.println(confusing.equals(new Confusing(1)));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confusing confusing = (Confusing) o;
        return a == confusing.a;
    }

    //@Override
    public boolean equals(Confusing confusing) {
        return a == confusing.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

}
