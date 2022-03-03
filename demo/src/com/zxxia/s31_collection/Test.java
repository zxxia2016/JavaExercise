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
 * --- LinkedList：双链表
 * - Set：无序，不可重复，无索引
 * ---HashSet
 * -------LinkedHashSet
 * ---TreeSet
 * -----------------------------------------------------------
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

        // 常用API 用法
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
        // 这样是可以通过索引删除的
        ArrayList arrayList1 = new ArrayList();
        // 越界
        // arrayList1.remove(0);

        // 转数组
        Object[] a = arrayList.toArray();
        System.out.println(Arrays.toString(a));
        // 数组合并
        arrayList.addAll(arr);

        // 遍历 用法
        System.out.println("-------------------- ArrayList 遍历 Iterator--------------------");
        Iterator it = arr.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            System.out.println(element);
        }

        System.out.println("-------------------- ArrayList 遍历 foreach--------------------");

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
        HashSetTest hashSetTest = new HashSetTest();
        hashSetTest.run();
    }
}
