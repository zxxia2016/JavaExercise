package com.zxxia.s46_properties;

import com.zxxia.iTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Properties：写入或读取Properties文件
 * 1. 写入：WritePropertiesTest
 * 2. 读取
 */
class WritePropertiesTest implements iTest {
    @Override
    public void run() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("zhangsan", "18");
        properties.setProperty("lisi", "18");
        properties.setProperty("wangwu", "18");
        OutputStream outputStream = new FileOutputStream("file6.txt");
        properties.store(outputStream, "test");
        System.out.println("写入成功");
    }
}

class ReadPropertiesTest implements iTest {
    @Override
    public void run() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("file6.txt");
        properties.load(inputStream);
        System.out.println(properties.getProperty("zhangsan"));
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        WritePropertiesTest writePropertiesTest = new WritePropertiesTest();
        writePropertiesTest.run();

        ReadPropertiesTest readPropertiesTest = new ReadPropertiesTest();
        readPropertiesTest.run();
    }
}
