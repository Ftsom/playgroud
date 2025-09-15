package com.ldy.playground.toolkit.base.lambdatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liudongyang
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("cccc");
        list.add("bb");

        //匿名内部类
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //lambda 表达式
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());

        //lambda 表达式
        Collections.sort(list, (String o1, String o2) -> o1.length() - o2.length());

        new Thread(() -> System.out.println(Thread.currentThread().getName()));

        list.forEach( item -> System.out.println(item));

        list.forEach(System.out::println);

    }

}
