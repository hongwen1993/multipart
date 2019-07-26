package com.kagura.desgin.组合模式;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/7/25 15:21
 * @since 1.0.0
 */
public class CacheManager {
    // 处理1级缓存
    public static void doCache1() {
        // do somethings...
    }
    // 处理2级缓存
    public static void doCache2() {
        // do somethings...
    }
    // 处理3级缓存
    public static void doCache3() {
        // do somethings...
    }
    // 处理所有缓存
    public static void doCacheAll() {
        doCache1();
        doCache2();
        doCache3();
    }

    // 模拟客户端调用
    public static void main(String[] args) {
        // 如果单独应用各级缓存处理
        // 那么扩展或者销毁时,改动就非常多了
        //doCache1();
        //doCache2();
        //doCache3();
        doCacheAll();
    }
}
