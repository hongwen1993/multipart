package com.kagura.xiaomage;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 小马哥每日一问
 *
 * @author Karas
 * @date 2019/7/22 10:22
 */
public class Name {
    private String first, last;

    public Name(String first, String last) {
        if (first == null || last == null)
            throw new NullPointerException();
        this.first = first;
        this.last = last;
    }

    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    public int hashCode() {
        int h;
        return (first == null) ? 0 : (h = first.hashCode()) ^ (h >>> 16);
    }



    public static void main(String[] args) {
        // HashSet的contains方法,是通过泛型调用equals,因此会先调用Object的equals(Object object)方法
        // 如果子类没有重写equals方法,则默认使用父类的equals
        // 且此处与重载没有关系,重写,只是从下到上匹配重写的方法,而非重载的方法
        Set<Name> s = new HashSet<>();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));

        // 显示地调用equals是可以保证相等的
        Name a = new Name("Mickey", "Mouse");
        System.out.println(a.equals(new Name("Mickey", "Mouse")));

    }
}
