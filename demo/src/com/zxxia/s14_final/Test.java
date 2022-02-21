package com.zxxia.s14_final;

/**
 * 1. final可以修饰类、方法、变量
 * 2. 修饰类的作用：不能被继承;例如： Animal类 、String类
 * 3. 修饰方法，不能被重写、继承；例如： Fruit类
 * 4. 修饰变量（局部变量、成员变量），只能赋值一次;例如：Test函数；使用场景如下
 * 5. final存储的基础类型变量，数据无法改版；如果修饰引用类型，那地址不能改变，地址指向的值可以改变;例如：Test1
 * 6. 什么时候用final？查看Constant类
 */
final class Animal {

}

//class Cat extends Animal {
//
//}

class Fruit {
    final void log() {

    }
}

class Apple extends Fruit {
//    @Override
//    void log() {
//
//    }
}

class Test1 {
    public static void main(String[] args) {
        final double PI = 3.1415926;
//        PI=3;//报错
        final int[] array = {0,2};
        //报错
//        array = {0,1};
        //ok
        array[1] = 1;
    }
}

public class Test {
    //使用场景3
    public final static String name = "Test";

    public static void main(String[] args) {
        final int age = 0;
//        age = 1;//这里代码出错，只能赋值一次
        //使用场景1
        final double PI = 3.1415926;
        buy(0.8);
    }
    //使用场景2
    static void buy(final double z) {
//        z = 0.1;//这里出错，只能赋值一次
    }
}
