package com.zxxia.s44_filerecursion;

import com.zxxia.iTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * File文件类
 * 目标：
 * 1. 定位文件：File类（代表文件、文件夹）：定位文件、获取文件本身信息、删除文件、创建文件（文件夹）；不能读写文件内容
 * 2. 读写文件数据：IO流
 * 3. 递归
 * ---直接递归
 * ---间接递归
 * ---递归三大要素
 * ------递归公式
 * ------递归的终点
 * ------递归的方向必须走向终点
 * ---案例：阶乘：RecursionTest1
 * ---案例：累加：RecursionTest2
 * ---案例：吃桃子:解法2 优秀
 * ---案例：文件搜索,并执行exe：FileRecursionTest
 * ---案例：啤酒问题
 */

class APITest implements iTest {
    @Override
    public void run() {
        // File 构建的对象可以说文件夹和文件
        // 相对路径，相对模块路径
        File f = new File("./file.txt");
        // 绝对路径，从盘符开始找
        File f1 = new File("D:/file.txt");
        System.out.println(f.exists());
        // 获取字节大小
        System.out.println(f.length());//13个字节，可以右击查看文件大小
        // E:\workspace\GitHub\JavaExecise\.\file.txt
        System.out.println(f.getAbsolutePath());
        // 相对路径 ./file.txt
        System.out.println(f.getPath());
        // file.txt
        System.out.println(f.getName());
        // 修改时间毫秒值
        long m = f.lastModified();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(m));
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());

        File f2 = new File("D:");
        System.out.println(f2.isDirectory());

        // 创建文件
        File f3 = new File(".\\file1.txt");
        try {
            //很少用，创建文件一般用IO流
            System.out.println("create file result: " + f3.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建文件夹相关
        // File 创建文件夹1级
        File f4 = new File(".\\res\\ccb\\ccb");
        System.out.println(f4.mkdir());
        // File 创建文件夹多级
        System.out.println(f4.mkdirs());

        // 删除文件、文件夹相关
        // 删除文件
        System.out.println("delete result: " + f3.delete());
        // 删除空文件夹
        // System.out.println("delete directory result: "+f4.delete());

        // 遍历文件夹
        File f5 = new File(".\\res\\ccb\\ccb");
        // 不存在
        if (f5 != null) {
            // 遍历一级
            // [111 - 副本.txt, 111.txt]
            System.out.println(Arrays.toString(f5.list()));
            // 如果是文件，f5.listFiles()返回null ***常用***
            // E:\workspace\GitHub\JavaExecise\.\res\ccb\ccb\111 - 副本.txt
            // E:\workspace\GitHub\JavaExecise\.\res\ccb\ccb\111.txt
            File[] list = f5.listFiles();
            if (list != null) {
                for (File file : list) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}

class RecursionTest implements iTest {
    @Override
    public void run() {
        // 直接递归
        // test();
        //间接递归
        // test2();
    }

    // 直接递归：出现栈溢出
    // Exception in thread "main" java.lang.StackOverflowError
    void test() {
        System.out.println("---------------test-------------");
        test();
    }

    //间接递归
    void test2() {
        test3();
    }

    void test3() {
        test2();
    }
}

// 阶乘 f(n)=1*2*3*...(n-1)*n <=> f(n)=f(n-1)*n
// 公式
class RecursionTest1 implements iTest {
    @Override
    public void run() {
        System.out.println("6的阶乘：" + this.f(6));
    }

    int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) * n;
    }
}

// f(n) = 1+2+3+...n
class RecursionTest2 implements iTest {
    @Override
    public void run() {
        System.out.println("1-100的总和 " + f(100));
    }

    int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + n;
    }
}

// 猴子吃桃子，第一天摘了若干个，当即吃了一半，觉得不过瘾，于是又多吃了一个；每天如此，等到第10天，发现桃子只有1个了；请问猴子摘了多少桃子
class MonkeyRecursionTest implements iTest {
    @Override
    public void run() {
        System.out.println(f(10));
        System.out.println(f2(1));
    }

    // 解法1
    // 公式：f(n)=(f(n-1)+1)*2
    // 10=1,9=(1+1)*2=4,8=(4+1)*2=10, 7=(10+1)*2=22,6=(22+1)*2=46,5=(46+1)*2=94,4=95*2=190,3=191*2=382,2=383*2=766,1=767*2=1534
    int f(int n) {
        if (n == 1) {
            return 1;
        }
        return (f(n - 1) + 1) * 2;
    }

