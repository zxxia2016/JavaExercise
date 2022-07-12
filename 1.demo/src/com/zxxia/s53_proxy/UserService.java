package com.zxxia.s53_proxy;

public interface UserService {
    String login(String name, String password);
    boolean deleteUsers();
    boolean selectUsers();
}
