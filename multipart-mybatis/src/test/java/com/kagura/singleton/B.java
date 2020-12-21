package com.kagura.singleton;

/**
 * - 预加载（饿汉式）
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class B {

    private static final B instance = new B();

    private B() {
    }

    public static B getInstance() {
        return instance;
    }

}
