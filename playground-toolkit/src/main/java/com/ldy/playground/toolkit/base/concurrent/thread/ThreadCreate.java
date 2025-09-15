package com.ldy.playground.toolkit.base.concurrent.thread;

public class ThreadCreate extends Thread {

    public static void main(String[] args) {
        ThreadCreate threadCreate = new ThreadCreate();
        threadCreate.start();
    }

    @Override
    public void run() {
        System.out.println("执行任务");
    }
}
