package com.kagura.desgin.桥接模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 13:43
 * @since 1.0.0
 */
public class SimpleAcount extends AbstractLogger{

    public SimpleAcount(Logger logger) {
        super(logger);
    }

    public void show() {
        System.err.println("do somethings...");
        print("66666");
    }

    public static void main(String[] args) {
        SimpleAcount acount = new SimpleAcount(Logger.warning());
        acount.show();
    }

}
