package com.zxxia.s17_interface;

/**
 * interface关键字
 * 1. jdk1.8只有常量和抽象方法，方法作用域和abstract关键字可以缺省，例如类ISportMan;
 *    jdk8之后，接口类可以用default、static、private关键字实现接口方法,只能被实现类调用
 * 2. 接口不能创建对象，例如Test
 * 3. 接口类是被实现的，用关键字implements；可以多继承，例如类：PingPongMan；多继承会存在规范冲突（函数名相同，其它不同），要注意
 * 4. 用法：接口类是一种规范，例如USB接口，各种厂商得遵循USB接口，才能正常使用
 */
// 运动员
interface ISportMan {
//    String name; //会报错
    String name = "name";
    void run();
    default void jump() {

    }
    //接口名调用
    static void wark() {

    }
//    private void write() {
//
//    }
}
interface Raw{
    void rule();
}
class PingPongMan implements ISportMan, Raw {

    @Override
    public void run() {

    }

    @Override
    public void rule() {

    }
}
public class Test {
    public static void main(String[] args) {
//        ISportMan man = new ISportMan();//报错，不能创建
        ISportMan.wark();
    }
}
