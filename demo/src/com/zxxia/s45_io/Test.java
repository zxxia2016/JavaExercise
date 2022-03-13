package com.zxxia.s45_io;

import com.zxxia.iTest;

import java.io.*;
import java.util.Arrays;

/**
 * IO
 * 1.字符集
 * - charset 字符集基础知识：字符 一一对应 二级制
 * ---ASCII编码（字符集）：1个字节就可以表示
 * ---GBK（中国人）：包含几万汉字，兼容ASCII表：2个字节就可以存储
 * ---Unicode编码（全世界），业界标准，万国码：变种：UTF-8、UTF-16、UTF-32；UTF-8：3个字节表示，2的24次方，千万数量
 * - 字符集编码、解码操作：String
 * ---GetBytes:默认编码（UTF-8），也可以填入编码方式
 * ---String构造器，填入解码方式
 * 2. IO体系：
 * - 按流的方向分
 * --- I表示input，输入流，硬盘或网络读取数据到内存
 * --- O表示output，输出流，写数据到硬盘或网络
 * -按单位分
 * ---字节流：视频数据
 * ------字节输入流：InputStream（抽象类）
 * ------字节输出流: OutputStream（抽象类）
 * ---字符流：文本内容
 * ------字符输入流: Reader（抽象类）
 * ------字符输出流: Writer（抽象类）
 * 3. IO使用：字节流，会出现字符乱码问题，得用字符流
 * ---1. FileInputStream：例子：FileInputStreamTest，构造器，read(每次读取1字节、读取字节数组）;读取中文会输出乱码
 * ---2. FileOutputStream:例子：OutputFileStreamTest；
 * ---3. FileReader：例子：FileReaderTest
 * ---4. FileWriter: 例子：FileWriter
 * 4. 案例：文件复制：CopyFileTest
 * 5.  案例：资源自动释放：ResourceReleaseTest，有关异常的时候，文件自动释放
 */

class CharSetTest implements iTest {
    @Override
    public void run() {
        // 1. 编码：把文字转换成字节，默认UTF-8
        String name = "abc我爱你中国";
        //UTF-8
        byte[] bytes = name.getBytes();
        // 18=3+5*3
        System.out.println(bytes.length);
        // [97, 98, 99, -26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67]
        System.out.println(Arrays.toString(bytes));

        try {
            // 2. GBK编码：把文字转换成字节
            byte[] bytes1 = name.getBytes("GBK");
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

class FileInputStreamTest implements iTest {
    @Override
    public void run() {
        try {
            System.out.println("------------------------FileInputStreamTest-----------------------");
            InputStream inputStream = new FileInputStream("E:\\GitHub\\JavaExecise\\file.txt");
            System.out.println((char) inputStream.read());//#
            // 读取结束返回-1
            int r = -1;
            while (true) {
                r = inputStream.read();
                if (r == -1) {
                    break;
                }
                // System.out.println((char) r);
            }
            String path = "E:\\GitHub\\JavaExecise\\file.txt";
            File f = new File(path);
            System.out.println(f.length());
            InputStream inputStream1 = new FileInputStream(path);
            byte[] buffer = new byte[(int) f.length()]; //1kb
            int length = inputStream1.read(buffer);
            String rs = new String(buffer, 0, length);
            System.out.println(rs);

            InputStream inputStream2 = new FileInputStream(path);
            byte[] data = inputStream2.readAllBytes();
            String rs1 = new String(data, 0, data.length);
            System.out.println(rs1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class OutputFileStreamTest implements iTest {
    @Override
    public void run() throws Exception {
        try {
            String path = "E:\\GitHub\\JavaExecise\\file1.txt";

            // 先清空之前的数据，这是覆盖管道；
            // 追加管道
            // OutputStream outputStream = new FileOutputStream(path, true);
            // outputStream.write(1);
            OutputStream outputStream = new FileOutputStream(path);
            outputStream.write('a');
            outputStream.write("\r\n".getBytes());
            int a = 'b';
            System.out.println(a);

            byte[] data = {'a', 98, 99};
            outputStream.write(data);
            byte[] data1 = "我是中国人".getBytes();
            outputStream.write(data1);

            // outputStream.flush();
            outputStream.close(); // 包含flush

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class CopyFileTest implements iTest {
    @Override
    public void run() throws IOException {
        String path = "E:\\GitHub\\JavaExecise\\file1.txt";
        String path1 = "E:\\GitHub\\JavaExecise\\file2.txt";
        InputStream inputStream = new FileInputStream(path);
        OutputStream outputStream = new FileOutputStream(path1);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
        System.out.println("拷贝成功");
    }
}

class MyConnection implements AutoCloseable {

    @Override
    public void close() throws IOException {
        System.out.println("自动释放");
    }
}

class ResourceReleaseTest implements iTest {
    @Override
    public void run() {
        this.codeBlock1();
        this.codeBlock2();
    }

    void codeBlock1() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String path = "E:\\GitHub\\JavaExecise\\file1.txt";
            String path1 = "E:\\GitHub\\JavaExecise\\file2.txt";
            inputStream = new FileInputStream(path);
            outputStream = new FileOutputStream(path1);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            // 如果这里出现异常，资源没法释放
//            int a = 0;
//            int b = 1 / a;
//            System.out.println("除0这里不会执行");
            outputStream.close();
            inputStream.close();
            System.out.println("codeBlock1 拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("codeBlock1 成功释放资源");
        }
    }

    void codeBlock2() {
        // jdk7开始的写法
        String path = "E:\\GitHub\\JavaExecise\\file1.txt";
        String path1 = "E:\\GitHub\\JavaExecise\\file2.txt";
        try (
                // 因为实现了Closeable接口，才可以放在这里
                FileInputStream inputStream = new FileInputStream(path);
                FileOutputStream outputStream = new FileOutputStream(path1);
                MyConnection c = new MyConnection();
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("codeBlock2 拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileReaderTest implements iTest {
    @Override
    public void run() {
        String path = "E:\\GitHub\\JavaExecise\\file.txt";

        try {
            FileReader fileReader = new FileReader(path);
            // 读取单个字符,以字符为单位,返回字符编码
            int code;
            while ((code = fileReader.read()) != -1) {
                System.out.println((char) code);
            }
            // 以buffer来存放字符
            FileReader fileReader1 = new FileReader(path);
            char[] buffer = new char[1024];
            int length;
            while ((length = fileReader1.read(buffer)) != -1) {
                String s = new String(buffer, 0 , length);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class FileWriteTest implements iTest {
    @Override
    public void run() throws Exception {
        String path = "E:\\GitHub\\JavaExecise\\file1.txt";

        try {
            FileWriter fileWriter = new FileWriter(path);
            // FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(1);
            fileWriter.write("dddd");
            fileWriter.write("\r\n");

            fileWriter.write("我是中国人");
            fileWriter.flush();
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        CharSetTest charSetTest = new CharSetTest();
        charSetTest.run();

        FileInputStreamTest fileInputStreamTest = new FileInputStreamTest();
        fileInputStreamTest.run();

        OutputFileStreamTest outputFileStreamTest = new OutputFileStreamTest();
        outputFileStreamTest.run();

        CopyFileTest copyFileTest = new CopyFileTest();
        copyFileTest.run();

        ResourceReleaseTest resourceReleaseTest = new ResourceReleaseTest();
        resourceReleaseTest.run();

        FileReaderTest fileReaderTest = new FileReaderTest();
        fileReaderTest.run();

        FileWriteTest fileWriteTest = new FileWriteTest();
        fileWriteTest.run();
    }
}
