package com.ldy.playground.toolkit.base.clazz.innerclazz;

/**
 * 静态内部类
 */
public class StaticOuter { //外部类 (Outer Class)
    private static int field1;
    private String field2;

    private static void outerMethod1() {
        System.out.println("outerMethod1");
    }

    public void testInner() {
        String localVariable = "";
    }

    public void shutdown() {

    }

    static class LocalInner { // 内部类 (LocalInner Class)
        private String huoSai;
        public String qiGang;

        public void start() {
            // 内部类可以直接访问外部类的私有成员
            if (field1 > 0) {
                System.out.println("Get field1 > 0");
            } else {
                System.out.println("Get field1 < 0");
            }

            // 内部类可以直接访问外部类的私有方法
            outerMethod1();
        }

        public void stop() {

        }
    }

    public static void main(String[] args) {
        // 不依赖外部直接使用
        LocalInner localInner = new LocalInner();
        localInner.start();
    }
}
