package com.zxxia.s4_store;

import java.util.Scanner;

class Goods {
    long id;
    String name;
    double prize;
    int buyCount;
}

//商城，数组练习

/**
 * zxxia
 */
public class Store {
    private static int MAX = 100;
    private static Goods[] storeArray = new Goods[MAX];
    private static int storeCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入操作类型");
            String strAction = sc.next();
            switch (strAction) {
                case "add": {
                    addGoods(storeArray, sc);
                }
                break;
                case "update": {
                    update(sc);
                }
                break;
                case "delete": {
                    delete(sc);
                }
                break;
                case "query": {
                    query();
                }
                break;
                case "pay": {
                    pay();
                }
                break;
                case "quit": {
                    return;
                }
            }
        }

    }

    private static boolean addGoods(Goods[] store, Scanner sc) {
        if (storeCount >= MAX) {
            System.out.println("达到上限");
            return false;
        }
        int storeIndex = storeCount;
        while (true) {
            System.out.println("请输入商品名字");
            String name = sc.next();
            System.out.println("请输入价格");
            double prize = sc.nextDouble();
            System.out.println("请输入数量");
            int count = sc.nextInt();
            Goods good = new Goods();
            good.id = storeIndex;
            good.name = name;
            good.prize = prize;
            good.buyCount = count;
            store[storeIndex] = good;
            storeCount = storeIndex + 1;
            System.out.println("按Q退出，其它继续");
            char c = sc.next().charAt(0);
            if (c == 'q') {
                break;
            }
            storeIndex++;
            if (storeIndex >= MAX) {
                System.out.println("达到上限");
                break;
            }
        }
        return true;
    }

    private static void query() {
        System.out.println("编号\t\t名称\t\t价格\t\t数量");
        for (int i = 0; i < storeCount; i++) {
            Goods good = storeArray[i];
            String str = String.format("%d\t\t%s\t\t%.2f\t\t%d", good.id, good.name, good.prize, good.buyCount);
            System.out.println(str);
        }
    }

    private static boolean update(Scanner sc) {
        System.out.println("请输入商品的id");
        int index = sc.nextInt();
        if (index >= storeCount) {
            return false;
        }
        System.out.println("请输入商品名字");
        String name = sc.next();
        System.out.println("请输入价格");
        double prize = sc.nextDouble();
        System.out.println("请输入数量");
        int count = sc.nextInt();
        Goods good = storeArray[index];
        good.name = name;
        good.prize = prize;
        good.buyCount = count;
        return false;
    }

    private static boolean delete(Scanner sc) {
        System.out.println("请输入商品的id");
        int index = sc.nextInt();
        if (index >=storeCount) {
            System.out.println("请输入正确商品的id");
            return false;
        }
        for (int i = index; i < storeCount-1; i++) {
            storeArray[i] = storeArray[i + 1];
        }
        storeArray[storeCount-1] = null;
        --storeCount;
        System.out.println("删除成功");
        return true;
    }

    private static boolean pay() {
        double sum = 0;
        for (int i = 0; i < storeCount; i++) {
            Goods good = storeArray[i];
            sum += good.prize * good.buyCount;
        }
        String strPrize = String.format("%.2f", sum);
        System.out.println(strPrize);
        return true;
    }
}
