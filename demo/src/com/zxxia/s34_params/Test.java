package com.zxxia.s34_params;

import com.zxxia.iTest;

/**
 * 可变参数：数组
 * 1. 可变参数只能1个
 * 2. 可变参数只能在最后
 * 3. 可以传一个数组
 * 4. 可以不传参数
 */
class MethonTest implements iTest {
    public void sum(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }

    @Override
    public void run() {
        this.sum(1);
        this.sum();
        this.sum(2, 3);
        this.sum(new int[]{2, 3});

    }
}

public class Test {
    public static void main(String[] args) {
        MethonTest methonTest = new MethonTest();
        methonTest.run();
    }
}
