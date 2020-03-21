package com.kagura.other;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/12/3 20:37
 * @since 1.0.0
 */
public class Test01 {

    @Test
    public void test01() {
        System.err.println(this.getClass().getClassLoader().getResourceAsStream("D:\\_Temp\\rule.drl"));
    }

    @Test
    public void test02() {
        String str = "const";
        String str2 = "const ";
        String str3 = "const\n";
        System.err.println(Pattern.matches("const\\s", str));
        System.err.println(Pattern.matches("const\\s", str2));
        System.err.println(Pattern.matches("const\\s", str3));
    }

    @Test
    public void test03() {

    }

    public static void main(String[] args) {
        System.err.println(QuratzManager.getSingletonInstance());
    }
}
