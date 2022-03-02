package com.zxxia.s26_packageclass;

/**
 * 包装类
 * 8种基本数据类型包装
 */
public class Test {
    public static void main(String[] args) {
        byte b = 'b';
        Byte b1 = 'b';
        char c = 'c';
        Character c1 = 'c';
        short s = 1;
        Short s1 = 1;
        int i1 = 1;
        Integer i = 11;
        long l = 111111;
        Long l1 = 11111111111L;
        float f = 1.0f;
        Float f1 = 1.0f;
        double d = 1.1;
        Double d1 = 1.1;
        boolean bool = true;
        Boolean bool1 = true;

        // 字符串转Double
        Double v = Double.valueOf("1.1");
        System.out.println(v);
        // Double转字符串, 用的少
        v.toString();
    }
}
