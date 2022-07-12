package com.zxxia.pojo;


// alt + 鼠标左键 整列编辑
public class Brand {

    Integer id;
    String brand_name;
    String company_name;
    Integer ordered;
    String description;
    Integer status;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand_name='" + brand_name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
