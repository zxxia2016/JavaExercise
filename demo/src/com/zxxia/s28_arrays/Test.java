package com.zxxia.s28_arrays;

import java.util.Arrays;

/**
 * Arrays
 * 1. static toString
 * 2. static sort
 * 3. static sort 用比较器对象排序，只能是引用类型的排序
 * 4. static binarySearch：二分查找，前提，要排序好
 */
public class Test {
    public static void main(String[] args) {
        //toString
        int[] array = {2, 3, 1};
        System.out.println(Arrays.toString(array));//[2, 3, 1]
        //sort
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));//[1, 2, 3]
        //用二分排序
        int idx = Arrays.binarySearch(array, 0);
        System.out.println(idx);//-1
        //用比较器对象排序

    }
}
