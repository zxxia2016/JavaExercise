package com.zxxia;

import com.zxxia.mapper.BrandMapper;
import com.zxxia.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis：查看详情（单条件查询）
 *
 */

public class DemoBrand {
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
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(1);
        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();

    }
}
