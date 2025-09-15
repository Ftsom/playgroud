package com.ldy.playground.toolkit.base.clazz.innerclazz;

/**
 * 局部内部类
 */
public class LocalOuter { //外部类 (Outer Class)
    private int field1;
    private String field2;

    private void outerMethod1() {
        System.out.println("outerMethod1");
    }

    public void testInner(int testInfo) {
        String localVariable = "";
        class LocalInner { // 内部类 (LocalInner Class)
            private String huoSai;
            public String qiGang;
            private static int a = 1;
            public void start() {
                // 内部类可以直接访问外部类的私有成员
                if (field1 > 0) {
                    System.out.println("Get field1 > 0");
                } else {
                    System.out.println("Get field1 < 0");
                }

                System.out.println(testInfo);

                // 内部类可以直接访问外部类的私有方法
                outerMethod1();
            }

            public void show() {
                System.out.println(localVariable);
            }

            public void stop() {

            }
        }
        // 只能在方法内部使用
        LocalInner localInner = new LocalInner();
        localInner.start();
    }

    public void shutdown() {

    }

    public static void main(String[] args) {
        LocalOuter localOuter = new LocalOuter();
        localOuter.testInner(1);
    }
}
