package com.zxxia.s49_net.upd.p2p;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buffer = "我是一颗快乐的韭菜，你愿意吃吗".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 6666);
        socket.send(packet);
        socket.close();
    }
}
