package com.ldy.playground.toolkit.base.reflection;

/**
 * @author liudongyang
 */
public class SimpleTest {

    private String stringField;
    private int intField;

    public void testPrint(String info) {
        System.out.println("info is " + info);
    }

    public String getStringField() {
        return stringField;
    }
}
