package com.kagura.xiaomage;

/**
 * @author Karas
 * @date 2019/7/22 16:44
 */
public class AnimalFarm {

    public static void main(String[] args) {
        // 常量的池
        final String pig = "length: 10";
        // 拼接的池
        final String dog = "length: " + pig.length();
        System.out.println(pig.hashCode());
        System.out.println(dog.hashCode());
        System.out.println("Animals are equal: " + pig == dog);

        System.out.println(pig == dog);

    }

}
