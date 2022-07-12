package com.zxxia.s37_map;


import com.zxxia.iTest;

import java.util.*;

/**
 * Map：键值对
 * ---HashMap：无序，无索引，不重复，值不做要求; 底层原理：哈希表；HashSet底层也是HashMap
 * ---LinkedHashMap: 有序（添加顺序），无索引，不重复，值不做要求；底层原理：哈希表+双链表;例子：LinkedHashMapTest
 * ---TreeMap: 排序，无索引，不重复，值不做要求：例子：TreeMapTest
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
 * ---keySet
 * ---entrySet
 * ---map.forEach(Lambda)
 * 3. 案例：统计投票人数:TouPiaoSystem
 * 4. HashMap依赖hashCode和Equals方法保证键的唯一
 * 5. Map嵌套
 */

class APITest implements iTest {

    @Override
    public void run() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Java", 2);
        map.put("Python", 3);
        map.put(null, null);
        // {null=null, Java=2, Python=3}
        System.out.println(map);
        Map<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("Java2", 1);
        map1.put("Java3", 2);
        map1.put("Python", 3);
        map1.put(null, null);
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
        map.forEach((String key, Integer vale) -> {
            System.out.println(key);
            System.out.println(vale);
        });
    }
}

// Map 投票系统，景点A、B、C、D；80个学生选择一个景点；统计每个景点的投票数量
class TouPiaoSystem implements iTest {
    @Override
    public void run() {
        String[] selectors = {"A", "B", "C", "D"};
        Map<String, Integer> map = new HashMap<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            String s = selectors[r.nextInt(selectors.length)];
            Integer v = map.get(s);
            // map.containsKey(s);
            if (v == null) {
                map.put(s, 1);
            } else {
                map.put(s, ++v);
            }
        }
        System.out.println(map);
        // new HashSet<String>();
    }
}

// Map 投票系统，景点A、B、C、D；80个学生选择多个景点；统计每个景点的投票数量

class TouPiaoSystem2 implements iTest {
    @Override
    public void run() {
        Map<String, Set<String>> map = new HashMap<>();
        HashSet set = new HashSet<String>();
        Collections.addAll(set, "A", "B");
        map.put("张三", set);

        HashSet set1 = new HashSet<String>();
        Collections.addAll(set1, "A", "B");
        map.put("李四", set1);

        HashSet set2 = new HashSet<String>();
        Collections.addAll(set2, "A", "B");
        map.put("王五", set2);

        Map<String, Integer> map1 = new HashMap<>();
        // 遍历上面的数据，统计即可
        // map.values()

    }
}

class UniqueKeyMapTest implements iTest {

    class Student {
        String name;
        int age;
        String sex;

        public Student(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name) && Objects.equals(sex, student.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }

    @Override
    public void run() {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("张三", 20, "nan"), "上海");
        map.put(new Student("张三", 20, "nan"), "上海");
        map.put(new Student("李四", 22, "nan"), "上海");
        // {Student{name='张三', age=22, sex='nan'}=上海, Student{name='张三', age=20, sex='nan'}=上海}
        System.out.println(map);
    }
}

class LinkedHashMapTest implements iTest {
    @Override
    public void run() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Java", 1);
        map.put("Java", 2);
        map.put("Python", 1);
        map.put("C++", 1);
        // 按放入顺序 {Java=2, Python=1, C++=1}
        System.out.println(map);
    }
}

class TreeMapTest implements iTest {
    @Override
    public void run() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "张三");
        map.put(13, "李四");
        map.put(2, "王五");
        map.put(6, "张三");
        // {1=张三, 2=王五, 6=张三, 13=李四} 自动升序排序；复杂类型参考s31中的TreeSet
        System.out.println(map);

        class Apple implements Comparable<Apple> {
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

        Map<Apple, String> map1 = new TreeMap<>(new Comparator<Apple>() {
            @Override
            public int compare(Apple apple, Apple t1) {
                return apple.weight - t1.weight;
                // return Double.compare(apple.price, t1.price);
            }
        });
        map1.put(new Apple("红富士", "红色", 9.9, 500), "上海3");
        map1.put(new Apple("青苹果", "青色", 19.9, 500), "上海4");
        map1.put(new Apple("蛇果", "红色", 3.9, 200), "上海5");
        map1.put(new Apple("绿", "绿色", 9.9, 500), "上海6");
        map1.put(new Apple("红富士", "红色", 9.9, 500), "上海7");
        // {Apple{name='蛇果', color='红色', price=3.9, weight=200}=上海5, Apple{name='红富士', color='红色', price=9.9, weight=500}=上海7}
        System.out.println(map1);
    }
}

public class Test {
    public static void main(String[] args) {
        APITest apiTest = new APITest();
        apiTest.run();

        TouPiaoSystem touPiaoSystem = new TouPiaoSystem();
        touPiaoSystem.run();

        TouPiaoSystem2 touPiaoSystem2 = new TouPiaoSystem2();
        touPiaoSystem2.run();

        UniqueKeyMapTest uniqueKeyMapTest = new UniqueKeyMapTest();
        uniqueKeyMapTest.run();

        LinkedHashMapTest linkedHashMapTest = new LinkedHashMapTest();
        linkedHashMapTest.run();

        TreeMapTest treeMapTest = new TreeMapTest();
        treeMapTest.run();
    }
}
