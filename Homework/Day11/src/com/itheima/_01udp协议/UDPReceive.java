package com.itheima._01udp协议;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 UDP协议接收端代码实现
 */
public class UDPReceive {
    public static void main(String[] args) throws Exception{
        // 创建字节数组：存储接收到的数据
        byte[] buf = new byte[1024];
        // 创建数据接收对象：DatagramPacket
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        // 创建接收对象：DatagramSocket
        DatagramSocket socket = new DatagramSocket(6666);
        // 接收数据包
        socket.receive(dp);

        // 获得发送端的ip地址和端口号
        String sendIP = dp.getAddress().getHostAddress();
        System.out.println(sendIP);
        int sendPort = dp.getPort();

        // 获得实际接收到的字节个数
        int len = dp.getLength();
        System.out.println("len = " + len);
        // 将字节数组转换为字符串输出
        System.out.println(new String(buf,0,len));

        //关闭socket对象
        socket.close();
        System.out.println("asddf");
    }
}
