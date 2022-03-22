package com.zxxia.s51_reflectclass;

import com.zxxia.iTest;

/**
 * 反射类
 * 1. 获取反射类：3种方式；例子：GetClass
 * 2. 获取构造器对象并使用
 * 3.
 */
class Student {

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
        Student s = new Student();
        // class com.zxxia.s51_reflectclass.Student
        System.out.println(s.getClass());
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        GetClass getClass = new GetClass();
        getClass.run();
    }
}
