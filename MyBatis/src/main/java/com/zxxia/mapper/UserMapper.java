package com.zxxia.mapper;

import com.zxxia.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);
}
