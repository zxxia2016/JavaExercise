package com.zxxia.s49_net.socket;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //1. 创建接收对象
        //2. 创建数据包接收对象（韭菜盘子）
        //3. 等待接收数据
        //获取发送方信息
        //4. 取出数据

        // 1. 注册端口
        ServerSocket serverSocket = new ServerSocket(7777);
        // 2.等待连接，建立socket通信
        Socket socket = serverSocket.accept();
        //3. 读取输入流
        InputStream inputStream = socket.getInputStream();
        //4. 字节流转成缓冲字符流进行消息接受
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //5. 按行读取
        String msg;
        if ((msg = bufferedReader.readLine()) != null) {
            System.out.println(socket.getRemoteSocketAddress() + "说：" + msg);
        }

    }
}
