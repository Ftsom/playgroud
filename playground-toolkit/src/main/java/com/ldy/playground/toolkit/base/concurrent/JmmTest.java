package com.ldy.playground.toolkit.base.concurrent;

/**
 * @author liudongyang
 */
public class JmmTest {

    private volatile int count = 0;

    public void doTest() throws InterruptedException {

        count = count + 1;

        TaskTest taskTest = new TaskTest();
        Thread thread1 = new Thread(taskTest);
        thread1.start();

        Thread thread2 = new Thread(taskTest);
        thread2.start();

        thread1.join();
        thread2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            JmmTest jmmTest = new JmmTest();
            jmmTest.doTest();
            System.out.println("测试" + i + "次 ： " + jmmTest.count);
        }
    }

    class TaskTest implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count = count + 1;
            }
        }
    }
}
