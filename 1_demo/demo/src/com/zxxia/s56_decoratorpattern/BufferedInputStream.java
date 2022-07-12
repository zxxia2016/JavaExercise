package com.zxxia.s56_decoratorpattern;

/**
 装饰类：继承InputStream 拓展原始类的功能
 */

public class BufferedInputStream extends InputStream {
    private InputStream _is;

    BufferedInputStream(InputStream is) {
        _is = is;
    }

    @Override
    public int read() {
        System.out.println("提供8KB的缓冲区，提高读数据性能~~~~");
        return this._is.read();
    }
}
