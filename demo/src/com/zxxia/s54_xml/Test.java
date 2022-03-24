package com.zxxia.s54_xml;

import com.zxxia.CTest;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;

import java.io.InputStream;

/**
 * XML
 * 1. 特点：纯文本，可保存为文件；可嵌套
 * 2. 应用场景：
 * -----xml内容作为消息进行网络传输
 * -----作为配置文件用于存储系统信息
 * 3. 用法
 * ----文件后缀为xml
 * ----文档声明必须是第一行
 * ----根标签有且只有一个
 * ----注释：<!--注释内容-->
 * ----标签成对出现
 * ----必须正确嵌套
 * 4. XML文档约束（即约束文档规范）：DTD
 * ----后缀必须是.dtd
 * ----可以约束XML文件编写
 * ----不可以约束类型
 * 5. XML文档约束：schema
 * ----可以约束类型
 * 6. XML解析方式
 * ----SAX解析：一行一行解析
 * ----DOM解析
 * ------常见解析工具：
 * -----------JAXP
 * -----------JDOM
 * -----------dom4j：重点：性能优异，功能强大，易使用；Hibernate也用它
 * -----------jsoup
 * 7. dom4j:地址：https://dom4j.github.io/
 * ------导入jar
 *
 */
class Dom4jTest extends CTest {
    @Override
    public void run() throws Exception {
        super.run();

        SAXReader saxReader = new SAXReader();
        InputStream inputStream = Test.class.getResourceAsStream("Data.xml");
        if (inputStream == null) {
            System.out.println("error");
            return;
        }
        Document document = saxReader.read(inputStream);
        Element root = document.getRootElement();
        System.out.println(root.getName());
        for (Element element : root.elements()) {
            System.out.println(element);
        }
        System.out.println(root.element("书"));
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        Dom4jTest dom4jTest = new Dom4jTest();
        dom4jTest.run();

    }
}
