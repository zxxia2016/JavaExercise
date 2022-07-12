package com.zxxia.s16_abstract;

/**
 * 1. 模板方法模式（加final）：把模板方法设置未final不让重写；模板方法内部按需实现，例如handle方法
 * 2. 案例：银行结息系统
 */

/*
1. 功能：登录验证，活期账号和定期账户结息利率不同
 */
abstract class Account {
    private double money;

    public boolean login(String name, String password) {
        //如果登录成功就进行结息，失败不处理;这里暂时不实现
        return true;
    }

    public final boolean handle() {
        //返回结息结果
        double count = this.money * this.getRate();
        System.out.println("利率：" + count);
        return true;
    }

    abstract double getRate();
}

//活期账号
class Huoqi extends Account {
    @Override
    double getRate() {
        return 0.01;
    }
}
//定期账号
class Dingqi extends Account {
    @Override
    double getRate() {
        return 0.04;
    }
}

public class Test1 {
    public static void main(String[] args) {
        Huoqi h = new Huoqi();
        boolean l = h.login("111", "11");
        if (l) {
            h.handle();
        }
        Dingqi d = new Dingqi();
        boolean r = d.login("111", "11");
        if (r) {
            d.handle();
        }
    }
}
