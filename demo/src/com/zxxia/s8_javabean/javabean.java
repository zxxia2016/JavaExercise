package com.zxxia.s8_javabean;

// 就是一个面向对象的一个规范:封装、集成、多态
class Animation {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
public class javabean {
    public static void main(String[] args) {
        Animation a = new Animation();
        a.setName("狗");
        System.out.println(a.getName());
    }
}
