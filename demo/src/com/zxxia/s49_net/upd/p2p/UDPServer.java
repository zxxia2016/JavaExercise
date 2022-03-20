package com.zxxia.s49_net.upd.p2p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        //1. 创建接收对象
        DatagramSocket socket = new DatagramSocket(6666);
        //2. 创建数据包接收对象（韭菜盘子）
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        //3. 等待接收数据
        socket.receive(packet);
        //4. 取出数据
        String string = new String(buffer, 0,packet.getLength());
        System.out.println(string);

        //获取发送方信息
        System.out.println(packet.getAddress());
        System.out.println(packet.getPort());
        socket.close();
    }
}
