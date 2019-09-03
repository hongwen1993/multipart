package com.kagura.phaser.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Phaser
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/3 10:30
 * @since 1.0.0
 */
public class UserTask extends Phaser implements Runnable {

    private static final Phaser PH;

    static {
        // 初始化 Phaser
        PH = new UserTask();
        // 注册 2 个Parties(任务)
        PH.bulkRegister(2);
    }

    /**
     * 该方法在每个阶段结束的时候会被调用
     * @param phase                 当前阶段，从0开始
     * @param registeredParties     当前任务数量
     * @return                      当返回 true 时，则表示阶段已经全部执行完毕
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                System.err.println("1阶段全部执行完毕");
                return false;
            case 1:
                System.err.println("2阶段全部执行完毕");
                return true;
            default:
                return true;
        }
    }

    /**
     * 任务的具体实现内容
     * 随机设置等待时间
     */
    @Override
    public void run() {
        try {
            System.err.println(Thread.currentThread().getName() + "===>>>阶段1开始执行");
            Thread.sleep((long) (Math.random() * 10000));
            System.err.println(Thread.currentThread().getName() + "===>>>阶段1执行完毕");
            PH.arriveAndAwaitAdvance();
            System.err.println(Thread.currentThread().getName() + "===>>>阶段2开始执行");
            Thread.sleep((long) (Math.random() * 10000));
            System.err.println(Thread.currentThread().getName() + "===>>>阶段2执行完毕");
            PH.arriveAndAwaitAdvance();
            System.err.println(Thread.currentThread().getName() + "===>>>结束任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new UserTask());
        executor.execute(new UserTask());
        while (true) {
            // PH 最终为 terminated 状态
            System.err.println(PH.isTerminated());
            Thread.sleep(3000);
        }
    }

}
