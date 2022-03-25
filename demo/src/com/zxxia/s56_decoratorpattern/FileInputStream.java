package com.zxxia.s56_decoratorpattern;
/**
 原始类
 */
public class FileInputStream extends InputStream {
    @Override
    public int read() {
        System.out.println("读取一个N个字节");
        return 1;
    }
}