package com.zxxia.s51_reflectclass;

import com.zxxia.iTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 反射类
 * 1. 获取反射类：3种方式；例子：GetClass
 * 2. 获取构造器对象，例子：GetConstructor
 * 3. 获取成员变量,例子：GetField
 * 4. 获取成员函数，例子：
 */
class Student {

    private int age;
    private String name;

    private Student(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class GetField implements iTest {
    @Override
    public void run() throws Exception {
        Class c1 = Student.class;
        //遍历所有成员变量
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + "====>" + field.getType());
        }
        //获取成员变量，并赋值
        Field field = c1.getDeclaredField("age");
        Student student = new Student(18, "111");
        System.out.println(student);
        field.setAccessible(true);
        field.set(student, 20);
        System.out.println(student);

        //获取年龄
        field.setAccessible(true);
        int age = (int) field.get(student);
        System.out.println(age);
    }
}

class GetConstructor implements iTest {
    @Override
    public void run() throws Exception {
        Class c1 = Student.class;

        // 获取公有构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "===>" + constructor.getParameterCount());
        }
        // 获取全部构造器
        Constructor[] constructors1 = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor.getName() + "===>" + constructor.getParameterCount());
        }

        Constructor constructor = c1.getConstructor(int.class, String.class);
        Student s = (Student) constructor.newInstance(1000, "孙悟空");
        System.out.println(s);

        Constructor constructor1 = c1.getDeclaredConstructor(String.class);
        // 私有构造器，暴力打开，不然无法new
        constructor1.setAccessible(true);
        Student s1 = (Student) constructor1.newInstance("孙悟空");
        System.out.println(s1);
    }
}

class GetClass implements iTest {
    @Override
    public void run() throws Exception {
        // 方式1：全限名：包名+类名
        Class c = Class.forName("com.zxxia.s51_reflectclass.Student");
        // class com.zxxia.s51_reflectclass.Student
        System.out.println(c);

        // 方式2：类名
        Class c1 = Student.class;
        // class com.zxxia.s51_reflectclass.Student
        System.out.println(c1);

        //对象
        Student s = new Student(1, "");
        // class com.zxxia.s51_reflectclass.Student
        System.out.println(s.getClass());
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        GetClass getClass = new GetClass();
        getClass.run();

        GetConstructor getConstructor = new GetConstructor();
        getConstructor.run();

        GetField getField = new GetField();
        getField.run();
    }
}
