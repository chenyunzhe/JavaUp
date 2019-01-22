package com.itheima._03文件上传;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 TCP实现文件上传：服务器端代码实现--单用户上传
 */
public class TCPServer {
    public static void main(String[] args) throws Exception{
        //创建ServerSocket对象：端口号9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("开启服务器。。。");
        //等待客户端连接并获得Socket对象

        Socket socket = serverSocket.accept();
        FileOutputStream fos = null;
        try{
            int index = new Random().nextInt(987654345);
            //随机产生一个文件名：843975.jpg
            String fileName = index + System.currentTimeMillis() + ".jpg";
            //创建目标我呢间对象：D:\JavaUp\Homework\Day11\aaaa/894375.jpg
            File destFile = new File("D:\\JavaUp\\Homework\\Day11\\aaaa", fileName);
            //创建字节输出流关联目标文件
            fos = new FileOutputStream(destFile);

            //获取字节输入流对象
            InputStream in = socket.getInputStream();
            //创建字节数组：用来存储读取到客户端发送的图片数据
            byte[] buf = new byte[1024];
            //定义整型变量接收实际读取到的字节个数
            int len = -1;
            //循环读取客户端发送的图片数据
            while((len = in.read()) != -1){
                //利用fos将图片数据输出到目标文件中
                fos.write(buf,0,len);
            }
            //获取字节输出流对象
            OutputStream out = socket.getOutputStream();
            //往客户端返回数据
            out.write("上传成功".getBytes());
        } catch(Exception e) {
            //出现了异常
            //获得字节输出流对象
            OutputStream out = socket.getOutputStream();
            //往客户端返回数据
            out.write("上传失败".getBytes());
        }finally {
            //关闭流资源
            fos.close();
        }

    }
}
