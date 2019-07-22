package com.kagura.xiaomage;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Karas
 * @date 2019/7/22 15:52
 */
public class Reflector {

    public static void main(String[] args) throws Exception {
        Set s = new HashSet();
        s.add("foo");
        //s.add("too");
        Iterator i = s.iterator();
        Method m = i.getClass().getMethod("hasNext", new Class[0]);
        System.out.println(m.invoke(i, new Object[0]));
    }

}
