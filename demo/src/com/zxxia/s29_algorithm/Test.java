package com.zxxia.s29_algorithm;

import com.zxxia.iTest;

import java.util.Arrays;

/**
 * algorithm:常用算法
 * 1. 选择排序：最小的往前移动
 * 2. 冒泡排序：相邻元素两两对比，最大的往后移动
 * 2. 二分查找：必须排好顺序
 */

// 选择排序
class SelectSortTest implements iTest {

    @Override
    public void run() {
        System.out.println("选择排序开始了");
        int[] array = {2, 3, 4, 1, 5};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }
    }
}

// 冒泡排序
class BubbleSortTest implements iTest {

    @Override
    public void run() {
        int[] array = {2, 3, 4, 1, 5};
        System.out.println("冒牌排序开始了");
        System.out.println(Arrays.toString(array));

        int len = array.length;
        int i, j;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                // 相邻元素两两对比
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    System.out.println(Arrays.toString(array));

                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

class BinarySearchTest implements iTest {

    @Override
    public void run() {
        int[] array = {10, 30, 30, 30, 30, 30, 30, 200};
        System.out.println(binarySearch(array, 31));
    }

    public int binarySearch(int[] arr, int data) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data > arr[mid]) {
                left = mid + 1;
            } else if (data < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

public class Test {
    public static void main(String[] args) {
        SelectSortTest selectSortTest = new SelectSortTest();
        selectSortTest.run();
        BubbleSortTest bubbleSortTest = new BubbleSortTest();
        bubbleSortTest.run();

        BinarySearchTest binarySearchTest = new BinarySearchTest();
        binarySearchTest.run();
    }
}
