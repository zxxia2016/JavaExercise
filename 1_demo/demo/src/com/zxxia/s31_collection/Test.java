package com.zxxia.s31_collection;

/**
 * Collection:只能支持引用类型和泛型
 * -----------------------------------------------------------
 * Collection与Array比较
 * 1. 长度区别：
 * -- 集合长度可变
 * -- 数组长度不可变，固定
 * 2. 存储类型
 * -- 集合只能存储引用类型
 * -- 数组能存储基本类型和引用类型
 * 3. 应用场景：
 * -- 数组：固定的业务场景：比如花色、东南西北
 * -- 集合：不固定的业务场景
 * -----------------------------------------------------------
 * Collect体系
 * - List：有序，可重复，有索引；例子：ArrayListTest、LinkedListTest
 * --- ArrayList：原理：增加元素：默认10长度，按1.5被扩容；减少元素：删除，元素往前移动，size-1
 * --- LinkedList：双链表:首位操作速度极快，主要API：addFirst、addLast、getFirst、geLast、removeFirst、removeLast；是栈和队列的结合体
 * - Set：无序，不可重复，无索引；重要：必须重写对象的hashCode和equals方法；先判断hashCode是否相同，再判断equals相同
 * ---HashSet：无序，不可重复，无索引；
 * 底层原理：哈希表存储结构（数组+链表+红黑树）;
 * 默认创建长度16的数组，默认加载因子0.75的数组，数字名为table；
 * 根据hash值计算存入位置；
 * 判断调用equals方法，判断属性值是一样，不一样则存入；
 * 当数组存满到0.75倍时，自动扩容2倍，例如：16*0.75=12，到12时，就会 变成32
 * -------LinkedHashSet：有序，不可重复，无索引
 * ---TreeSet：排序，不可重复，无索引
 * 对于数值类型：Integer、Double默认按升序排序
 * 字符串类型：默认安装首字符的编号升序排序
 * 重要：想要使用TreeSet存储自定义类型，需要制定排序规则
 * -----------------------------------------------------------
 * 集合查找某个元素并删除的时候，会出现并发修改异常问题；例子：RemoveExceptionTest
 * ---迭代器便利且用集合删除元素可能出现问题
 * ---foreach循环遍历集合且直接用集合删除可能出现问题
 * -----------------------------------------------------------
 * 哈希表
 * --哈希值：根据对象地址，按照某种规则，生成int值；获取哈希值方式：HashCode()
 */

import com.zxxia.iTest;

import java.util.*;
import java.util.function.Consumer;


class ArrayListTest implements iTest {

    @Override
    public void run() {

        // 有序，可重复，有索引
        Collection arr = new ArrayList();
        arr.add("Java");
        arr.add("Java");
        arr.add("Mybatis");
        arr.add(33);
        arr.add(33);
        arr.add(false);
        arr.add(false);
        System.out.println(arr);

        System.out.println("-------------------- Collection --------------------");
        // Collection 常用API 用法
        Collection arrayList = new ArrayList();
        // 添加 成功返回TRUE
        System.out.println(arrayList.add("ddd"));
        // 清空集合
        arrayList.clear();
        System.out.println(arrayList);
        // 判断空
        System.out.println(arrayList.isEmpty());
        // 获取集合大小
        System.out.println(arrayList.size());
        // 判断集合包含某个元素
        System.out.println(arrayList.contains("aaa"));
        // 删除，Collection不能通过索引删除；成功返回值TRUE
        System.out.println(arrayList.remove("ddd"));

        System.out.println("-------------------- ArrayList --------------------");

        // ArrayList 常用API 基本上跟索引相关
        ArrayList<String> arrayList1 = new ArrayList();
        // 添加
        arrayList1.add("Java");
        arrayList1.add("Java");
        arrayList1.add("MySQL");
        arrayList1.add("MySQL");
        // 插入
        arrayList1.add(2, "HTML");
        System.out.println(arrayList1);
        // get
        System.out.println("Get:" + arrayList1.get(0));
        // remove 越界
        arrayList1.remove(0);
        //set
        String ret = arrayList1.set(0, "高斯林");
        System.out.println("设置返回值：" + ret);

        // 转数组
        Object[] a = arrayList.toArray();
        System.out.println(Arrays.toString(a));
        // 数组合并
        arrayList.addAll(arr);

        // 独有for循环 ArrayList独有
        for (int i = 0; i < arrayList1.size();++i) {
            String element = arrayList1.get(i);
        }
        // 遍历 用法
        System.out.println("-------------------- Collection 遍历 Iterator--------------------");
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element);
        }

        System.out.println("-------------------- Collection 遍历 foreach--------------------");

        for (Object element : arr) {
            System.out.println(element);
            if (element == "Mybatis") {
                element = "111"; //修改无意义
                break;
            }
        }
        arr.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        int[] aa = {1, 2};
        for (int v : aa) {

        }

        System.out.println("-------------------- ArrayList Test End--------------------");
    }
}

class LinkedListTest implements iTest {

    @Override
    public void run() {
        // 模拟栈操作
        LinkedList<String> stack = new LinkedList<>();
        // 入栈
        stack.push("第一个子弹");
        stack.addFirst("第二个子弹");
        stack.addFirst("第三个子弹");
        stack.addFirst("第四个子弹");
        System.out.println(stack); //[第四个子弹, 第三个子弹, 第二个子弹, 第一个子弹]
        // 出栈
        System.out.println(stack.removeFirst());//第四个子弹
        System.out.println(stack.pop());//第四个子弹
        System.out.println(stack);//[第三个子弹, 第二个子弹, 第一个子弹]

        //模拟队列
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.offerLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        queue.addLast("4号");
        queue.addLast("5号");
        System.out.println(queue);
        // 出队
        System.out.println(queue.removeFirst());// 1号
        System.out.println(queue.removeFirst());// 2号
        System.out.println(queue.removeFirst());// 3号
        System.out.println(queue);// [4号, 5号]

        System.out.println("-------------------- LinkedList Test End--------------------");
    }
}

