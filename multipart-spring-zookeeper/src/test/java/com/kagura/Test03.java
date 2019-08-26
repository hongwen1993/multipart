package com.kagura;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/26 9:26
 * @since 1.0.0
 */
public class Test03 {

    @Test
    public void test01() {
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);

    }
}
