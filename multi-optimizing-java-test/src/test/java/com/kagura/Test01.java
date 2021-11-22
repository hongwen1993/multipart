package com.kagura;

import org.junit.Test;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/7/11 10:36
 * @since 1.0.0
 */
public class Test01 {

    @Test
    public void test01() {
        Map<String, String> map = new LinkedHashMap<>(4, 1, true);
        map.put("a", "0");
        map.put("b", "0");
        map.put("c", "0");
        map.put("d", "0");
        System.out.println(map);
        map.put("e", "0");
        System.out.println(map);
        //map.put("a", "0");
        //map.get("a");
        System.out.println(map);
    }

    @Test
    public void test02() {
        BitSet bitSet = new BitSet(1);
        bitSet.set(1);
        System.out.println(bitSet);
        bitSet.set(2);
        System.out.println(bitSet);
    }


}