class RemoveExceptionTest implements iTest{

    @Override
    public void run() {
        ArrayList<String> arrayList1 = new ArrayList();
        // 准备数据
        arrayList1.add("Java");
        arrayList1.add("Java");
        arrayList1.add("MySQL");
        arrayList1.add("MySQL");
        arrayList1.add("MySQL");
        arrayList1.add("赵敏");
        arrayList1.add("赵敏");
        System.out.println(arrayList1);
        // 迭代器遍历删除
        Iterator<String> it = arrayList1.iterator();
        while (it.hasNext()) {
            String ele = it.next();
            if (ele.equals("Java")) {
                // 下面代码会报错：Exception in thread "main" java.util.ConcurrentModificationException
                // arrayList1.remove(ele);
                // 正确方式如下；原理：remove后，迭代器会减减
                it.remove();
            }
        }
        System.out.println(arrayList1);

        // foreach遍历删除，会抛异常
        for (String s : arrayList1) {
            if ("Java".equals(s)) {
                //无法使用这种方式
                // arrayList1.remove("Java");
            }
        }
        // Lambda 会抛异常
        arrayList1.forEach(s -> {
            if (s.equals("Java"))  {
                // arrayList1.remove("Java");
            }
        });
        // 会漏了，解决方式：i--
        for (int i = 0; i < arrayList1.size(); i++) {
            String e = arrayList1.get(i);
            if ("Java".equals(e)) {
                arrayList1.remove(i);
            }
        }
        System.out.println("-------------------- RemoveExceptionTest Test End--------------------");

    }
}

class HashSetTest implements iTest {


    @Override
    public void run() {
        // 无序，不可重复，无索引
        HashSet arr = new HashSet();
        arr.add("Java");
        arr.add("Java");
        arr.add("Mybatis");
        arr.add(33);
        arr.add(33);
        arr.add(false);
        arr.add(false);
        // [Java, 33, false, Mybatis]
        System.out.println(arr);

        //哈希表；有序；多了个双链表机制，记录存储顺序
        Set set = new LinkedHashSet();
        set.add("Java");
        set.add("Java");
        set.add("Mybatis");
        set.add(33);
        set.add(33);
        set.add(false);
        set.add(false);
        // [Java, Mybatis, 33, false]
        System.out.println(set);

        String heima = "heima";
        System.out.println(heima.hashCode());

        class Student {
            String name;
            int age;
            Student (String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return age == student.age && Objects.equals(name, student.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age);
            }
        }

        // 必须重写对象的hashCode和equals方法
        Set<Student> students = new HashSet<>();
        students.add(new Student("zhangsan", 1));
        students.add(new Student("zhangsan", 1));
        students.add(new Student("zhangsan", 1));
        students.add(new Student("zhangsan", 1));
        //没重写hashCode 和equals方法时，有这4个相同对象，重写后，只有1个对象
        System.out.println(students);


        // TreeSet
        Set<Integer> set1 = new TreeSet<>();
        set1.add(22);
        set1.add(24);
        set1.add(1);
        // [1, 22, 24]
        System.out.println(set1);

        Set<String> set2 = new TreeSet<>();
        set2.add("Java");
        set2.add("Java");
        set2.add("angel");
        set2.add("About");
        set2.add("Python");
        set2.add("黑马");
        set2.add("UI");
        // [About, Java, Python, UI, angel, 黑马]
        System.out.println(set2);

        class Apple implements Comparable<Apple>{
            String name;
            String color;
            double price;
            int weight;

            public Apple(String name, String color, double price, int weight) {
                this.name = name;
                this.color = color;
                this.price = price;
                this.weight = weight;
            }

            @Override
            public int compareTo(Apple apple) {
                return this.weight - apple.weight;
            }

            @Override
            public String toString() {
                return "Apple{" +
                        "name='" + name + '\'' +
                        ", color='" + color + '\'' +
                        ", price=" + price +
                        ", weight=" + weight +
                        '}';
            }
        }

        Set<Apple> set3 = new TreeSet<>();
        //必须实现Comparable，重写compareTo
        //或者用比较器对象
        Set<Apple> set4 = new TreeSet<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple apple, Apple t1) {
                return apple.weight-t1.weight;
            }
        });
        set3.add(new Apple("红富士", "红色", 9.9, 500));
        set3.add(new Apple("青苹果", "青色", 19.9, 300));
        set3.add(new Apple("蛇果", "红色", 3.9, 200));
        set3.add(new Apple("绿", "绿色", 9.9, 500));
        set3.add(new Apple("红富士", "红色", 9.9, 500));
        // [Apple{name='蛇果', color='红色', price=3.9, weight=200}, Apple{name='青苹果', color='青色', price=19.9, weight=300}, Apple{name='红富士', color='红色', price=9.9, weight=500}]
        System.out.println(set3);

        System.out.println("-------------------- HashSetTest Test End--------------------");
    }
}

public class Test {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.run();
        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.run();
        RemoveExceptionTest removeExceptionTest = new RemoveExceptionTest();
        removeExceptionTest.run();
        HashSetTest hashSetTest = new HashSetTest();
        hashSetTest.run();
    }
}
