package com.zxxia.s52_annotation;

/**
 * 注解
 * 1. 语法：注解名称、属性类型 属性名 default 例子：MyBook
 * 2. 作用：对类、方法、成员变量做标记，然后进行特殊处理；例如Junit框架中的@Test注解
 * 3. 元注解：注解的注解
 * ----@Target
 * ----@Retention
 */
@MyBook(name = "111", authors = {"2222"}, price = 230.0)
public class Test {
    public static void main(String[] args) {

    }
}
