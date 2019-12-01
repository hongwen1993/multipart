package com.kagura.tree;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/12/1 15:07
 * @since 1.0.0
 */
public class StackTest {

    private int count = 0;

    public void testStack(){
        count++;
        testStack();
    }

    public void test(){
        try {
            testStack();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("stack height:"+count);
        }
    }

    public static void main(String[] args) {
        new StackTest().test();
    }

}