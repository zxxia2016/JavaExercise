package com.zxxia.s27_regex;

import com.zxxia.iTest;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式：文档查看Pattern类
 * 1. String.matches, Exp: MatchesTest
 * 2. String.replaceAll, Exp：SplitReplaceAllTest
 * 3. String.split, Exp：SplitReplaceAllTest
 * 4. 案例：爬虫, Exp：SpiderTest
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

class SplitReplaceAllTest implements iTest {
    @Override
    public void run() {
        String strName = "神雕侠侣222www天龙八部222dddd射雕英雄传";
        String[] arr = strName.split("\\w+");
        // 神雕侠侣   天龙八部    射雕英雄传
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        String names = strName.replaceAll("\\w+", ":");
        System.out.println(names);       //神雕侠侣:天龙八部:射雕英雄传
    }
}

//需求：从上面的内容中爬取出 电话号码和邮箱。
class SpiderTest implements iTest {

    @Override
    public void run() {
        String rs = "来黑马程序学习Java,电话020-43422424，或者联系邮箱" +
                "itcast@itcast.cn,电话18762832633，0203232323" +
                "邮箱bozai@itcast.cn，400-100-3233 ，4001003232";
        // 1. 定义爬虫规则
        String regex = "(\\w{1,30}@[a-zA-Z]{2,20}(\\.[a-zA-Z]{2,20}){1,2})|(1[3-9]\\d{9})|(\\d{2,6}-?\\d{5,20})|(400-?\\\\d{3,9}-?\\\\d{3,9})";
        // 2. 把规则编译成匹配对象
        Pattern pattern = Pattern.compile(regex);
        // 3. 匹配对象匹配字符串，得到匹配器对象
        Matcher matcher = pattern.matcher(rs);
        // 4. 遍历匹配器
        while (matcher.find()) {
            String result = matcher.group();
            System.out.println(result);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MatchesTest matchesTest = new MatchesTest();
//        matchesTest.run();
        SplitReplaceAllTest splitReplaceAllTest = new SplitReplaceAllTest();
        splitReplaceAllTest.run();
        SpiderTest spiderTest = new SpiderTest();
        spiderTest.run();
    }
}
