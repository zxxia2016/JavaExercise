package com.zxxia.s41_exception;

import com.zxxia.iTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常：数组越界，空指针，数学操作、类型转换、数字转换等
 * 1. 没有出现异常，输出异常信息，JVM虚拟机会终止程序
 * 异常体系：Throwable
 * ---Error
 * ---Exception
 * ------RuntimeException，例子：RumtimeExceptionTest
 * ------RuntimeException之外的异常: 编译时异常：日期格式化异常,例子：CompileExceptionTest
 * ------------出现异常抛给调用者 throws Exception
 * ------------出现异常自己捕获处理 try... catch...
 * ------------两者相结合
 *
 */

class RumtimeExceptionTest implements iTest {

    @Override
    public void run() {
        // 数组越界 ArrayIndexOutOfBoundsException
        //int[] array = {1, 2, 3};
        //System.out.println(array[3]);
        //System.out.println("这里执行不了了；");

        // 空指针 NullPointerException
        String name = null;
        // System.out.println(name.length());

        // 类型转换 ClassCastException
        Object o = 23;
        // String s = (String) o;

        // 数学操作 ArithmeticException
        // int c = 10 / 0;

        // 数字转换 NumberFormatException
        String number = "ss22";
        // Integer.valueOf(number);
    }
}
class CompileExceptionTest {
    void run() throws ParseException, FileNotFoundException {
        String date = "2015-12-12 10:00:00";
        // 自动添加 ParseException
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse(date);
        System.out.println(d);

         // InputStream inputStream = new FileInputStream("E:/美女.png");
    }
    void run1() {
        try {
            InputStream inputStream = new FileInputStream("E:/美女.png");
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        RumtimeExceptionTest rumtimeExceptionTest = new RumtimeExceptionTest();
        rumtimeExceptionTest.run();

        CompileExceptionTest compileExceptionTest = new CompileExceptionTest();
        compileExceptionTest.run();
        compileExceptionTest.run1();
        System.out.println("--------------------main end----------------------");
    }
}
