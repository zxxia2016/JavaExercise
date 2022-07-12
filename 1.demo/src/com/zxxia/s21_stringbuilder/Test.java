package com.zxxia.s21_stringbuilder;

/**
 * StringBuilder
 * 1. StringBuilder是字符串处理工具，目标是转成String
 * 2. 性能比String高，因为指挥产生一个StringBuilder对象
 */

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //拼接
        sb.append("a").append(5).append(6);
        //反转
        sb.reverse();
        //长度
        sb.length();
        //转成String
        sb.toString();
        System.out.println(sb);
    }
}
