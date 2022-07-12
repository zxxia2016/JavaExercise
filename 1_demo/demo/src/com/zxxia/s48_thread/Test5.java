package com.zxxia.s48_thread;


import com.zxxia.iTest;

import java.util.concurrent.*;

/**
 * 线程池:复用线程技术：工作线程或核心线程；处理工作队列
 * 原因：创建新线程开销很大
 * 1. 如何创建线程池
 * ---方式1：ExecutorService的实现类：ThreadPoolExecutor
 * ---方式2：Executor（工具类）
 * 2. 线程池常见面试题
 * ---临时线程何时创建
 * -----核心线程在忙且任务队列满了；并且还还可以创建临时线程的时候创建
 * ---什么时候拒绝任务
 * -----核心线程和临时线程忙，任务队列满了；
 * 3. 例子：ThreadPoolTest：没有返回值的线程池
 * 4. 例子：ThreadPoolTest1：有返回值的线程池；返回值会阻塞当前线程；可以看下例子；
 */


class MyCallable implements Callable<String> {

    private final int n;

    MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        long sum = 0;
        for (int i = 0; i < this.n; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "休眠");
        // 1000秒
        Thread.sleep(1000 * 1000);
        return Thread.currentThread().getName() + ", " +this.n + "的总和为: " + sum;
    }
}

class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println(Thread.currentThread().getName() + "MyRunable task" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "休眠");
            // 1000秒
            Thread.sleep(1000 * 1000);
            System.out.println(Thread.currentThread().getName() + "休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadPoolTest1 implements iTest {
    @Override
    public void run() throws Exception {
        int corePoolSize = 3;
        int maximumPoolSize = 5;
        long keepAliveTime = 6;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue workQueue = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler handler1 = new ThreadPoolExecutor.DiscardPolicy();
        RejectedExecutionHandler handler2 = new ThreadPoolExecutor.DiscardOldestPolicy(); //忽略最久执行策略
        RejectedExecutionHandler handler3 = new ThreadPoolExecutor.CallerRunsPolicy(); //调用线程执行策略
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        Future<String> future = threadPoolExecutor.submit(new MyCallable(100));
        //这里阻塞住了；后面的线程人执行不了
        System.out.println(System.currentTimeMillis() + ": " +future.get());

        Future<String> future1 = threadPoolExecutor.submit(new MyCallable(1000));
        System.out.println(System.currentTimeMillis() + ": " +future1.get());

        Future<String> future2 = threadPoolExecutor.submit(new MyCallable(10000));
        System.out.println(System.currentTimeMillis() + ": " +future2.get());

        Future<String> future3 = threadPoolExecutor.submit(new MyCallable(1000));
        System.out.println(System.currentTimeMillis() + ": " +future3.get());

        Future<String> future4 = threadPoolExecutor.submit(new MyCallable(200000));
        System.out.println(System.currentTimeMillis() + ": " +future4.get());
    }
}

class ThreadPoolTest implements iTest {
    @Override
    public void run() throws Exception {
        int corePoolSize = 3;
        int maximumPoolSize = 5;
        long keepAliveTime = 6;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue workQueue = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // 拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler handler1 = new ThreadPoolExecutor.DiscardPolicy();
        RejectedExecutionHandler handler2 = new ThreadPoolExecutor.DiscardOldestPolicy(); //忽略最久执行策略
        RejectedExecutionHandler handler3 = new ThreadPoolExecutor.CallerRunsPolicy(); //调用线程执行策略
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);

        MyRunable target = new MyRunable();
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);


        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);

        //超过任务队列数量，开始创建临时线程
        threadPoolExecutor.execute(target);
        threadPoolExecutor.execute(target);
        //线程池满了，拒绝策略，抛出异常
        // threadPoolExecutor.execute(target);

        // 强制关闭线程，会终止任务
        // threadPoolExecutor.shutdownNow();
        // 等待线程和任务结束才关闭线程
        threadPoolExecutor.shutdown();
    }
}

public class Test5 {
    public static void main(String[] args) throws Exception {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        // threadPoolTest.run();

        ThreadPoolTest1 threadPoolTest1 = new ThreadPoolTest1();
        threadPoolTest1.run();
    }
}
