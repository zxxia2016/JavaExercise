package com.zxxia.s33_genericity;

import com.zxxia.iTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 1. 格式：<数据类型>；注意：只能是引用类型
 * 2. 集合体系的全局接口和实现类都支持泛型
 * 3. 好处：统一数据类型；把运行期间问题提前到编译期间，避免转换问题,例如：GenericityTest
 * 4. 哪些地方可以定义（E、T、K、V）：
 * ---类后面->泛型类：public class MyClass<T>{}; 例如：MyArrayList
 * ---方法申明上->泛型方法：格式：public <T> void show(T t){}; 例如；MyArrayList.printArray
 * ---接口后面->泛型接口，格式：public interface Data<E>{}；例如：iData -> TeacherData
 * 5. 泛型通配符,格式：?；会有类型乱传问题，用泛型上下限解决；例如：CarRaceTest
 * 6. 泛型上下限，格式：
 * ---上限：? extends Car；
 * ---下限 ? super Car
 */

class GenericityTest implements iTest {

    @Override
    public void run() {
        List list = new ArrayList();
        list.add("Java");
        list.add(33);
        list.add(true);
        for (Object o : list) {
            // 运行期间强转风险
            // String e = (String) o;
            // System.out.println(e);
        }

    }
}


class MyArrayList<T> {
    private List list = new ArrayList();

    public void add(T e) {
        list.add(e);
    }

    public void remove(T e) {
        list.remove(e);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "list=" + list +
                '}';
    }

    public static <E> void printArray(E[] array) {
        if (array == null) {
            System.out.println(array);
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append((i == array.length - 1) ? "" : ",");
        }
        sb.append("]");
        System.out.println(sb);
    }

}

class MyGenericityTest implements iTest {

    @Override
    public void run() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.remove("aaa");
        System.out.println(list);

        String[] strings = {"111", "2222"};
        Integer[] integers = {1, 2, 3};
        MyArrayList.printArray(strings);
        MyArrayList.printArray(integers);

    }
}

interface iData<T> {
    void add(T t);
    boolean remove(int id);
    boolean update(T t);
    T get(int id);
}

class Teacher {
    public String name;
    public int age;
    public String job;
}
class TeacherData implements iData<Teacher> {


    @Override
    public void add(Teacher teacher) {

    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }

    @Override
    public Teacher get(int id) {
        return null;
    }
}

class Car {
    public String name;
    public boolean run() {
        System.out.println(this.name + "run");
        return true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
class BWM extends Car {
    BWM(String name) {
        this.name = name;
    }
}
class Benz extends Car {
    Benz(String name) {
        this.name = name;
    }
}

class Dog {
    public String name;
    public boolean run() {
        System.out.println(this.name + "run");
        return true;
    }
}
class CarRaceTest implements iTest {

    @Override
    public void run() {
        ArrayList<BWM> bwms = new ArrayList<>();
        bwms.add(new BWM("1号"));
        bwms.add(new BWM("2号"));
        bwms.add(new BWM("3号"));
        this.go(bwms);

        ArrayList<Benz> benz = new ArrayList<>();
        benz.add(new Benz("1号"));
        benz.add(new Benz("2号"));
        benz.add(new Benz("3号"));
        this.go(benz);

        ArrayList<Dog> dogs = new ArrayList<>();
        // 通配符限制，狗是无法加入的
        // this.go(dogs);
    }
    private void go(ArrayList<? extends Car> array) {
        //开始比赛
        System.out.println("开始比赛");
        for (Car e : array) {
            System.out.println(e + "比赛");
        }
    }
}
public class Test {
    public static void main(String[] args) {
        GenericityTest genericityTest = new GenericityTest();
        genericityTest.run();

        MyGenericityTest myArrayListTest = new MyGenericityTest();
        myArrayListTest.run();

        CarRaceTest carRaceTest = new CarRaceTest();
        carRaceTest.run();
    }
}
