package com.zxxia.s42_logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志技术：Logback:https://logback.qos.ch/
 * 1. 优点
 * ---写入文件或数据库
 * ---取消日志，不需要修改代码，灵活性高
 * ---多线程，性能好
 * 2. 体系结构
 * ---日志规范
 * ------Commons Logging，简称：JCL，sun公司
 * ------Simple Logging Facae for Java，简称：slf4j
 * ---日志实现框架
 * ------Log4j
 * ------JUL:java.util.logging
 * ------Logback（Log4j升级版）
 * ------其他
 * 3. Logback:
 * ---logback-core:核心模块，是另2个模块的基础
 * ---logback-classic：log4的改良版，同时实现了slf4j api
 * ---logback-access：与Tomcat和Jetty等Servlet容器集成，以提供HTTP访问日志功能
 * ---logback.xml配置文件，详细信息看该文件
 * ------日志文件位置：控制台、文件
 * ------日志文件日期
 * ------日志级别：TRACE<DEBUG<INFO<WARIN<ERROR;默认级别debug
 * 3. 如何导入库
 * ---项目下新建lib文件夹，将jar文件添加到lib，在idea中，选中jar，然后右击，选择add library；再将logback.xml拷贝到src根目录
 */
public class Test {
    public static final Logger logger = LoggerFactory.getLogger("Test");
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        try {
            logger.debug("111");
            logger.debug("222");
            logger.info("333");
            logger.trace("444");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error:" + e);
        }
    }
}
