package com.ldy.playground.toolkit.base.clazz.innerclazz;

/**
 * 成员内部类
 */
public class MemberOuter { //外部类 (Outer Class)
    private Integer gasLevel;
    private String window;

    private void openWindow() {
        System.out.println("开启窗户");
    }

    public void operateEngine() {
        // 无法获取内部类的属性
//        System.out.println(huoSai);
//        System.out.println(qiGang);

        // 无法调用内部类方法
//        start();
    }

    class  Engine {// 内部类 (Inner Class)
        private static String huoSai;
        public static String qiGang;

        public void start() {
            // 内部类可以直接访问外部类的私有成员
            if (gasLevel > 0) {
                System.out.println("Engine started!");
            } else {
                System.out.println("Out of gas, can't start.");
            }

            // 内部类可以直接访问外部类的私有方法
            openWindow();
        }
    }

    // 不建议的方式，将内部类公开
    public Engine newInner() {
        MemberOuter.Engine engine = new MemberOuter.Engine();
        return engine;
    }

    public static void main(String[] args) {
        System.out.println(Engine.huoSai);
        MemberOuter memberOuter = new MemberOuter();
        MemberOuter.Engine engine = memberOuter.new Engine();
    }
}
