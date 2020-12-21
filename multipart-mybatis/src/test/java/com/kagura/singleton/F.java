package com.kagura.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/19
 * @since 1.0.0
 */
public class F {

    private static final AtomicReference<Object> instance;

    private F() {
    }

    static {
        // 初始化顺序：父静态属性、子静态属性 -> 父静态代码块、父构造 -> 子静态代码块、子构造
        instance = new AtomicReference<Object>();
    }

    public static F getInstance() {
        Object value = F.instance.get();
        if (value == null) {
            synchronized (F.instance) {
                value = F.instance.get();
                if (value == null) {
                    final F actualValue = new F();
                    value = ((actualValue == null) ? F.instance : actualValue);
                    F.instance.set(value);
                }
            }
        }
        return (F) ((value == F.instance) ? null : value);
    }

}

///**
// * 利用 compareAndSet
// */
//class Singleton {
//
//    private static final AtomicReference<Singleton> INSTANCE
//            = new AtomicReference<Singleton> ();
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        for(;;) {
//            Singleton instance = INSTANCE.get();
//            if(instance != null) {
//                return instance;
//            }
//            instance = new Singleton();
//            if(INSTANCE.compareAndSet(null, instance)) {
//                return instance;
//            }
//        }
//    }
//}