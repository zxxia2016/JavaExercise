package com.zxxia.s45_io;

import com.zxxia.iTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * IO
 * 1. charset 字符集基础知识：字符 一一对应 二级制
 * ---ASCII编码（字符集）：1个字节就可以表示
 * ---GBK（中国人）：包含几万汉字，兼容ASCII表：2个字节就可以存储
 * ---Unicode编码（全世界），业界标准，万国码：变种：UTF-8、UTF-16、UTF-32；UTF-8：3个字节表示，2的24次方，千万数量
 * 2. 字符集编码、解码操作：String
 * ---GetBytes:默认编码（UTF-8），也可以填入编码方式
 * ---String构造器，填入解码方式
 */

class CharSetTest implements iTest {
    @Override
    public void run() {
        // 1. 编码：把文字转换成字节，默认UTF-8
        String name = "abc我爱你中国";
        //UTF-8
        byte[]  bytes = name.getBytes();
        // 18=3+5*3
        System.out.println(bytes.length);
        // [97, 98, 99, -26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes));

        try {
            // 2. GBK编码：把文字转换成字节
            byte[]  bytes1 = name.getBytes("GBK");
            // 13
            System.out.println(bytes1.length);
            // [97, 98, 99, -50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
            System.out.println(Arrays.toString(bytes1));
            // 3. GBK解码
            String name1 = new String(bytes1, "GBK");
            System.out.println(name1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
public class Test {
    public static void main(String[] args) {
        CharSetTest charSetTest = new CharSetTest();
        charSetTest.run();
    }
}
