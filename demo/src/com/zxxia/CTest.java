package com.zxxia;

/**
 * unitTest其实已经做了这功能
 */
public class CTest implements iTest {
    @Override
    public void run() throws Exception {
        String allName = getClass().getName();
        int index = allName.lastIndexOf(".");
        String className = allName.substring(index + 1, allName.length());
        System.out.println("----------------------" + className + "----------------------");
    }
}
