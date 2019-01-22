package com.itheima._03文件上传;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 TCP实现文件上传：客户端代码实现
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        //创建Socket对象指定服务器IP和端口号
        Socket socket = new Socket("127.0.0.1", 9999);
        //创建字节输入流关联目标文件

        FileInputStream fis = new FileInputStream("D:\\JavaUp\\Homework\\Day11/66.jpg");
        //获得字节输出流对象
        OutputStream out = socket.getOutputStream();
        //创建字节数组：用来存储读取到图片数据
        byte[] buf = new byte[1024];
        //创建整型变量接收实际读取到的字节个数
        int len = -1;
        //循环读取图片数据
        while ((len = fis.read(buf)) != -1){//len = -1
            //利用out将字节数组的图片数据输出到服务器端
            out.write(buf,0,len);

        }

        //输出一个结束标记符：告诉服务器端数据传输完毕
        socket.shutdownOutput();
        //关闭字节输入流
        fis.close();

        //获得字节输入流对象
        InputStream in = socket.getInputStream();
        //读取服务器返回的上传状态字符串
        len = in.read(buf);
        System.out.println(new String(buf,0,len));

        //关闭socket对象
        socket.close();
    }
}
