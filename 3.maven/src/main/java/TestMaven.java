import java.sql.Connection;
import java.sql.DriverManager;

/**
 * maven环境配置
 * 1. https://mvnrepository.com/
 * 2. 目标：
 * ------学会配置maven环境变量
 * ------配置conf/setting文件：修改本地仓库位置：localRepository；新增镜像：mirrors
 * ------创建maven项目；修改idea的maven的设置，仓库
 * ------配置pom.xml：添加依赖：dependency；scope作用；可以设置idea自动导入
 * ------安装maven help插件
 */

public class TestMaven {
    public static void main(String[] args) {
        System.out.println("hello maven");
    }
}
