package com.zxxia.s30_lambda;

import com.zxxia.iTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Java8特性：Lambda表达式：作用：简化匿名类的代码写法，只能简化函数式接口
 * 什么是函数式接口：1. 必须是接口，其次有且只有一个方法 2. 通常会在接口上加@FunctionalInterface注解
 * 例子如下：LambdaTest
 */
@FunctionalInterface
interface Swimming {
    void swim();
}

class LambdaTest implements iTest {

    @Override
    public void run() {
        //简化匿名函数
        Swimming s = () -> {
            System.out.println("老师游泳");
        };
        go(s);
    }

    public void go(Swimming s) {
        s.swim();
    }
}

public class Test {
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.run();

        Integer[] ages = {22, 3};
        Arrays.sort(ages, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        System.out.println(Arrays.toString(ages));
        Integer[] ages1 = {22, 3};
        Arrays.sort(ages1, (Integer integer, Integer t1) -> {
            return integer - t1;
        });
        // 更加简化
        Arrays.sort(ages1, (integer, t1) -> {
            return integer - t1;
        });
        //更加简化
        Arrays.sort(ages1, (integer, t1) -> integer - t1);
        //如果只有一个参数，只要写一个变量
        JButton button = new JButton("大按钮");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("点我");
            }
        });
        // 更加简化
        button.addActionListener(actionEvent -> System.out.println("点我"));

        System.out.println(Arrays.toString(ages1));

    }


}

