package com.zxxia.s24_bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal
 * 1. 解决浮点型数据精度丢失问题，比如0.1+0.2不等于0.3
 * 2. 浮点站BigDecimal正确方式，BigDecimal.valueof(0.1)，其它的转换方式有精度问题
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal b = BigDecimal.valueOf(10.0);
        BigDecimal c = BigDecimal.valueOf(3);
        //除不尽，会有精度问题
//        BigDecimal d = b.divide(c);
        //解决方式
        //3.334
        BigDecimal e = b.divide(c, 3, RoundingMode.CEILING);
        //3.3
        BigDecimal f = b.divide(c, RoundingMode.FLOOR);
        System.out.println(e);
        System.out.println(f);
    }
}
