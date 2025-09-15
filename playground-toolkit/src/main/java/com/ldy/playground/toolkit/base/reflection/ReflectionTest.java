package com.ldy.playground.toolkit.base.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liudongyang
 * java 反射应用
 * 反射的使用场景
 * 开发框架
 * AOP
 * spring注入
 * 注解
 * 动态代理
 * jdk动态代理：使用反射方式创建代理类，进行代理增强
 * 插件化开发
 * 数据库驱动加载：动态加载驱动，根据提供的驱动进行反射加载对应的驱动类，完成加载
 * 其他
 * 单元测试可以使用反射方式访问私有变量，便于测试
 * 动态生成代码
 * <p>
 * 反射实践
 * 获取类对象
 * 反射创建对象
 * 反射构造器
 * 反射方法
 * 反射属性
 * <p>
 * 反射注意
 * 性能
 * 安全
 * 可维护
 */
public class ReflectionTest {


    public static void main(String[] args) {
        try {

            // 根据类获取clazz
            Class<SimpleTest> simpleTestClazzD = SimpleTest.class;
            System.out.println(simpleTestClazzD.getName());

            // 根据名称获取clazz
            Class<?> simpleTestClazz = Class.forName("com.ldy.playground.toolkit.base.reflection.SimpleTest");
            System.out.println(simpleTestClazz.getSimpleName());

            // 根据clazz获取构造方法，并创建对象
            Object simpleTestObject = simpleTestClazz.getDeclaredConstructor().newInstance();
            System.out.println(simpleTestObject.getClass().getSimpleName());

            // 获取方法，并执行
            Method method = simpleTestClazz.getDeclaredMethod("testPrint", String.class);
            method.invoke(simpleTestObject, "你好");

            // 获取字段，并修改字段
            Field field = simpleTestClazz.getDeclaredField("stringField");
            field.setAccessible(Boolean.TRUE);
            field.set(simpleTestObject, "测试字段");

            // 获取方法，并执行
            Method methodString = simpleTestClazz.getDeclaredMethod("getStringField");
            System.out.println(methodString.invoke(simpleTestObject));

            // 获取classloader
            System.out.println(simpleTestClazz.getClassLoader().getName());
            System.out.println(simpleTestClazz.getClassLoader().getParent().getName());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException |
                 InvocationTargetException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
