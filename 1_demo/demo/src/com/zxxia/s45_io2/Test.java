package com.zxxia.s45_io2;

import com.zxxia.iTest;

import java.io.*;

/**
 * 缓冲流
 * 1. 缓冲流：读取速度快，因为是有8k的缓冲区
 * ---字节缓冲输入流：BufferedInputStream;例子：BufferedStreamTest
 * ---字节缓冲输出流：BufferedOutputStream;例子：BufferedStreamTest
 * ---字符缓冲输入流：BufferedReader；例子:BufferedReaderTest
 * ---字符缓冲输入流：BufferedWriter；例子:BufferedWriterTest
 * 2. 可以对比缓冲流和基础流的性能；缓冲区默认1k比较好；
 * 3. 案例出师表：TODO
 * 转换流: 解决不同编码的乱码问题；相关：getBytes可以转换编码
 * 1. InputStreamReader:字符输入流转换
 * 1. OutputStreamReader
 * 对象序列化：对象存储到硬盘文件中去;例子：
 * 1. OjbectInputStream
 * 2. ObjectOutputStream
 * 3. implements Serializable
 * 4. transient属性
 * 5. 序列化版本管理数据
 * 打印流
 * 1. PrintStream: 方便高效地将数据打印到文件中，打印什么，文件中就是什么；例子：PrintStreamTest
 * 2. PrintWriter: 例子：PrintWriterTest
 * 3. 2者差别：只有write函数有区别：一个写字节，一个写字符；其余没差别
 * IO框架等
 */

class BufferedStreamTest implements iTest {
    @Override
    public void run() {
        String path = "file1.txt";
        String path1 = "file2.txt";
        File f = new File(path);
        System.out.println(f.getAbsolutePath());

        try (
                InputStream inputStream1 = new FileInputStream(path);
                BufferedInputStream inputStream = new BufferedInputStream(inputStream1);

                OutputStream outputStream1 = new FileOutputStream(path1);
                BufferedOutputStream outputStream = new BufferedOutputStream(outputStream1);
        ) {


            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            System.out.println("拷贝成功");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class BufferedReaderTest implements iTest {
    @Override
    public void run() throws Exception{
        String path = "file.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // 读取一行性能高，经典代码
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}

class BufferedWriterTest implements iTest {
    @Override
    public void run() throws Exception{
        String path = "file.txt";
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWrite = new BufferedWriter(fileWriter);
        bufferedWrite.write("abc我是中国工人");
        // 换行
        bufferedWrite.newLine();
        fileWriter.close();
        fileWriter.close();
    }
}

// 继承序列化
class Student implements Serializable {
    // 用来标识序列化版本
    private static final long serialVersionUID = 1;
    private String name;
    // transient属性：不会被序列化
    private transient String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student(String name) {
        this.name = name;
    }
}

class ObjectStreamTest implements iTest {
    @Override
    public void run() throws Exception {
        String path = "file1.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        Student s = new Student("zhangsan");
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
        System.out.println("序列化成功");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Student s1 = (Student) objectInputStream.readObject();
        if (s1 != null) {
            System.out.println(s1.getName());
        }
    }
}

class PrintStreamTest implements iTest {
    @Override
    public void run() throws Exception {
        String path = "file1.txt";
        // 追加
        FileOutputStream fileOutputStream = new FileOutputStream(path, true);
        PrintStream printStream = new PrintStream(fileOutputStream);
        //PrintStream printStream = new PrintStream(path);

        Student s = new Student("zhangsan");
        printStream.println("ddddddd");
        printStream.println(s);
        printStream.close();
    }
}

class PrintWriterTest implements iTest {
    @Override
    public void run() throws Exception {
        String path = "file3.txt";
        PrintWriter printStream = new PrintWriter(path);
        Student s = new Student("zhangsan");
        printStream.write("ddddddd");
        printStream.println(s);
        printStream.close();
    }
}

class PrintToFileTest implements iTest {
    @Override
    public void run() throws Exception {
        System.out.println("1111");
        System.out.println("22222");
        System.out.println("33333");

        // 改变输出流
        PrintStream printStream = new PrintStream("file4.txt");
        System.setOut(printStream);
        //会输出到文件中
        System.out.println("44444");
        System.out.println("55555");
    }
}


public class Test {
    public static void main(String[] args) throws Exception {
        BufferedStreamTest bufferedInputStream = new BufferedStreamTest();
        bufferedInputStream.run();

        BufferedReaderTest bufferedReaderTest = new BufferedReaderTest();
        bufferedReaderTest.run();

        BufferedWriterTest bufferedWriterTest = new BufferedWriterTest();
        bufferedWriterTest.run();

        ObjectStreamTest objectStreamTest = new ObjectStreamTest();
        objectStreamTest.run();

        PrintStreamTest printStreamTest = new PrintStreamTest();
        printStreamTest.run();

        PrintWriterTest printWriterTest = new PrintWriterTest();
        printWriterTest.run();

        PrintToFileTest printToFileTest = new PrintToFileTest();
        printToFileTest.run();
    }
}
