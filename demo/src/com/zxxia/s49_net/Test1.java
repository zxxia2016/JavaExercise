package com.zxxia.s49_net;

import com.zxxia.iTest;

import java.net.InetAddress;

/**
 * 网络编程三要素
 * 1. IP地址：IPV4、IPV6
 * ----电脑本地dns先解析；如果没有先把域名发给宽带运营商，运营商在返回IP
 * ----IP地址形式：公网IP、私有IP
 * ----常用命令：ipconfig、ping
 * ----特殊IP地址：127.0.0.1或localhost（可以理解成本地域名）：本地回唤醒地址
 * ----API使用：InetAddress，如：InetAddressTest
 *
 * 2. 端口
 * ----返回：0~65535
 * ----周知端口：0~1023：HTTP：80，HTTPS:443;FTP：21；
 * ----注册端口：1024~49151，分配给用户进程或程序；如Tomcat:8080；MySql:3306
 * ----动态端口：49152~65535，不固定分配给某种进程；动态分配
 * 3. 网络通信协议：UPT、TCP等
 * ----OSI模型：过于理想化，没用
 * ----TCP/IP模型：事实上的国际标准，指导网卡厂商设计网卡
 * --------应用层：HTTP、FTP、DNS、SMTP
 * --------传输层：TCP、UDP
 * --------网络层：IP、ICMP；封装源和目标IP，进行路径选择
 * --------数据链路层+物理：物理寻址、比特流
 * ----TCP协议
 * --------三次握手连接
 * --------四次挥手断开连接：要等待服务端接受完毕，再通知客户端说可以断开
 * UDP协议
 * --------每个包限制在64KB
 * --------适用场景：语音通话、视频会话等
 * --------案例：单发单收：UDPClient、UPDSever
 * --------案例：多发多收：WhileTrueMulUDPClient、WhileTrueMulUDPServer；多个客户端发送给1个服务端
 * --------案例：广播：看包：broadcast；发送端，填写广播地址（255.255.255.255）和指定端口；接收端只要匹配端口即可
 * --------案例：组播：看包：multicast；组播地址范围：224.0.0.0~239.255.255.255；具体操作：发送端：目的地是组播IP，上述范围；接收端绑定该组播IP；用MulticastSocket绑定组播IP
 */
class InetAddressTest implements iTest {
    @Override
    public void run() throws Exception {
        // 获取本机对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        // zxxia-home
        System.out.println(inetAddress.getHostName());
        // 192.168.0.105
        System.out.println(inetAddress.getHostAddress());

        //获取域名对象
        InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
        // 163.177.151.109
        System.out.println(inetAddress1.getHostAddress());
        // www.baidu.com
        System.out.println(inetAddress1.getHostName());

        // 获取公网IP对象
        InetAddress inetAddress2 = InetAddress.getByName("163.177.151.109");
        // 163.177.151.109
        System.out.println(inetAddress2.getHostName());

        // ping
        // true
        System.out.println(inetAddress1.isReachable(5000));
    }
}

public class Test1 {
    public static void main(String[] args) throws Exception {
        InetAddressTest inetAddressTest = new InetAddressTest();
        inetAddressTest.run();
    }
}
