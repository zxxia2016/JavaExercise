package com.zxxia.bubblesort;

import java.util.Arrays;

/**
 * zxxia
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {5, 4 , 3, 0, 6};
        int length = array.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i + 1; j < length; j++) {
                int a = array[i];
                int b = array[j];
                if (a > b) {
                    int c = array[j];
                    array[j] = a;
                    array[i] = c;
                }
            }
        }
        //输出数组
        System.out.println(Arrays.toString(array));
    }

}
