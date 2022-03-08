package com.zxxia.s40_stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream:简化集合和数组操作,不改变原有结构
 * 1. 传送带一样的流水线
 * ---获取流：获取方法，任何集合通过Stream()
 * ---中间流
 * ---终结方法
 * 2. 常用API
 * ---
 */
public class Test {
    public static void main(String[] args) {
        // 需求：找到姓名的，且名字只有2个字符的
        // Collection获取流
        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "张四", "张无忌", "我是谁", "李四");
        System.out.println(list);
        Stream<String> newlist = list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        });
        // 张三 张四 张无忌
        newlist.forEach((name) -> {
            System.out.println(name);
        });
        // 简化代码
        // 张三 张四
        list.stream().filter((name) -> name.startsWith("张")).filter((name) -> name.length() == 2).forEach((name) -> System.out.println(name));
        System.out.println(list);

        // Map获取流
        Map<String, String> map = new HashMap<>();
        map.put("111", "111");
        // 键流
        map.keySet().stream().forEach((key) -> System.out.println(key));
        // 值流
        map.values().stream().forEach((v) -> System.out.println(v));
        // 键值对
        map.entrySet().stream().forEach((kv) -> System.out.println(kv));

        //数组流
        Integer[] array = {1, 2, 3};
        Arrays.stream(array).forEach((v) -> System.out.println(v));
        Stream.of(array).forEach((v) -> System.out.println(v));


    }
}
