package com.zxxia.s53_proxy;

/**
 * 动态代理：Proxy；切面编程思想；AOP思想
 * 1. 当前业务：UserService会统计每个用户动作的耗时，导致会在每个函数都添加时间统计相关代码；到处存在大量冗余代码；与业务代码掺杂在一起
 * 2. 解决方案，动态代码：ProxyUtil；
 */
public class Test {
    public static void main(String[] args) {
        UserService userService= new UserServiceImpl();
        userService.login("admin", "123456");
        userService.deleteUsers();
        userService.selectUsers();

        // 动态代理
        UserService userService1 = ProxyUtil.getProxy(new UserServiceImpl());
        userService1.login("admin", "123456");
        userService1.deleteUsers();
        userService1.selectUsers();

        UserService userService2 = MyProxy.getProxy(new UserServiceImpl());
        userService2.login("admin", "123456");
        System.out.println("main end");
    }
}
