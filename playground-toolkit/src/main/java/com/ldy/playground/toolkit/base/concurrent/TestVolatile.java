package com.ldy.playground.toolkit.base.concurrent;

public class TestVolatile {
    // 如果没有volatile，worker线程可能永远看不到stop被主线程修改为true
    private volatile boolean stop = false;

    class Worker extends Thread {
        public void run() {
            while (!stop) {
                // do work
            }
            System.out.println("Worker thread stopped.");
        }

        public void shutdown() {
            stop = true;
        }
    }

    public void test() throws InterruptedException {
        Worker worker = new Worker();
        worker.start();
        Thread.sleep(1000);
        worker.shutdown(); // 主线程修改stop变量
    }

    // 主线程
    public static void main(String[] args) throws InterruptedException {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.test();
    }
}