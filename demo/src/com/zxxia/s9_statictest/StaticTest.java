package com.zxxia.s9_statictest;

//静态成员变量，共享数据，处于静态变量存储区（堆内存）
//通用功能使用静态方法，对象自己的行为用实例方法:例如，工具类:ArrayUtil
//面试：静态方法，只能访问类成员变量；实例方法可以访问类成员变量：例如User类

class User {
    private static int playCount = 0;
    public String name;

    public static int getPlayCount() {
        return playCount;
    }

    public static void setPlayCount(int playCount) {
        playCount += playCount;
        //name = "111";//报错
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class StaticTest {
    public static void main(String[] args) {
        User u = new User();
        u.setName("11");
        u.setPlayCount(1);
        System.out.println(User.getPlayCount());
        User u1 = new User();
        u1.setName("222");
        u1.setPlayCount(1);
        System.out.println(User.getPlayCount());

        int[] array = {1, 2, 3};
        System.out.println(ArrayUtil.toString(array));
    }
}
