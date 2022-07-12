package com.zxxia.s38_unmodifiablecollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 不可变集合
 * 1. List.of 目前看JDK8还没有，用16是有的
 */
public class Test {
    public static void main(String[] args) {
        // 不可变List
        List<Integer> list = List.of(8, 9, 10);
        // 这是不可变集合，这代码会报错
        // list.set(2, 1);
        // list.add(11);

        //不可变Set
        Set<String>  set = Set.of("zhangsan", "lisi");
        // 这是不可变集合，这代码会报错
        // set.add("wangwu");

        // 不可变Map
         Map<String, Integer> map = Map.of("zhangsan", 3);
    }
}
