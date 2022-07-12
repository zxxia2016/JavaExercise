package com.zxxia.s53_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    public static <T> T getProxy(T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();
                Object rs = method.invoke(obj, args);
                long end = System.currentTimeMillis();
                System.out.println(method.getName() + "代理统一耗时：" + ((end - start) / 1000) + "s");
                return rs;
            }
        });
    }
}
