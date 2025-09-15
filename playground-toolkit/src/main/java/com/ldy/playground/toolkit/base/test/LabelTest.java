package com.ldy.playground.toolkit.base.test;

/**
 * @author liudongyang
 */
public class LabelTest {
    public static void main(String[] args) {
        int innerCycleCount = 3;
        int innnerCurrentCount = 1;
        retry:
        for (; ; ) {
            System.out.println("进入out循环");
            for (; ; ) {
                System.out.println("进入inner循环");
                if (innnerCurrentCount > innerCycleCount) {
                    System.out.println("执行完毕");
                    break retry;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                innnerCurrentCount++;
            }
        }

        System.out.println("退出程序");

    }
}
