package com.ldy.playground.toolkit.base.clazz.innerclazz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 静态内部类
 */
public class AnonymousOuter { //外部类 (Outer Class)
    private static int field1;
    private String field2;

    private static void outerMethod1() {
        System.out.println("outerMethod1");
    }

    public void testInner() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(field1);
                System.out.println(field2);
                outerMethod1();
                System.out.println("匿名实现");
            }
        });
        thread.start();
    }

    public void testInner2() {
        List<String> list = new ArrayList<>();
        list.add("ccc");
        list.add("a");
        list.add("bb");

        list.sort( new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(list);
    }


    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        anonymousOuter.testInner();
        anonymousOuter.testInner2();
    }
}
