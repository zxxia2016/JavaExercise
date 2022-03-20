package com.zxxia.s49_net.upd.multicast;

import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        //1. 创建接收对象
        MulticastSocket socket = new MulticastSocket(8888);
        //绑定组播地址
        InetAddress group = InetAddress.getByName("224.0.0.0");
        // socket.joinGroup(group); //过时函数
        InetSocketAddress mcastaddr = new InetSocketAddress(InetAddress.getByName("224.0.0.0"), 9999);
        NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        socket.joinGroup(mcastaddr, netIf);
        //2. 创建数据包接收对象（韭菜盘子）
        byte[] buffer = new byte[1024 * 64];
        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            //3. 等待接收数据
            socket.receive(packet);

            //获取发送方信息
            System.out.println("发送方：" + packet.getAddress() + ":" + packet.getPort());

            //4. 取出数据
            String string = new String(buffer, 0, packet.getLength());
            System.out.println("发送方数据：" + string);
        }
        // socket.leaveGroup(group);
    }
}
