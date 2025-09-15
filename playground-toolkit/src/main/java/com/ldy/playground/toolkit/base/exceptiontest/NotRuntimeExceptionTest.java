package com.ldy.playground.toolkit.base.exceptiontest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NotRuntimeExceptionTest {

    // 方式一：通过try-catch捕获处理
    public void processFile() {
        FileReader reader = null;
        try {
            System.out.println("1. 打开文件...");
            reader = new FileReader("non_existent_file.txt"); // 抛出 FileNotFoundException
            System.out.println("2. 读取文件（这行不会执行）...");
        } catch (FileNotFoundException e) {
            System.out.println("3. 捕获到异常: 文件未找到！");
        } finally {
            System.out.println("4. finally块执行：关闭资源...");
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // 方式二：使用 throws 声明，交给调用者处理
    public void readFileWithThrows() throws IOException {
        FileReader reader = new FileReader("somefile.txt");
        // ...
        reader.close();
    }

    public void readFileModern() {
        // reader 会在 try 块结束时自动关闭，无需 finally
        try (FileReader reader = new FileReader("somefile.txt")) {
            // ... read the file
        } catch (IOException e) {
            System.err.println("文件处理失败: " + e.getMessage());
        }
    }
}
