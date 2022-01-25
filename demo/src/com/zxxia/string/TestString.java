package com.zxxia.string;

import java.util.Random;
import java.util.Scanner;

/**
 * zxxia
 */
public class TestString {
    public static void main(String[] args) {
        // String 对象不可变对象

        //创建对象
        String str = "String";
        char[] charArray = {'1', '2'};
        String str1 = new String(charArray);
        String str2 = new String(str);
        byte[] intArray = {111, 2, 3};
        String str3 = new String(intArray);
        String str4 = new String(intArray);
        //每个String都是新对象
        System.out.println(str3 == str4);   //false

        //常见面试题1
        String str5 = new String("abc");    //创建了2个对象，字符串常量池1个，堆内存1个
        String str6 = "abc";    //创建0个对象，因为acb字符串在上一局已经创建过了，这边只是引用

        //常见面试题2
        String str7 = "abcd";
        String str8 = "abc";
        String str9 = str8 + 'd';
        System.out.println(str7 == str9); //false
        String str10 = "a" + "b" + "c";
        System.out.println(str8 == str10); //true 编译阶段就会把这代码优化成abc

        //常用API
        //字符串比较
        System.out.println(str7.equals(str10));
        System.out.println(str7.equalsIgnoreCase(str10));
        System.out.println(str7.contains("a")); //true
        System.out.println(str7.startsWith("bcd")); //false
        //遍历
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }
        //截取 左闭右开
        String sbstring = str.substring(0,2);
        System.out.println(sbstring);
        String sbstring1 = str.substring(2);
        System.out.println(sbstring1);
        //拆分
        String strName = "jack,mary,jhon";
        String[] names = strName.split(",");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        //替换
        String str11 = str1.replace("1", "2");
        System.out.println(str11);

        //随机验证码
        String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        String showCode = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(allCode.length());
            showCode += allCode.charAt(index);
        }
        System.out.println(showCode);

        //登录密码判断
        String acc = "zxxia";
        String psw = "123456";
        Scanner scanner = new Scanner(System.in);
        int MaxCount = 0;
        boolean bool = false;
        while (bool) {
            MaxCount++;
            System.out.println("请输入账号");
            String a = scanner.next();
            System.out.println("请输入密码");
            String p = scanner.next();
            if (a.equals(acc) &&p.equals(psw)) {
                System.out.println("登录成功");
                break;
            }
            if (!a.equals(acc)) {
                System.out.println("账号错误");
            }
            else if (!p.equals(psw)) {
                System.out.println("密码错误");
            }
            if (MaxCount >= 3) {
                System.out.println("最多输入错误3次");
                break;
            }
        }

        //屏蔽手机号 134****5678
        System.out.println("请输入手机号");
        String strPhone = scanner.next();
        String a = strPhone.substring(0,3);
        String b = strPhone.substring(7);
        String strR = a + "****" + b;
        System.out.println(strR);

    }
}
