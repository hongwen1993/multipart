package com.kagura.singleton;

/**
 * 悲观锁，排他性能极低（静态方法上加同步锁）
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class D {

    private static D instance;

    private D() {
    }

    public static synchronized D getInstance() {
        if (instance == null) {
            instance = new D();
        }
        return instance;
    }
}
