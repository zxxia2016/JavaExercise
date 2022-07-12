package com.zxxia.mapper;

import com.zxxia.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    User select(@Param("username") String username, @Param("password") String password);

    User select(Collection collection);
}
