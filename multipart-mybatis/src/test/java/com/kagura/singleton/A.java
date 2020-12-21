package com.kagura.singleton;

/**
 * - 公有属性，破坏了面向对象的『封装』原则（虽然此处使用了final修饰）
 * - 预加载（饿汉式）
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class A {

    public static final A instance = new A();

    private A() {
    }

}
