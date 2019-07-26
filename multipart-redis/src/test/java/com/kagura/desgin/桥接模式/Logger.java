package com.kagura.desgin.桥接模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 10:22
 * @since 1.0.0
 */
@FunctionalInterface
interface Logger {
    void log(String message);

    static Logger info() {
        return message -> System.out.println("info: " + message);
    }

    static Logger warning() {
        return message -> System.out.println("warning: " + message);
    }

    static Logger debug() {
        return new Logger() {
            @Override
            public void log(String message) {
                System.out.println("debug: " + message);
            }
        };
    }

    default void getLog() {
        System.out.println("获取日志");
    }

    public static void main(String[] args) {
        // info: 1
        info().log("1");
        // warning: 2
        warning().log("2");
        // debug: 3
        debug().log("3");
    }
}