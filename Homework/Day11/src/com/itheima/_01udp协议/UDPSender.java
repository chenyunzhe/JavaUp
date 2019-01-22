package com.itheima._01udp协议;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 UDP发送端代码实现

 DatagramPacket构造方法
 DatagramPacket(byte[] buf, int length,
 InetAddress address, int port)
 * 创建发送端的数据包对象
 * buf：字节数组，要发送的数据
 * length：要发送内容的长度，单位：字节
 * address：接收端的IP地址对象：InetAddress
 * port：接收端的端口号

 DatagramPacket(byte[] buf, int length)
 * 创建接收端的数据包对象
 * buf：字节数组，存储接收到数据
 * length：能够接收内容的长度：字节

 DatagramSocket构造方法
 DatagramSocket()
 * 创建发送端的Socket对象，端口号是随机分配
 DatagramSocket(int port)
 * 根据端口号创建接收端的Socket对象
 */
public class UDPSender {
    public static void main(String[] args) throws Exception{
        // 要发送内容
        byte[] content = "你好，约么？".getBytes();

        // 创建数据包对象：用来封装要发送的数据
        DatagramPacket dp = new DatagramPacket(content, content.length,
                InetAddress.getLocalHost(), 6666);
        //InetAddress.getLocalHost()获取本机地址。
        // 创建发送对象：用来发送数据包
        // 相当于开启了一个进程，端口号随机分配
        DatagramSocket socket = new DatagramSocket(9999);
        //发送数据包
        socket.send(dp);
        //关闭Socket(套接字、插座)
        socket.close();

    }
}
