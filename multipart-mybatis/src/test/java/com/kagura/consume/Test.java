package com.kagura.consume;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * PipedInputStream / PipedOutputStream
 * 这个类位于java.io包中，是解决同步问题的最简单的办法，一个线程将数据写入管道，另一个线程从管道读取数据，
 * 这样便构成了一种生产者/消费者的缓冲区编程模式。PipedInputStream/PipedOutputStream只能用于多线程模式，
 * 用于单线程下可能会引发死锁。
 *
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/11/27
 * @since 1.0.0
 */
public class Test {

    public static Pipe pipe;

    static {
        try {
            pipe = Pipe.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        new Thread(new Producer(pipe)).start();
        new Thread(new Consumer(pipe)).start();
    }

    static class Producer implements Runnable {

        public Pipe pipe;

        public Producer(Pipe pipe) {
            this.pipe = pipe;
        }

        @Override
        public void run() {
            Pipe.SinkChannel sinkChannel = pipe.sink();
            try {
                int i = 0;
                while (true) {
                    sinkChannel.write(ByteBuffer.wrap(("sinkChannel - " + i).getBytes()));
                    ++i;
                    Thread.sleep(1200);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        public Pipe pipe;

        public Consumer(Pipe pipe) {
            this.pipe = pipe;
        }

        @Override
        public void run() {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                Pipe.SourceChannel sourceChannel = pipe.source();
                try {
                    int bytesRead = sourceChannel.read(byteBuffer);
                    byteBuffer.rewind();
                    while (byteBuffer.hasRemaining()) {
                        System.out.print((char) byteBuffer.get());
                    }
                    System.out.println("\n=====");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
