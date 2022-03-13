package com.kagura.temp;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/12/29
 */
public class WaitNotifyABC implements Runnable {

    private static volatile int n = 0;

    private int num;

    private String name;

    public WaitNotifyABC(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void run() {
        if (n % num == 0) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

    }


}
// 1 共享全局递增变量。
// 2 不共享全局递增变量，内部遍历全部，但只打印对应的输出。