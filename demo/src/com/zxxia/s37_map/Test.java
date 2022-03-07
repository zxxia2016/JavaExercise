package com.zxxia.s37_map;


import com.zxxia.iTest;

import java.util.*;

/**
 * Map：键值对
 * ---HashMap：无序，无索引，不重复，值不做要求
 * ---LinkedHashMap: 有序，无索引，不重复，值不做要求
 * ---TreeMap: 排序，无索引，不重复，值不做要求
 * 1. 常用API：官方看文档
 * ---put get
 * ---remove
 * ---clear
 * ---containsKey
 * ---containsValue
 * ---isEmpty
 * ---size
 * ---keySet
 * 2. 遍历
 * ---
 */

class APITest implements iTest {

    @Override
    public void run() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Java", 2);
        map.put("Python",3);
        map.put(null,null);
        // {null=null, Java=2, Python=3}
        System.out.println(map);
        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("Java2", 1);
        map1.put("Java3", 2);
        map1.put("Python",3);
        map1.put(null,null);
        // {Java2=1, Java3=2, Python=3, null=null}
        System.out.println(map1);

        System.out.println(map.keySet());

        Collection v = map.values();
        System.out.println(v);

        //合并
        map1.putAll(map);
        // {null=null, Java=2, Python=3}
        System.out.println(map);
        // {Java2=1, Java3=2, Python=3, null=null, Java=2}
        System.out.println(map1);

        // 遍历1
        Set keys = map.keySet();
        for (Object key : keys) {
            map.get(key);
        }
        // 遍历2
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        // 遍历3 JDK8 Lambda
        map.forEach((String key , Integer vale) -> {
            System.out.println(key);
            System.out.println(vale);
        });
    }
}
public class Test {
    public static void main(String[] args) {
        APITest apiTest = new APITest();
        apiTest.run();
    }
}
