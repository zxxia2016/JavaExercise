package com.zxxia.s5_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * zxxia
 */
public class TestArrayList {
    public static void main(String[] args) {
        //数组列表，可以存放任何类型
        ArrayList list = new ArrayList<>();
        list.add("aaa");
        list.add(111);


        //固定类型
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("11");
        list1.add("22");
        list1.add("33");
        System.out.println(list1);

        //根据索引获取
        list1.get(0);
        
        //获取长度
        list1.size();
        
        //遍历
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        //根据索引删除，如果索引越界会崩溃
        System.out.println("删除");
        String b = list1.remove(0);
        System.out.println(b);
        System.out.println(list1);
        //根据对象删除，如果有重复，删除第一个
        boolean b1 = list1.remove("22");
        System.out.println(b1);
        System.out.println(list1);

        //需求：删除低于80分的成绩
        ArrayList<Integer> scores = new ArrayList<Integer>();
        scores.add(98);
        scores.add(77);
        scores.add(99);
        scores.add(89);
        scores.add(79);
        scores.add(50);
        scores.add(100);
        System.out.println(scores);//[98, 77, 99, 89, 79, 50, 100]
        for (int i = 0; i < scores.size(); i++) {
            Integer score = scores.get(i);
            if (score < 80) {
                scores.remove(i);
            }
        }
        //严重错误
        System.out.println(scores);//[98, 99, 89, 50, 100]
        //正确做法
        for (int i = scores.size()-1; i >= 0; --i) {
            Integer score = scores.get(i);
            if (score < 80) {
                scores.remove(i);
            }
        }
        System.out.println(scores);

        //搜索分数50
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数字");
            int value = scanner.nextInt();
            for (int i = 0; i < scores.size(); i++) {
                int score = scores.get(i);
                if (score == value) {
                    System.out.println("找到了");
                    return;
                }
            }
            System.out.println("没找到，请重试");
        }

    }

}
