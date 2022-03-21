package com.zxxia.s49_net.socket;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7777);
        OutputStream outputStream = socket.getOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ps.println("我已经发出要求：约吗？");
        ps.flush();
        // socket.close();
    }
}
