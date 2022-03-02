package com.zxxia.s28_arrays;

import com.zxxia.iTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays
 * 1. static toString
 * 2. static sort, 算法：快排序
 * 3. static sort 用比较器对象排序，只能是引用类型的排序
 * 4. static binarySearch：二分查找，前提，要排序好
 * 5. 案例：对象排序
 */
class Student {
    String name;
    int age;
    double height;

    Student(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}

class StudentCampareTest implements iTest {

    @Override
    public void run() {
        Student s1 = new Student("张三", 2, 100);
        Student s2 = new Student("李四", 1, 120.0);
        Student s3 = new Student("王五", 3, 100.1);
        Student[] array = {s1, s2, s3};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                // 年龄升序排列
                return student.age - t1.age;
            }
        });
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                // 身高升序排列
                return Double.compare(student.getHeight(), t1.getHeight());
            }
        });
        System.out.println(Arrays.toString(array));
    }
}

public class Test {
    public static void main(String[] args) {
        //toString
        int[] array = {2, 3, 1};
        System.out.println(Arrays.toString(array));//[2, 3, 1]
        //sort
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));//[1, 2, 3]
        //用二分排序
        int idx = Arrays.binarySearch(array, 0);
        System.out.println(idx);//-1

        //用比较器对象排序,降序排序
        Integer[] array1 = {1, 2, 5, 9, 1000};
        Comparator comparable = new Comparator<Integer>() {

            @Override
            public int compare(Integer integer, Integer t1) {
                //指定规则
                return t1 - integer;
            }
        };
        Arrays.sort(array1, comparable);
        // [1000, 9, 5, 2, 1]
        System.out.println(Arrays.toString(array1));

        StudentCampareTest test = new StudentCampareTest();
        test.run();
    }
}
