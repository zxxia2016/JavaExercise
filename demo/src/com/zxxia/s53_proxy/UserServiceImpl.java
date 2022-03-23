package com.zxxia.s53_proxy;

public class UserServiceImpl implements UserService {
    @Override
    public String login(String name, String password) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("login 方法耗时：" + (end-start)/1000 + "s");
            if (name.equals("admin") && password.equals("123456")) {
                return "success";
            }
            return "failed";

        }
    }

    @Override
    public boolean deleteUsers() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            long end = System.currentTimeMillis();
            System.out.println("deleteUsers 方法耗时：" + (end-start)/1000 + "s");
            return true;
        }
    }

    @Override
    public boolean selectUsers() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            long end = System.currentTimeMillis();
            System.out.println("selectUsers 方法耗时：" + (end-start)/1000 + "s");
            return true;
        }
    }
}
