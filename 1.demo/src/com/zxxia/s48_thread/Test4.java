package com.zxxia.s48_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全、线程同步：访问共享资源时排队访问
 * 1. 加锁：对共享资源上锁，每个线程访问结束后解锁
 * ---如何加锁、加锁的方式
 * -----方式1：synchronized:同步代码块：用共享资源作为锁对象；不用任意唯一对象作为锁对象，因为会导致无关线程也会被锁
 * ----------对于共享资源：实例对象，使用this锁对象；静态方法，使用类名.class作为锁对象：BankAccount.class
 * -----方式2：synchronized:同步方法：将整个函数锁住，默认以this作为锁对象；例如方法BankAccount::run1
 * -----方式3：JDK5后：Lock锁：例如方法：BankAccount::run3
 */

class BankAccount {
    private double money;

    private final Lock lock = new ReentrantLock();//final唯一不可替换锁

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        synchronized (this) {
            if (this.money >= money) {
                System.out.println(name + "取钱: " + money);
                this.money -= money;
                System.out.println(name + "取钱后余额: " + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足");
            }
        }
    }

    public static void run2() {
        synchronized (BankAccount.class) {

        }
    }

    public static synchronized void run1() {
    }
    public void run3(double money) {
        lock.lock();

        try {
            this.money -= money;
        }
        finally {
            lock.unlock();
        }

    }
}

// 取钱线程
class DrawThreadTest extends Thread {
    private BankAccount account;

    public DrawThreadTest(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        //取钱
        this.account.drawMoney(100000);
    }
}

// 小红取钱: 100000.0
// 小明取钱: 100000.0
// 小红取钱后余额: 0.0
// 小明取钱后余额: -100000.0
public class Test4 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setMoney(100000);

        DrawThreadTest drawThread1 = new DrawThreadTest(account);
        drawThread1.setName("小红");
        drawThread1.start();

        DrawThreadTest drawThread2 = new DrawThreadTest(account);
        drawThread2.setName("小明");
        drawThread2.start();
    }
}
