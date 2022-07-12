package com.zxxia.s35_collections;

import com.zxxia.iTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections：常用工具类之一
 * 1. addAll 添加元素
 * 2.shuffle 打乱顺序
 * 3. sort 排序
 */
class CollectionsTest implements iTest {


    @Override
    public void run() {
        List names = new ArrayList();
        Collections.addAll(names, "dddd", "eeee");
        Collections.addAll(names, new String[]{"fffff", "gggg"});
        // [dddd, eeee, fffff, gggg]
        System.out.println(names);

        // 乱序
        Collections.shuffle(names);
        System.out.println(names);

        Collections.sort(names);
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String s, String t1) {
//                return (int)s.charAt(0) > (int) t1.charAt(0);
//            }
//        });
        System.out.println(names);
    }
}

public class Test {
    public static void main(String[] args) {
        CollectionsTest collectionsTest = new CollectionsTest();
        collectionsTest.run();
    }
}
