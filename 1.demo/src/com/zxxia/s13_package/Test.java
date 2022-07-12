package com.zxxia.s13_package;

/**
 * 1. 包不同，相同；通过包名全路径访问
 * 2. 权限修饰符，如果没写，只能在同一个包下访问；例如，c.run()方法报错
 */

public class Test {
    public static void main(String[] args) {
        com.zxxia.s13_package.p1.Cat c = new com.zxxia.s13_package.p1.Cat();
        c.log();
//        c.run();
        com.zxxia.s13_package.p2.Cat c1 = new com.zxxia.s13_package.p2.Cat();
        c1.log();
    }
}
