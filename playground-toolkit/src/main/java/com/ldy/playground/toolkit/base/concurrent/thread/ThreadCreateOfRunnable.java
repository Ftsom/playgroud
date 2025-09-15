package com.ldy.playground.toolkit.base.concurrent.thread;

public class ThreadCreateOfRunnable {

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行任务");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();

    }
}
