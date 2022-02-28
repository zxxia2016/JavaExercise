package com.zxxia.s16_abstract;

/**
 * 1. 抽象类，抽象方法必须重写所有方法，例子：如Tiger类；
 * 2. 抽象类为什么不能实例化
 * 3. 抽象类不一定有抽象方法
 * 4. abstract不能修饰变量
 * 5. abstract和final互斥关系，有点勉强；abstract类继承必须实现抽象方法，final类不能被继承
 * 6. 案例：加油卡、
 */

abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void run();
}

class Tiger extends Animal {

    @Override
    public void run() {
        System.out.println("跑得贼溜~~~");
    }
}

/**
 * 加油卡，充值1w享受8折；充值8k，享受8.5折
 */
abstract class Card {
    private String name;
    private double money;
    private float rate;

    Card() {
        rate = 1;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract boolean pay(double value);
}

class GoldCard extends Card {

    GoldCard() {
        this.setRate(0.8f);
    }

    @Override
    boolean pay(double value) {
        final double result = this.getRate() * value;
        if (this.getMoney() < result) {
            return false;
        }
        double left = this.getMoney() - result;
        this.setMoney(left);
        return true;
    }
}

class SilverCard extends Card {

    SilverCard() {
        this.setRate(0.85f);
    }

    @Override
    boolean pay(double value) {
        final double result = this.getRate() * value;
        if (this.getMoney() < result) {
            return false;
        }
        double left = this.getMoney() - result;
        this.setMoney(left);
        return true;
    }
}

public class Test {
    public static void main(String[] args) {
        Tiger t = new Tiger();
        t.run();


    }
}
