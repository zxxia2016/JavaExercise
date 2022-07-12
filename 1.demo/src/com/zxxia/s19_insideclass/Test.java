package com.zxxia.s19_insideclass;

/**
 * 内部类：理解成（寄生），外部类理解成（宿主）
 * 1. 分类：
 *  --静态内部类（了解）:跟普通类没差别,只能访问外部类的静态成员变量；用法：外部类名.内部类名 对象名=new外部类名.内部类构造器
 *  --成员内部类（了解）:要先new外部类；才能再new内部类；更符合现实场景；用法：外部类名.内部类名 对象名=new外部类构造器.new 内部构造器
 *  --局部内部类（了解）：鸡肋，不了解
 *  --匿名内部类（重点）：作用：直接创建子类对象，简化代码
 */

// 静态内部类
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

// 成员内部类：人和心脏的关系
class OuterClass1 {
    public String getName() {
        return name;
    }

    private String name;
    private static String sName;

    public class InnnerClass {
        private String name;
        //不允许使用
//        private static int age;
        void showName(){
            System.out.println(this.name);
            //内部类调用外部类变量
            System.out.println(OuterClass1.this.name);
            System.out.println(getName());
            System.out.println(sName);
        }
        //不允许使用
//        static void showAge(){
//
//        }
    }
}

abstract class Animal{
    public abstract void run();
}

public class Test {
    public static void main(String[] args) {

        //静态内部类
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.show();

        // 成员内部类
        OuterClass1.InnnerClass i = new OuterClass1().new InnnerClass();
        i.showName();
//        OuterClass1.InnnerClass.showAge();

        //匿名内部类
        Animal a = new Animal() {
            public void run(){
                System.out.println("run");
            }
        };
        a.run();
    }
}

