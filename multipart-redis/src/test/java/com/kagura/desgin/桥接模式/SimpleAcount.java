package com.kagura.desgin.桥接模式;

/**
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/26 13:43
 * @since 1.0.0
 */
public class SimpleAcount extends AbstractLogger{



    // 每一个类都需要引入Logger,且需要用到不同级别的logger
    public SimpleAcount(Logger logger) {
        super(logger);
    }



    public void show() {
        System.err.println("do somethings...");
        print("66666");
    }

    public static void main(String[] args) {
        // 抽象出日志类别之,就可以动态地去控制日志的类别
        SimpleAcount acount = new SimpleAcount(Logger.warning());
        acount.show();

        acount.setLogger(Logger.info());
        acount.show();

    }

}
