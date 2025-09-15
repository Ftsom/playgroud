package com.ldy.playground.toolkit.base.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericMethodTest {

    public <T> T getFirstItem(List<T> list) {
        if (Objects.isNull(list)) {
            return null;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello world");

        GenericMethodTest genericMethodTest = new GenericMethodTest();
        System.out.println(genericMethodTest.getFirstItem(list));
    }
}
