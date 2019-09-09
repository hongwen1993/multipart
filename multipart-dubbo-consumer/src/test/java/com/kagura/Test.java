package com.kagura;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/6 15:16
 * @since 1.0.0
 */
public class Test {

    @org.junit.Test
    public void test01() {
        String path = System.getProperty("java.library.path");
        System.err.println(path);
    }
}
