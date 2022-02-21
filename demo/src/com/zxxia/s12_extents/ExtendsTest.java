package com.zxxia.s12_extents;

/**
 * 1. 静态方法不能集成，属于类；对象和类名都可以调用，共享数据
 * 2. Java不支持多继承，支持多层继承，即只能继承一个类；A->B->C；但不能A、B->C；因为AB有可能出现相同的方法，这时候出现二义性，不知道调A还是B的方法
 * 3. Object是祖宗类
 * 4. 继承后，访问方法或变量是就近原则
 * 5. 方法重写:@Override：子类会覆盖父类方法或变量；可以通过super.调用父类方法;重写方法：访问权限必须大于或等于父类；不能重写静态方法
 * 6. 创建子类，会先调用父类的构造器
 */

class People {
    public People() {
        System.out.println("无参数构造器");
    }
    public People(String name) {
        this.name = name;
        System.out.println("参数构造器");
    }
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    static public void log() {
        System.out.println("1111");
    }

    String name;
    String age;
}

class Student extends People {
    Student(String name) {
        super(name);
    }
    void study() {
        System.out.println("好好学习，天天向上");
    }
}

class Teacher extends People {
    void teach() {
        System.out.println("教书育人");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        System.out.println("test");
        Student s = new Student("张三");
        s.study();
        s.log();
        Teacher t = new Teacher();
        t.teach();
        t.teach();
    }
}
