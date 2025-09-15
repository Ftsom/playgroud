package com.ldy.playground.toolkit.base.streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liudongyang
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        List<String> listNew = list.stream()
                .filter(i -> i > 5)
                .map(String::valueOf)
                .collect(Collectors.toList());

        listNew.forEach(System.out::println);
    }
}
