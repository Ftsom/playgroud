package com.ldy.playground.toolkit.base.exceptiontest;

public class RuntimeExceptionTest {

    public void processArray(String[] arr) {
        // 如果 arr 为 null，下一行就会抛出 NullPointerException
        // 如果 i >= arr.length，就会抛出 ArrayIndexOutOfBoundsException
        // 编译器不要求我们在这里加 try-catch
        System.out.println(arr[0].toUpperCase());
    }

    // 正确的做法是修复逻辑，而不是捕获
    public void processArrayFixed(String[] arr) {
        if (arr != null && arr.length > 0 && arr[0] != null) {
            System.out.println(arr[0].toUpperCase());
        } else {
            System.out.println("数组或其元素不合法！");
        }
    }


}
