package com.kagura.demo;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/12/11 19:39
 * @since 1.0.0
 */
public class TowThreadLoopPrint {


    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        //LoopPrint t1 = new LoopPrint(1);
        //LoopPrint t2 = new LoopPrint(0);

        //new Thread(t1).start();
        //Thread.sleep(2000);
        //new Thread(t2).start();

        final Object a = new Object();
        final Object b = new Object();

        new Thread(() -> {

            for (int i = 0; i < 100; i = i + 2) {
                synchronized (a) {
                    System.out.println(i);
                    try {
                        a.notifyAll();
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            for (int i = 1; i < 100; i = i + 2) {
                synchronized (a) {
                    System.out.println(i);
                    try {
                        a.notifyAll();
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    static class LoopPrint implements Runnable {

        private int n;

        public LoopPrint(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 1; i < 100; i++) {
                synchronized (object) {
                    if (i % 2 == n) {
                        try {
                            System.out.println(i);
                            object.notifyAll();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

}
