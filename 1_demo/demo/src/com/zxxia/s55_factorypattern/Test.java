package com.zxxia.s55_factorypattern;

/**
 * 工厂设计模式
 * 1. 创建型
 * 2. 实现了调用类与类之间的解耦；通过工厂集中维护
 * 3. 理解举例：我要一台电脑，直接从工厂买；不需要自己做一个
 */
public class Test {
    public static void main(String[] args) {
        Computer c = ComputerFactory.createComputer("mac");
        c.start();
        Computer c1 = ComputerFactory.createComputer("huawei");
        c1.start();
    }
}
