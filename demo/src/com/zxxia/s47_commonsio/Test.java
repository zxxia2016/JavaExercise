package com.zxxia.s47_commonsio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * commons-io:Apache公司开发的
 * 官网：https://commons.apache.org/proper/commons-io/
 * 库文件：commons-io-2.11.0.jar
 * 1. 主要类
 * ---1. FileUtils
 * ---2. IOUtils
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //复制文件
        IOUtils.copy(new FileInputStream("file1.txt"), new FileOutputStream("file11.txt"));

    }
}
