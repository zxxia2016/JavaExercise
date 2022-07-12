package com.zxxia.s10_codeblock;

//代码块
//格式：{}
//用法：静态代码块；配合static使用，例如：static{}；类静态变量初始化
//用法：构造代码块；初始化实例资源

class CBlock {
    static {
        System.out.println("我是构造代码块");
    }
    public void log(){
        System.out.println("Block log");
    }
}

public class CodeBlock {
    static String strName;
    static {
        //优先执行这里
        System.out.println("静态代码初始化");
        strName = "111";
    }
    public void log(){
        System.out.println("static Block log");
    }

    public static void main(String[] args) {
        System.out.println("=========main========");
        new CodeBlock();
        new CodeBlock();
        CBlock b = new CBlock();
        b.log();
        CBlock c = new CBlock();
        c.log();
    }
}
