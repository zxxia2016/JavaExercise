package com.zxxia.s18_virtual;

/**
 * 实现1电脑对象，开机后，连接鼠标、键盘；鼠标可以移动，键盘可以按键
 */

class Computer {
    String name;
    Computer( String name) {
        this.name = name;
    }
    void start() {
        System.out.println("开机了；");
    }
    void installUsB(USB u) {
        u.connect();
        if (u instanceof KeyBoard) {
            KeyBoard k = (KeyBoard) u;
            k.keydown();
        }
        else if(u instanceof Mouse) {
            Mouse m = (Mouse) u;
            m.dbClick();
        }
        u.disconnect();
    }
    void end() {
        System.out.println("开机了；");
    }
}

interface USB {
    void connect();
    void disconnect();
}

class KeyBoard implements USB {
    public String name;
    KeyBoard(String name) {
        this.name = name;
    }
    @Override
    public void connect() {
        System.out.println("KeyBoard 连接了");
    }

    @Override
    public void disconnect() {
        System.out.println("KeyBoard 断开了");

    }

    void keydown() {
        System.out.println("键盘按下了");
    }
}

class Mouse implements USB {
    public String name;
    Mouse(String name) {
        this.name = name;
    }

    void dbClick() {
        System.out.println("鼠标点击");
    }
    @Override
    public void connect() {
        System.out.println("Mouse 连接了");
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse 断开了");

    }
}

public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer("外星人");
        computer.start();
        USB u1 = new KeyBoard("双飞燕");
        computer.installUsB(u1);
        USB u2 = new Mouse("罗技");
        computer.installUsB(u2);
        computer.end();
    }
}
