package com.zxxia.s49_net.upd.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class WhileTrueMulUDPServer {
    public static void main(String[] args) throws Exception {
        //1. 创建接收对象
        DatagramSocket socket = new DatagramSocket(8888);
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

    }
}
