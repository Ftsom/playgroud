package com.ldy.playground.toolkit.base.reflection.proxyTest;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String name) {
        System.out.println("UserServiceImpl add user success");
    }
}
