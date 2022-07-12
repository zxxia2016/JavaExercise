package com.zxxia.s48_thread;

/**
 * Thread常用API说明
 * 1. getName;
 * 2. setName;
 * 4. currentThread：获取当前线程对象
 * 5. sleep：休眠线程：代码不执行了；让出CPU的执行时间
 */
class MyThread extends Thread {
    // 取名字
    MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("我是线程：" + Thread.currentThread().getName());
        }
    }
}
class SleepThreadTest extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (3 == i) {
                    Thread.sleep(3000);
                }
                System.out.println("SleepThreadTest线程：" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Thread thread = new MyThread("1号");
        thread.start();

        Thread thread1 = new MyThread("2号");
        thread1.start();

        Thread thread2 = Thread.currentThread();
        thread2.setName("主线程");
        for (int i = 0; i < 5; i++) {
            System.out.println("我是线程：" + thread2.getName());
        }

        SleepThreadTest test = new SleepThreadTest();
        test.start();
    }
}
