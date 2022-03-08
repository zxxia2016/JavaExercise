package com.zxxia.s40_stream;

import com.zxxia.iTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream:简化集合和数组操作,不改变原有结构；链式操作
 * 1. 传送带一样的流水线
 * ---获取流：获取方法，任何集合通过Stream()
 * ---中间流:常用API
 * ------foreach
 * ------count
 * ------limit
 * ------skip
 * ------map
 * ------concat
 * ---终结方法,不会返回Stream，所以不能继续链式操纵
 * ------foreach
 * ------count
 * 2. 案例：SolutionTest
 * 3. 目的：流转集合或者数组，因为这是别人是常用
 * ---流只能使用一次
 */
// 合并员工数据
class SolutionTest implements iTest {

    class Employee {
        String name;
        char sex;
        double salary;
        double bonus;
        String punish;

        public Employee(String name, char sex, double salary, double bonus, String punish) {
            this.name = name;
            this.sex = sex;
            this.salary = salary;
            this.bonus = bonus;
            this.punish = punish;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", sex=" + sex +
                    ", salary=" + salary +
                    ", bonus=" + bonus +
                    ", punish='" + punish + '\'' +
                    '}';
        }
    }

    class Topperformer extends Employee {
        public Topperformer(String name, char sex, double salary, double bonus, String punish) {
            super(name, sex, salary, bonus, punish);
        }
    }

    Double _totoal = 0.0;

    @Override
    public void run() {
        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒", '男', 30000, 1000, null));
        one.add(new Employee("猪八戒1", '男', 20000, 1000, "顶撞上司"));
        one.add(new Employee("猪八戒2", '男', 10000, 1000, null));
        one.add(new Employee("猪八戒3", '男', 5000, 1000, null));
        one.add(new Employee("猪八戒4", '男', 300, 1000, null));

        // 最高工资的原因，分装成优秀员工对象Topperformer
        one.stream().max((e1, e2) -> Double.compare(e1.salary + e1.bonus, e2.salary + e2.bonus)).map((max -> new Topperformer(max.name, max.sex, max.salary, max.bonus, max.punish)));
        // 分别统计2个部分的平局月收入，要求去掉最高和最低工资
        // 先排序，去掉第一个，再数量限制，再遍历累加
        one.stream().sorted((e1, e2) -> Double.compare(e1.salary + e1.bonus, e2.salary + e2.bonus)).skip(1).limit(one.size() - 2).forEach(employee -> {
            _totoal += employee.salary;
        });
        Double average = _totoal / (one.size() - 2);
        System.out.println("平局工资：" + average);

        BigDecimal bigDecimal = BigDecimal.valueOf(_totoal);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(one.size() - 2);
        System.out.println("平局工资1：" + bigDecimal.divide(bigDecimal1, 2, RoundingMode.FLOOR));


        List<Employee> two = new ArrayList<>();
        two.add(new Employee("孙悟空", '男', 30000, 1000, null));
        two.add(new Employee("孙悟空1", '男', 20000, 1000, "找茬"));
        two.add(new Employee("孙悟空2", '男', 10000, 1000, null));
        two.add(new Employee("孙悟空3", '男', 5000, 1000, null));
        two.add(new Employee("孙悟空4", '男', 300, 1000, null));

        // 统计2个部分平局工资，去掉最高最低的平均值
        //合并
        Stream.concat(one.stream(), two.stream());

    }
}

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

        //取前2个
        System.out.println("取前2个");
        //张无忌
        //我是谁
        list.stream().filter(name -> name.length() == 3).limit(2).forEach(name -> System.out.println(name));

        //跳过前2个
        System.out.println("跳过前2个");
        //张无忌
        list.stream().filter(name -> name.startsWith("张")).skip(2).forEach(name -> System.out.println(name));

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

        long count = Stream.of(array).count();

        // 不改变元数据
        //黑马的：张三
        //黑马的：张四
        //黑马的：张无忌
        //黑马的：我是谁
        //黑马的：李四
        list.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "黑马的：" + s;
            }
        }).forEach(a -> System.out.println(a));
        // 简化
        list.stream().map(name -> "黑马的" + name);

        class Student {
            String name;

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        '}';
            }

            Student(String name) {
                this.name = name;
            }
        }
        //Student{name='张三'}
        //Student{name='张四'}
        //Student{name='张无忌'}
        //Student{name='我是谁'}
        //Student{name='李四'}
        list.stream().map(name -> new Student(name)).forEach(s -> System.out.println(s));

        //合并流
        Stream s = Stream.of("Java", "pthon");
        Stream s1 = Stream.of("C++", "html");
        Stream s2 = Stream.concat(s1, s);
        // s2.toList() s2.toArray()

        s2.forEach(b -> System.out.println(b));
        // 流只能使用一次 ，这里报错：stream has already been operated upon or closed
        // System.out.println(Arrays.toString(s2.toArray()));
        // 返回的是不可变集合，无法修改内容
        // s2.toList().add("Go");
        // 要返回可变，如下操纵
        Stream s3 = Stream.of("Java3", "pthon3");
        List<String> asList = (List<String>) s3.collect(Collectors.toList());
        asList.add("go3");
        // [Java3, pthon3, go3]
        System.out.println(asList);

        SolutionTest solutionTest = new SolutionTest();
        solutionTest.run();
    }
}
