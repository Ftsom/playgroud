package com.ldy.playground.toolkit.base.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateOfCallable {
    public static void main(String[] args) throws InterruptedException {
        class Task implements Callable<String> {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "执行任务成功";
            }
        }

        FutureTask<String> futureTask = new FutureTask<>(new Task());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String result = futureTask.get();
            System.out.println("get result:" + result);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
