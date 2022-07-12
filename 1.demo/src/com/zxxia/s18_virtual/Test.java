package com.zxxia.s18_virtual;

/**
 * 1. 常见形式：父类类型 对象名称=new 子类构造器
 * 2. 常见形式：接口    对象名称=new 实现类构造器
 * 3. 多态访问特点：
 *      - 成员变量：编译只看左边，运行看左边；
 *      - 成员函数：编译看左边，运行看右边；
 * 4. 多态前提：有继承和实现关系；有父类对象引用子类对象；有方法重写；
 * 5. 优点：多态形式，方便解耦，参数可以是一切参数；例如：Animal ani = new Dog();可以将Dog直接换成Tortoise；其它都不用改变；不能使用子类独有功能，比如：lookDoor函数
 * 6. 父类调子类， 必须强转；作用：调用子类独有功能；
 * 7. 用instanceof判断子类类型
 */

abstract class Animal {
    public String name;

    abstract void run();
}

class Dog extends Animal {

    Dog() {
        this.name = "Dog";
    }

    @Override
    void run() {
        System.out.println("Dog run fast!");
    }

    void lookDoor() {
        System.out.println("看门");
    }
}

class Tortoise extends Animal {
    Tortoise(){
        this.name = "Tortoise";
    }
    @Override
    void run() {
        System.out.println("Tortoise run slow!");
    }

    void layEggs() {
        System.out.println("下蛋");
    }
}

public class Test {
    public static void main(String[] args) {
        // 常见形式1
        Animal ani = new Dog();
        Animal an2 = new Tortoise();
        //优点
        go(ani);
        go(an2);
        //父类到子类强转
        Tortoise t = (Tortoise) an2;
        t.layEggs();

        // 这里会报错：强转问题；Exception in thread "main" java.lang.ClassCastException: com.zxxia.s18_virtual.Dog cannot be cast to com.zxxia.s18_virtual.Tortoise
        Tortoise tortoise = (Tortoise) ani;
        tortoise.layEggs();
    }

    public static void go(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.lookDoor();
        }
        else if (animal instanceof Tortoise) {
            Tortoise tortoise = (Tortoise) animal;
            tortoise.layEggs();
        }
        System.out.println(animal.name);
        System.out.println("开始");
        animal.run();
        System.out.println("结束");
    }
}
