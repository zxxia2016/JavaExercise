package com.zxxia.s49_net.upd.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("pls input words");
            String input = scanner.next();
            if (input.equals("exit")) {
                socket.close();
                break;
            }
            byte[] buffer = input.getBytes();
            // 广播地址
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), 8888);
            socket.send(packet);
        }
    }
}
