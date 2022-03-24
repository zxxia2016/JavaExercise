package com.zxxia.s54_xml;

import com.zxxia.CTest;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * XML
 * 1. 特点：纯文本，可保存为文件；可嵌套
 * 2. 应用场景：
 * -----xml内容作为消息进行网络传输
 * -----作为配置文件用于存储系统信息
 * 3. 用法：元素，属性，值，文本
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
 * 7. XML解析技术：dom4j:
 * ------地址：https://dom4j.github.io/
 * ------导入dom4j-2.1.3.jar；案例：Dom4jTest
 * 8. XML检索技术：XPath;依赖dom4j
 * ------导入dom4j-2.1.3.jar和jaxen-1.1.2.jar；案例：XPathTest
 */

class Dom4jTest extends CTest {
    class Contact {
        private int id;
        private boolean vip;
        private String name;
        private char gender;
        private String email;

        public Contact(int id, boolean vip, String name, char gender, String email) {
            this.id = id;
            this.vip = vip;
            this.name = name;
            this.gender = gender;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", vip=" + vip +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    @Override
    public void run() throws Exception {
        super.run();

        SAXReader saxReader = new SAXReader();
        InputStream inputStream = Test.class.getResourceAsStream("Contacts.xml");
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
        System.out.println("-----------------------------------------------");
        // 从xml文件中解析到对象
        List<Contact> Contacts = new ArrayList<>();
        List<Element> list = root.elements("contact");
        for (Element element : list) {
            Contact contact = new Contact(
                    Integer.valueOf(element.attributeValue("id")),
                    Boolean.valueOf(element.attributeValue("vip")),
                    //去掉空格后的文本
                    element.elementTextTrim("name"),
                    element.elementText("gender").charAt(0),
                    element.elementText("email"));
            Contacts.add(contact);
        }
        System.out.println(Contacts);
    }
}

class XPathTest extends CTest {
    @Override
    public void run() throws Exception {
        super.run();
        this.parse01();
        this.parse02();
        this.parse03();
        this.parse04();
    }

    /**
     * 绝对路径：/根元素/子元素/子元素
     */
    public void parse01() throws DocumentException {
        // a、创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b、把XML加载成Document文档对象
        Document document =
                saxReader.read(this.getClass().getResourceAsStream("Contacts2.xml"));
        // c、检索全部的名称
        List<Node> nameNodes = document.selectNodes("/contactList/contact/name");
        // 潘金莲 武松 武大狼
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 相对路径：./子元素/子元素
     */
    public void parse02() throws DocumentException {
        // a、创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b、把XML加载成Document文档对象
        Document document =
                saxReader.read(this.getClass().getResourceAsStream("Contacts2.xml"));
        Element root = document.getRootElement();
        List<Node> nameNodes = root.selectNodes("./contact/name");
        // 潘金莲 武松 武大狼
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 全文检索
     * //元素 在全文查找这个元素
     * //元素1/元素2 在全文找元素1下面的一级元素2
     * //元素1//元素2 在全文找元素1下面的全部元素2
     */
    public void parse03() throws DocumentException {
        // a、创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b、把XML加载成Document文档对象
        Document document =
                saxReader.read(this.getClass().getResourceAsStream("Contacts2.xml"));
        // List<Node> nameNodes = document.selectNodes("//name");
        // List<Node> nameNodes = document.selectNodes("//contact/name");
        List<Node> nameNodes = document.selectNodes("//contact//name");
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 属性查找
     * //@属性名称 在全文查找这个属性
     * //元素[@属性名称] 在全文检索包含该属性的元素对象
     * //元素1[@属性名称=值] 在全文检索包含该属性的元素且属性值为该值的元素对象
     */
    public void parse04() throws DocumentException {
        // a、创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b、把XML加载成Document文档对象
        Document document =
                saxReader.read(this.getClass().getResourceAsStream("Contacts2.xml"));
        List nodes = document.selectNodes("//@id");
        for (Object node : nodes) {
            Attribute attribute = (Attribute) node;
            // id>>>>>1
            System.out.println(attribute.getName() + ">>>>>" + attribute.getValue());
        }
        Node node = document.selectSingleNode("//name[@id]");
        Element e = (Element)node;
        // 我是西门庆
        System.out.println(e.getTextTrim());

        Node node1 = document.selectSingleNode("//name[@id=888]");
        Element e1 = (Element)node1;
        // 我是西门庆
        System.out.println(e1.getTextTrim());
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        Dom4jTest dom4jTest = new Dom4jTest();
        dom4jTest.run();

        XPathTest xPathTest = new XPathTest();
        xPathTest.run();
    }
}
