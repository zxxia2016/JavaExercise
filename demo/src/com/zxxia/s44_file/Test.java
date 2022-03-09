package com.zxxia.s44_file;

import java.io.File;

/**
 * File文件类
 * 目标：
 * 1. 定位文件：File类（代表文件、文件夹）：定位文件、获取文件本身信息、删除文件、创建文件（文件夹）；不能读写文件内容
 * 2.读写文件数据：IO流
 */
public class Test {
    public static void main(String[] args) {
        // File 构建的对象可以说文件夹和文件
        // 相对路径，相对模块路径
        File f = new File("./file.txt");
        System.out.println(f.exists());
        System.out.println(f.length());//13个字节，可以右击查看文件大小
        // 绝对路径，从盘符开始找
        File f1 = new File("D:/file.txt");

    }
}
