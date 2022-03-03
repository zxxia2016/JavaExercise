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
 * - List：有序，可重复，有索引
 * --- ArrayList：原理：增加元素：默认10长度，按1.5被扩容；减少元素：删除，元素往前移动，size-1
 * --- LinkedList：双链表:首位操作速度极快，主要API：addFirst、addLast、getFirst、geLast、removeFirst、removeLast；是栈和队列的结合体
 * - Set：无序，不可重复，无索引
 * ---HashSet
 * -------LinkedHashSet
 * ---TreeSet
 * -----------------------------------------------------------
 * 集合查找某个元素并删除的时候，会出现并发修改异常问题：
 * ---迭代器便利且用集合删除元素可能出现问题
 * ---foreach循环遍历集合且直接用集合删除可能出现问题
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
        Collection arr = new HashSet();
        arr.add("Java");
        arr.add("Java");
        arr.add("Mybatis");
        arr.add(33);
        arr.add(33);
        arr.add(false);
        arr.add(false);
        System.out.println(arr);
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
