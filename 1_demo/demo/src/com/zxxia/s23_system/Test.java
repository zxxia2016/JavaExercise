package com.zxxia.s23_system;

import com.zxxia.s2_array.Array;

import java.util.Arrays;

/**
 * System
 * 1. 私有构造器、静态方法
 * 2. exit 终止当前运行的Java虚拟机，参数非0表示异常
 * 3. currentTimeMilllis 获取时间戳，毫秒形式
 * 4. arraycopy 数组拷贝
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("程序开始");

        //时间戳获取
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗实际：" + (end - start) / 1000.0 + "s");

        //数组使用
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[6];
        System.arraycopy(arr1, 1, arr2, 2, 3);
        //[0, 0, 2, 3, 4, 0]
        System.out.println(Arrays.toString(arr2));
        //Jvm stop
        System.exit(0);
        //不会执行到
        System.out.println("程序结束");

    }
}