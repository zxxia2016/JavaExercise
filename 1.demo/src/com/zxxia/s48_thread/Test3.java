package com.zxxia.s48_thread;

/**
 * Thread安全问题：多个线程同时操作一个共享资源
 * 1. 产生条件
 * ---存在多线程
 * ---同时访问共享资源
 * ---存在修改共享资源
 * 2. 案例：取钱业务
 */

/**
 * 小红和小明同时取钱10万，银行只有10万
 */
class Account {
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        if (this.money >= money) {
            System.out.println(name + "取钱: " + money);
            this.money -= money;
            System.out.println(name + "取钱后余额: " + this.money);
        } else {
            System.out.println(name + "来取钱，余额不足");
        }
    }
}

// 取钱线程
class DrawThread extends Thread {
    private BankAccount account;

    public DrawThread(BankAccount account) {
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
public class Test3 {
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
