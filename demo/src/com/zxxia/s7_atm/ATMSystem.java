package com.zxxia.s7_atm;

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
                    Account account = login(scanner);
                    doCommand(scanner, account);
                }
                break;
                case 2: {
                    register(scanner);
                }
                break;
                default: {
                    System.out.println("当前输入的操作不存在");
                }
                break;
            }
        }
    }

    private static void doCommand(Scanner scanner, Account account) {
        while (true) {
            System.out.println("========================欢迎进入操作界面========================");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销");
            System.out.println("请输入您的操作指令：");
            int command = scanner.nextInt();
            switch (command) {
                case 1: {
                    showAccount(account);
                }
                break;
                case 2: {
                    diposit(account, scanner);
                }
                break;
                case 3: {
                    pullMoney(account, scanner);
                }
                break;
                case 4: {
                    transferMoney(account, scanner);
                }
                break;
                case 5: {
                    updatePassword(account, scanner);
                }
                break;
                case 6: {
                    System.out.println("欢迎下次继续光临！！");
                    return;
                }
                case 7: {
                    accountArrayList.remove(account);
                    System.out.println("您的账号注销成功，无法继续用此账号登录");
                    return;
                }
                default: {
                    System.out.println("无效操作命令");
                }
                break;
            }
        }
    }

    private static void diposit(Account account, Scanner scanner) {
        System.out.println("========================欢迎进入账户存款操作========================");
        System.out.println("请输入存款金额");
        Double count = scanner.nextDouble();
        account.money += count;
        System.out.println("存款成功");
        showAccount(account);
    }

    private static void pullMoney(Account account, Scanner scanner) {
        System.out.println("========================欢迎进入账户转账操作========================");
        while (true) {
            System.out.println("请输入要取出的金额，并且是100的整数倍：");
            int count = scanner.nextInt();
            if (count > account.money) {
                System.out.println("余额不足，请重新输入");
                continue;
            }
            if (count % 100 != 0) {
                System.out.println("非法输入，请重新输入");
                continue;
            }
            account.money -= count;
            System.out.println("取钱成功");
            showAccount(account);
            break;
        }
    }

    private static void transferMoney(Account account, Scanner scanner) {
        System.out.println("========================欢迎进入账户转账操作========================");
        while (true) {
            System.out.println("请您输入对方卡号：");
            String cardID = scanner.next();
            if (cardID.equals(account.cardID)) {
                System.out.println("不能给自己转账");
                continue;
            }
            Account account1 = getAccount(cardID);
            if (account1 == null) {
                System.out.println("账号不存在");
                continue;
            }
            String name = account1.name;
            String subName = name.substring(1);
            System.out.println("请您确认[*" + subName + "]的姓氏来确认！");
            //姓
            String inputSecondName = scanner.next();
            String secondName = name.substring(0, 1);
            if (!secondName.equals(inputSecondName)) {
                continue;
            }
            double transferCount = 0;
            while (true) {
                System.out.println("请输入金额");
                transferCount = scanner.nextDouble();
                if (transferCount > account.money) {
                    System.out.println("余额不足，请重新输入");
                    continue;
                }
                if (transferCount > account.quotaMoney) {
                    System.out.println("超过当次额度");
                    continue;
                }
                break;
            }
            account.money -= transferCount;
            String msg = String.format("您已经完成转账，当前余额为：%f", account.money);
            System.out.println(msg);
            break;
        }
    }

    private static void updatePassword(Account account, Scanner scanner) {
        System.out.println("========================欢迎进入修改密码操作========================");
        while (true) {
            System.out.println("请输入当前密码");
            String strPsw = scanner.next();
            if (!strPsw.equals(account.password)) {
                System.out.println("密码错误，请重新输入");
                continue;
            }
            String strPassword = null;
            while (true) {
                System.out.println("请输入要修改密码");
                strPsw = scanner.next();
                System.out.println("请再次输入要修改密码");
                String strPsw1 = scanner.next();
                if (!strPsw1.equals(strPsw)) {
                    System.out.println("密码错误，请重新输入");
                    continue;
                }
                strPassword = strPsw;
                break;
            }
            account.password = strPassword;
            System.out.println("密码修改成功");
            break;
        }
    }

    private static void showAccount(Account acc) {
        System.out.println("==================您当前账户详情信息如下======================");
        System.out.println("卡号：" + acc.cardID);
        System.out.println("户主：" + acc.name);
        System.out.println("余额：" + acc.money);
        System.out.println("当次取现额度：" + acc.quotaMoney);
    }


    private static Account login(Scanner scanner) {
        System.out.println("========================欢迎进入开户界面========================");
        while (true) {
            System.out.println("请输入账户名称");
            String strName = scanner.next();
            System.out.println("请输入密码");
            String strPassword = scanner.next();
            Account account = getAccount(strName, strPassword);
            if (account != null) {
                String strLog = String.format("欢迎 %s先生/女士进入系统，您可以办理你的业务了！", account.name);
                System.out.println(strLog);
                return account;
            }
            System.out.println("账号或密码输入错误");
        }
    }

    private static void register(Scanner scanner) {
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

    private static Account getAccount(String strName, String strPassword) {
        for (int i = 0; i < accountArrayList.size(); i++) {
            Account account = accountArrayList.get(i);
            if (account.name.equals(strName) && account.password.equals(strPassword)) {
                return account;
            }
        }
        return null;
    }

    private static Account getAccount(String cardID) {
        for (int i = 0; i < accountArrayList.size(); i++) {
            Account account = accountArrayList.get(i);
            if (account.cardID.equals(cardID)) {
                return account;
            }
        }
        return null;
    }

    //创建开好唯一标志，肯定依赖数据库自增索引，这逻辑不严谨
    private static String randomCardID() {
        String CardID = "";
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int r = random.nextInt(10);
            CardID += r;
        }
        return CardID;
    }
}
