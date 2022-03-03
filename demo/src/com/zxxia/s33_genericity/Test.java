package com.zxxia.s33_genericity;

import com.zxxia.iTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 1. 格式：<数据类型>；注意：只能是引用类型
 * 2. 集合体系的全局接口和实现类都支持泛型
 * 3. 好处：统一数据类型；把运行期间问题提前到编译期间，避免转换问题
 * 4. 哪些地方可以定义：
 * ---类后面->泛型类
 * ---方法申明上->泛型方法
 * ---接口后面->泛型接口
 */
class GenericityTest implements iTest {

    @Override
    public void run() {
        List list = new ArrayList();
        list.add("Java");
        list.add(33);
        list.add(true);
        for (Object o : list) {
            // 运行期间强转风险
            String e = (String) o;
            System.out.println(e);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        GenericityTest genericityTest = new GenericityTest();
        genericityTest.run();
    }
}
