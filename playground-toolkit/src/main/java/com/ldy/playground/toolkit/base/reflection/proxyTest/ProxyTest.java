package com.ldy.playground.toolkit.base.reflection.proxyTest;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 核心原理：
 * JDK动态代理利用反射机制和java.lang.reflect.Proxy类，在运行时为一个或多个接口动态地生成一个代理类的字节码，并加载到JVM中。
 * <p>
 * 工作流程：
 * <p>
 * 获取目标对象的接口信息：通过反射获取目标对象实现的所有接口。
 * - 创建代理类字节码：Proxy类会动态生成一个名为 $Proxy0（数字会递增）的代理类的.class文件字节码。这个代理类会实现目标对象的所有接口，并且会继承java.lang.reflect.Proxy类。
 * - 重写接口方法：在生成的代理类中，所有接口方法都会被重写。这些重写后的方法体内部，并不会直接调用目标方法，而是会去调用一个我们预先提供的InvocationHandler的invoke方法。
 * - 调用处理器：invoke方法是所有逻辑增强的核心。它接收三个参数：代理对象本身(proxy)、被调用的方法(method)、方法的参数(args)。在这个方法里，我们可以通过反射（method.invoke(target, args)）来调用原始目标对象的方法，并在此前后添加我们的增强逻辑。
 * - 返回代理实例：最后，Proxy.newProxyInstance()方法会用这个新生成的代理类的字节码创建一个实例并返回。
 * <p>
 * 一句话总结原理：通过Proxy类动态生成一个实现了目标接口的代理类，这个代理类的所有方法都统一转发给InvocationHandler的invoke方法来处理。
 * <p>
 * {@link $Proxy0}
 *
 * @author liudongyang
 */
public class ProxyTest {

    public static void main(String[] args) {

        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        UserService userService = new UserServiceImpl();

        UserService o = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new LogInvocationHandler(userService));

        o.addUser("user-1");

    }

}
