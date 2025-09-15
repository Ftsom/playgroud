package com.ldy.playground.toolkit.base.concurrent;

import java.util.Random;

public class TestVolatileHB {
    private volatile int volatileFiled;
    private int commonField;
    private int valueFromvolatileFiled;

    public void setValue(int ldy) {
        this.volatileFiled = ldy;
        this.commonField = ldy;
        valueFromvolatileFiled = volatileFiled;
    }

    public static void main(String[] args) {
        TestVolatileHB testVolatileHB = new TestVolatileHB();
        Random random = new Random();
        testVolatileHB.setValue(random.nextInt());
    }
}
