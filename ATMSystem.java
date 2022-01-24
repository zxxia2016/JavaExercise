package com.zxxia.hello;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Account {
    String cardID;
    String name;
    String password;
    double money;
    double quotaMoney;

    public Account(String cardID, String name, String password, double money, double quotaMoney) {
        this.cardID = cardID;
        this.name = name;
        this.password = password;
        this.money = money;
        this.quotaMoney = quotaMoney;
    }
}

public class ATMSystem {
    private static ArrayList<Account> accountArrayList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("========================欢迎进入ATM系统========================");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1、登录账户");
            System.out.println("2、注册账户");
            System.out.println("请输入操作");
            int command = scanner.nextInt();
            switch (command) {
                case 1: {

                }
                break;
                case 2: {
                    register(accountArrayList, scanner);
                }
                break;
                default: {
                    System.out.println("当前输入的操作不存在");
                }
                break;
            }
        }
    }

    private static void register(ArrayList<Account> list, Scanner scanner) {
        System.out.println("========================欢迎进入开户界面========================");
        System.out.println("请输入账户名称");
        String strName = scanner.next();
        String strPsw = null;
        while (true) {
            System.out.println("请输入密码");
            String strPsw1 = scanner.next();
            System.out.println("请再次输入密码");
            String strPsw2 = scanner.next();
            if (strPsw1.equals(strPsw2)) {
                strPsw = strPsw1;
                break;
            }
            System.out.println("两次输入的密码不一致，请重新输入");
        }
        System.out.println("请设置当前额度");
        Double quotaMoney = scanner.nextDouble();

        Account account = new Account(randomCardID(), strName, strPsw, 0, quotaMoney);
        accountArrayList.add(account);
        String strSuccess = String.format("恭喜您，%s先生/女士，您开户完成，您的卡号是：%s", account.name, account.cardID);
        System.out.println(strSuccess);
    }

    private static Account getAccount(String strName) {
        for (int i = 0; i < accountArrayList.size(); i++) {
            Account account = accountArrayList.get(i);
            if (account.name.equals(strName)) {
                return account;
            }
        }
        return null;
    }

    //创建开好唯一标志，肯定依赖数据库自增索引，这逻辑不严谨
    private static  String randomCardID() {
        String CardID = "";
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int r = random.nextInt(10);
            CardID += r;
        }
        return CardID;
    }
}
