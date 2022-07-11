package com.zxxia.mapper;

import com.zxxia.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);
}
