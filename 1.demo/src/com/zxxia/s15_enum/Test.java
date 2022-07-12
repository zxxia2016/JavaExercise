package com.zxxia.s15_enum;

/**
 * 1. 可以用javac命令编译Java代码，然后用javap反编译，查看编译后的代码，代码如下
 * 2. 用途：一些标志和分类；例如：游戏中的上下左右
 */

/**
 * javap Season.class
 * Compiled from "Test.java"
 * final class com.zxxia.s15_enum.Season extends java.lang.Enum<com.zxxia.s15_enum.Season> {
 * public static final com.zxxia.s15_enum.Season SPRING;
 * public static final com.zxxia.s15_enum.Season SUMMER;
 * public static final com.zxxia.s15_enum.Season AUTUMN;
 * public static final com.zxxia.s15_enum.Season WINTER;
 * public static com.zxxia.s15_enum.Season[] values();
 * public static com.zxxia.s15_enum.Season valueOf(java.lang.String);
 * static {};
 * }
 */

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}

enum Orientation {
    UP, DOWN, LEFT, RIGHT
}

public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        move(Orientation.UP);
    }

    public static void move(Orientation o) {
        switch (o) {
            case UP: {
                System.out.println("up");
            }
            break;
            case DOWN: {
                System.out.println("down");
            }
            break;
        }
    }
}
