package com.zxxia.s19_insideclass;

/**
 * 内部类：理解成（寄生），外部类理解成（宿主）
 * 1. 分类：
 *  --静态内部类（了解）:跟普通类没差别,只能访问外部类的静态成员变量
 *  --成员内部类（了解）
 *  --局部内部类（了解）
 *  --匿名内部类（重点）
 */

class OuterClass {
    private static String name;

    //跟普通类没差别
    public static class InnerClass{
        void show(){
            System.out.println("show");
            System.out.println(OuterClass.name);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.show();
    }
}
