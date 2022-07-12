package com.zxxia.s11_singleinstance;

//懒汉模式
class SingleInstance {
    public static SingleInstance instance = new SingleInstance();
    public static SingleInstance getInstance() {
        return instance;
    }
    private SingleInstance() {

    }
    public void print() {
        System.out.println("1111");
    }
}

//饿汉模式
class SingleInstance1 {
    public static SingleInstance1 instance;
    public static SingleInstance1 getInstance() {
        if (instance == null) {
            instance = new SingleInstance1();
        }
        return instance;
    }
    private SingleInstance1() {

    }
    public void print() {
        System.out.println("2222");
    }
}

public class SingleInstanceTest {
    public static void main(String[] args) {
        SingleInstance.getInstance().print();
        SingleInstance1.getInstance().print();
    }
}