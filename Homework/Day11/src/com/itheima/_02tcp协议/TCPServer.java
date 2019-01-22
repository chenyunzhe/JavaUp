package com.itheima._02tcp协议;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器端代码实现
 * <p>
 * ServerSocket类常用方法
 * Socket accept();
 * 等待客户端连接并获得与客户端关联的Socket对象
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        // 创建ServerSocket对象并指定端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("开启了服务器。。。");

        // 等待客户端连接并获得与客户端关联的Socket对象
        Socket socket = serverSocket.accept();
        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        //创建字节数组存储客户端发送的数据
        byte[] buf = new byte[1024];
        //读取数据到字节数组中
        int len = in.read(buf);
        System.out.println("len =" + len);
        System.out.println(new String(buf, 0, len));

        //获取字节输出流对象
        OutputStream out = socket.getOutputStream();
        //返回数据给客户端
        out.write("你好，TCP客户端！！！".getBytes());

        //关闭服务器
        //在实际开发中，服务器一般不会关闭
        serverSocket.close();
    }
}
