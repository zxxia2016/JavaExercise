package com.zxxia.s48_thread;

import com.zxxia.iTest;

/**
 * 多线程的创建：把主线程的任务放在子线程前面；否则导致一直跑主线程；
 * 1. 继承Thread类：java.lang.Thread类
 * ---用法：看类：ChildThread；1. new ChildThread；2.调用start方法
 * ---优点：编码简单
 * ---缺点：已继承Thread，无法继承其他类，不利于扩展
 * 2.实现Runnable接口类: 线程任务
 * ---用法：看类：ChildRunnable；1. new Thread(ChildRunnable)；2.调用start方法
 * ---优点：可以继承其它类，扩展性更强
 * ---缺点：如果线程有执行结果，是不能直接返回的；只能跑功能性的线程
 * 3. Runnable匿名对象
 *---用法：RunnableTest
 * 4. JDK5.0,实现Callable接口，来由：前2个方法不能返回结果
 * ---用法：创建线程任务：实现Callable接口类，重写call方法
 */
class ChildThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println("我是子线程");
        }
//        while (true) {
//            System.out.println("我是子线程");
//        }

    }
}

class ChildRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("我是子线程1");
        }
    }
}

class RunnableTest implements iTest {
    @Override
    public void run() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("我是子线程2");
                }
            }
        };
        new Thread(runnable).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("我是子线程3");
            }
        } ).start();
    }
}
public class Test1 {
    public static void main(String[] args) throws Exception {
        ChildThread childThread = new ChildThread();
        childThread.start();

        ChildRunnable childRunnable = new ChildRunnable();
        new Thread(childRunnable).start();

        RunnableTest test = new RunnableTest();
        test.run();

        for (int i = 0; i < 5; i++) {
            System.out.println("我是主线程");
        }
    }
}
