package com.zxxia.s9_statictest;

public class ArrayUtil {
    //防止实例化占用内存
    private ArrayUtil() {
    }

    public static String toString(int[] array) {
        if (array == null) {
            return null;
        }
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string += array[i];
        }
        return string;
    }
}
