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
     *      2. 实体类封装参数：SQL语句中的参数和实体类属性名对应上
     *      3. map集合：SQL语句中的参数和键名称对手
     */
    List<Brand> selectByCondition(@Param("status") int status,
                                  @Param("companyName") String companyName,
                                  @Param("brandName") int brandName );
}
