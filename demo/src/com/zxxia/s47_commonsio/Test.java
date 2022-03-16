package com.zxxia.s47_commonsio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * commons-io:Apache公司开发的
 * 官网：https://commons.apache.org/proper/commons-io/
 * 库文件：commons-io-2.11.0.jar
 * 1. 主要类
 * ---1. FileUtils
 * ---2. IOUtils
 *
 * nio：JAVA公司
 * 
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //复制文件
        IOUtils.copy(new FileInputStream("file1.txt"), new FileOutputStream("file11.txt"));
        // FileUtils.copyDirectory(new File("D:\\srcDir"), new File("d:\\DestDir"));
        // 删除所有文件夹
        // FileUtils.deleteDirectory("D:\\test");

        // JDK1.7 NIO2.0
        Files.copy(Path.of("D:\\srcDir"), Path.of("d:\\DestDir"));
        //删除空文件夹
        Files.deleteIfExists(Path.of("D:\\srcDir"));
    }
}