    // 解法2 优秀
    // f(x)- f(x)/2-1=f(x+1) >> f(x)/2-1=f(x+1) >> f(x)-2=2*f(x+1) >> f(x)=2*f(x+1)+2
    int f2(int x) {
        if (x == 10) {
            return 1;
        }
        return 2 * f2(x + 1) + 2;
    }
}

// 递归查找文件，并执行exe
class FileRecursionTest implements iTest {
    @Override
    public void run() {
        String dir = "E:\\BaiduNetdiskDownload";
        String name = "Beyond_Compare_4.1.9.21719.exe";
        File f = this.searchFile(dir, name);
        if (f != null) {
            System.out.println("find " + name);

            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("cmd /c" + f.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("not find " + name);
        }
    }

    /**
     * @param dir
     * @param name
     * @return
     */
    public File searchFile(String dir, String name) {
        File f = new File(dir);
        boolean isDir = f.isDirectory();
        if (!isDir && f.getName().equals(name)) {
            return f;
        }
        if (isDir) {
            //遍历目录
            for (File file : f.listFiles()) {
                File ff = this.searchFile(file.getAbsolutePath(), name);
                if (ff != null) {
                    return ff;
                }
            }
        }
        return null;
    }
}

// 需求：啤酒2元1瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶，请问10元钱可以喝多少屏啤酒，剩余多少空瓶和盖子；
// 答案：15瓶 3盖子 1空瓶
class BeerQuestionTest implements iTest {
    int _beer = 0;
    int _totalCount = 0;
    int _leftBottleCount = 0;
    int _leftCoverCount = 0;

    @Override
    public void run() {
        // 10 >> 5瓶 >> 5空瓶 5盖子 >> 1瓶+ 2瓶+1空瓶+1盖子 >> 3空瓶 + 3盖子 + 1空瓶 + 1盖子 >> 2瓶 + 1瓶 >> 3空瓶+3盖子>> 1瓶+1空瓶+3盖子 >> 4盖子+2空瓶 >> 2瓶 >> 2空瓶+2盖子 >> 1瓶+3盖子+1空瓶
        int money = 10;
        f(money / 2, 0, 0);
        buy(money);
        System.out.println("_beer: " + _totalCount + ", totalLid: " + _leftBottleCount + ",lid: " + _leftCoverCount);
    }

    // n=钱
    // f(n)= n/2 >> n瓶 >> n >> n /4 && n %4 && n /2 && n%2
    public void f(int n, int bottle, int lid) {
        _beer += n;
        int totalBottle = bottle + n;
        int totalLid = lid + n;
        if (totalLid < 2 || (totalLid < 4 && n < 2)) {
            System.out.println(n);
            System.out.println("_beer: " + _beer + ", totalLid: " + totalBottle + ",lid: " + totalLid);
            return;
        }
        int totalBeer = (int) (totalBottle / 2) + (int) (totalLid / 4);
        int b = totalBottle % 2;
        int l = totalLid % 4;
        f(totalBeer, b, l);
    }

    // 解法优秀，流程清楚
    public void buy(int money) {
        int b = money / 2;
        _totalCount += b;

        int allMoney = 0;
        _leftCoverCount += b;
        if (_leftCoverCount >= 4) {
            allMoney += (int) (_leftCoverCount / 4) * 2;
        }
        _leftCoverCount = _leftCoverCount % 4;
        _leftBottleCount += b;
        if (_leftBottleCount >= 2) {
            allMoney += (int) (_leftBottleCount / 2) * 2;
        }
        _leftBottleCount = _leftBottleCount % 2;
        if (allMoney >= 2) {
            buy(allMoney);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        APITest apiTest = new APITest();
        apiTest.run();

        RecursionTest recursionTest = new RecursionTest();
        recursionTest.run();

        RecursionTest1 recursionTest1 = new RecursionTest1();
        recursionTest1.run();

        RecursionTest2 recursionTest2 = new RecursionTest2();
        recursionTest2.run();

        MonkeyRecursionTest monkeyRecursionTest = new MonkeyRecursionTest();
        monkeyRecursionTest.run();

        FileRecursionTest fileRecursionTest = new FileRecursionTest();
        fileRecursionTest.run();

        BeerQuestionTest beerQuestionTest = new BeerQuestionTest();
        beerQuestionTest.run();
    }
}
