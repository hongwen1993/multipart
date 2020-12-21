package com.kagura.singleton;

/**
 * - 延迟加载（懒汉式）
 *
 * 引入并发：
 * - 线程不安全（并发时可能出现多个单例）
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class C {

    private static C instance;

    private C() {
    }

    public static C getInstance() {
        if (instance == null) {
            instance = new C();
        }
        return instance;
    }
}


///**
// * 饿汉式3（初始化时就创建对象，静态代码块特性）
// */
//class Singleton {
//
//    private Singleton instance = null;
//
//    private Singleton() {}
//    // 初始化顺序：基静态、子静态 -> 基实例代码块、基构造 -> 子实例代码块、子构造
//    static {
//        instance = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return this.instance;
//    }
//}

/**
 * 饿汉式4（静态内部类特性，最为推荐的使用方式）
 * - 线程安全
 * - 效率高
 */
class Singleton {

    private static class InstanceHolder {
        // 静态内部类里面创建了一个Singleton单例
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}