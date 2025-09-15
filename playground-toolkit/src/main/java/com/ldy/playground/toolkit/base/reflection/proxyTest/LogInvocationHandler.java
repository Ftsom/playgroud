package com.ldy.playground.toolkit.base.reflection.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liudongyang
 */
public class LogInvocationHandler implements InvocationHandler {

    private final Object target;

    LogInvocationHandler(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Begin do dao");
        Object o = method.invoke(target, args);
        System.out.println("end do dao");
        return o;
    }
}
