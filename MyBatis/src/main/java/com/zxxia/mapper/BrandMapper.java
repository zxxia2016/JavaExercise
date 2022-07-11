package com.zxxia.mapper;

import com.zxxia.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询
     * * 参数接收
     *      1. 散装参数：@Param注解
     *
     */
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") int brandName );
}
