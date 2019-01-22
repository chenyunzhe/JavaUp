package com.itheima._02tcp协议;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 UDP ==> User Datagram Protocol 用户数据包(报)协议
 TCP ==> Transfer Control Protocol  传输控制协议

 TCP客户端代码实现

 Socket类常用方法
 * OutputStream getOutputStream(); 获得字节输出流对象
 * InputStream getInputStream(); 获得字节输入流对象
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 8888);
        System.out.println(socket);

        byte[] content = "你好 TCP 服务器端".getBytes();
        // 获得字节输出流
        OutputStream out = socket.getOutputStream();
        // 输出数据到服务器端
        out.write(content);

        // 读取服务器端返回的数据
        // 获得字节输入流对象
        InputStream in = socket.getInputStream();
        //创建字节数组
        byte[] buf = new byte[1024];
        //读取数据到字节数组中
        int len = in.read(buf);
        System.out.println("len =" + len);
        System.out.println(new String(buf,0,len));

        // 关闭socket
        socket.close();
    }
}
