package com.zxxia.s20_object;

import java.util.Objects;

/**
 * Object祖宗类，JDK1.7才有
 * 1. toString方法，返回类名权限名内存地址,这返回值毫无意义；但重写之后就有意义，可以看到想的信息，例如Student:toString
 * 2. equals方法，比较地址是否相同；也是重写后，内容更丰富
 * 3. Object.isNull
 */
class Student //extends Object //等同于继承Object
{
    private String name;

    @Override
    public String toString() {
        return "Student{ name:" +this.name +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

}

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.toString());// com.zxxia.s20_object.Student@1b6d3586
        System.out.println(s);// com.zxxia.s20_object.Student@1b6d3586
        System.out.println(s.getClass());
    }
}
