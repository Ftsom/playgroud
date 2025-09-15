package com.ldy.playground.toolkit.base.generic;

import java.util.List;

class Fruit {

}

class Banana extends Fruit {

}

class Apple extends Fruit {

}

class HuaNiuApple extends Apple {

}

/**
 * 类声明泛型
 */
class GenericCodeTest0<T> {
    private T t;

    public void setData(T t) {

    }

    public <F extends Fruit>  F getFirst(List<F> list) {
        F f = list.get(0);
        return f;
    }

    // 方法声明泛型 上限
    public <F extends Fruit> void testUp(F f) {
        System.out.println(f.getClass().getName());
    }

    // 方法声明泛型 上限（编译错误：意外的标记）
//    public <F super HuaNiuApple> void testDown(F f) {
//
//    }
}

/**
 * 类声明泛型 上限
 */
class GenericCodeTest1<T extends Fruit> {
    private T t;
}

/**
 * 类声明泛型 下限（编译错误）
 */
//class GenericCodeTest2<T super HuaNiuApple> {
//    private T t;
//}

class GenericCodeTest0Children extends GenericCodeTest0<Integer> {
    @Override
    public void setData(Integer t) {

    }
}
public class GenericCodeTest {
    public static void main(String[] args) {
        GenericCodeTest0<?> genericCodeTest0 = new GenericCodeTest0<>();
        genericCodeTest0.testUp(new HuaNiuApple());
    }
}











