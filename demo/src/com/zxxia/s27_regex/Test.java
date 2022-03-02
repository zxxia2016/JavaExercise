package com.zxxia.s27_regex;

import com.zxxia.iTest;

import java.util.Scanner;

/**
 * 正则表达式
 * 1. String.matches
 * 2. String.replaceAll
 * 3. String.split
 */

class MatchesTest implements iTest {

    @Override
    public void run() {
        System.out.println(checkQQ("132463"));
        Scanner scanner = new Scanner(System.in);
//        checkphone(scanner);
        checkEmail(scanner);
//        checkTell(scanner);
    }

    public boolean checkQQ(String strQQ) {
        return strQQ != null && strQQ.matches("\\d{6,15}");
    }

    public void checkphone(Scanner scanner) {
        while (true) {
            System.out.println("请输入手机号");
            String strPhone = scanner.next();
            if (strPhone.matches("1[3-9]\\d{9}")) {
                System.out.println("手机号输入成功");
                return;
            } else {
                System.out.println("错误手机号");
            }
        }
    }

    public void checkEmail(Scanner scanner) {
        while (true) {
            System.out.println("请输入邮箱");
            // 1234adf@qq.com
            // 1213@pci.com.cn
            // 2212@163.com
            String strPhone = scanner.next();
            if (strPhone.matches("\\w{1,30}@[a-zA-Z]{2,20}(\\.[a-zA-Z]{2,20}){1,2}")) {
                System.out.println("邮箱输入成功");
                return;
            } else {
                System.out.println("邮箱错误");
            }
        }
    }

    public void checkTell(Scanner scanner) {
        while (true) {
            System.out.println("请输入电话号码");
            // 021-12345683
            // 001132144
            String strPhone = scanner.next();
            if (strPhone.matches("\\d{2,6}-?\\d{5,20}")) {
                System.out.println("正确电话号码");
                return;
            } else {
                System.out.println("电话号码错误");
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MatchesTest matchesTest = new MatchesTest();
        matchesTest.run();
    }
}
