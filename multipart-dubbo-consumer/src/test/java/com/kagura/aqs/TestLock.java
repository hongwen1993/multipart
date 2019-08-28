package com.kagura.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/28 10:12
 * @since 1.0.0
 */
public class TestLock {

    /**
     * 初始化设置锁的个数
     * @param count 锁个数
     */
    public TestLock(int count) {
        sync = new Sync(count);
    }

    private final Sync sync;

    private static final class Sync extends AbstractQueuedSynchronizer {

        /**
         * 必须要对 state 初始化 , 不初始化则为1
         */
        private Sync(int count) {
            if (count > 0) {
                setState(count);
            }
        }

        /**
         * 获取锁实现
         * @param arg   获取的个数
         */
        @Override
        protected int tryAcquireShared(int arg) {
            for(;;) {
                int state = getState();
                if(state < 0) {
                    throw new RuntimeException("机制异常");
                }
                if(state > 0) {
                    compareAndSetState(state, state + arg);
                }
                return state;
            }
        }

        /**
         * 释放锁实现
         * @param arg   释放的个数
         */
        @Override
        protected boolean tryReleaseShared(int arg) {
            int state = getState();
            if(state < 0) {
                throw new RuntimeException("机制异常");
            }
            return compareAndSetState(state, state - arg);
        }
    }

    /**
     * 获取锁 - 面向开发者
     */
    public void lock() {
        sync.tryAcquireShared(1);
    }
    /**
     * 释放锁 - 面向开发者
     */
    public void release() {
        sync.tryReleaseShared(1);
    }


}
