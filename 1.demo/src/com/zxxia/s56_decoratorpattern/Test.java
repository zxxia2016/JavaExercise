package com.zxxia.s56_decoratorpattern;

/**
 装饰模式

 定义父类：InputStream
 定义实现类：FileInputStream 继承父类 定义功能
 定义装饰实现类：BufferedInputStream 继承父类 定义功能 包装原始类，增强功能。
 */
public class Test  {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream());
        bufferedInputStream.read();
    }
}
