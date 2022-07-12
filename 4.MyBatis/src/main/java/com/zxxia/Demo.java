package com.zxxia;

import com.zxxia.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis入门；学习目标：基本配置，以及过程
 */

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("hello mybatis");

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //参数是一个字符串，该字符串必须是映射配置文件的namespace.id
        List<User> list = sqlSession.selectList("selectAll");
        System.out.println(list);
        //4. 释放资源
        sqlSession.close();

    }
}
