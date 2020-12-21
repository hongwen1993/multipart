package com.kagura.singleton;

/**
 * new E();指令重排
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class E {

    private static E instance;

    private E() {
    }

    public static E getInstance() {
        if (instance == null) {
            synchronized (E.class) {
                if (instance == null) {
                    instance = new E();
                }
            }
        }
        return instance;
    }
}
