package com.zxxia.s48_thread;

import com.zxxia.iTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Timer：定时器
 * 1. Timer类
 * ---存在的问题：
 * ------Timer属于单线程；多个定时器顺序执行，会导致定时器不准确；例如：TimerTest
 * ------Timer属于单线程；如果一个定时任务异常，使Timer线程被JVM杀死；那会影响其它定时器；例如：TimerTest1
 * 2. JDK5: ScheduledExecutorService：基于线程池
 */
class ScheduledExecutorServiceTest implements iTest {
    @Override
    public void run() throws Exception {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务EE");
            }
        }, 0 , 2, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务FF");
            }
        }, 0 , 2, TimeUnit.SECONDS);
    }
}

class TimerTest implements iTest {
    @Override
    public void run() throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务AA");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务BB");
            }
        }, 0, 2000);
    }
}

class TimerTest1 implements iTest {
    @Override
    public void run() throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务CC");
                int a = 100 / 0;
            }
        }, 0, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + Thread.currentThread().getName() + "执行一次定时任务DD");
            }
        }, 0, 2000);
    }
}

public class Test6 {
    public static void main(String[] args) throws Exception {
        TimerTest timerTest = new TimerTest();
//        timerTest.run();
//        TimerTest1 timerTest1 = new TimerTest1();
//        timerTest1.run();

        ScheduledExecutorServiceTest scheduledExecutorServiceTest = new ScheduledExecutorServiceTest();
        scheduledExecutorServiceTest.run();
    }
}
