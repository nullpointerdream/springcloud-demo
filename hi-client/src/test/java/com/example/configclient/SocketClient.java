package com.example.configclient;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * @program: demo
 * @description:
 * @author: 陈家乐
 * @create: 2018-11-20 10:25
 **/

public class SocketClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8888))
        {
            // 建议为连接设置超时时间单位毫秒
            // 防止服务器接受了连接，但是之后出问题了，一直连接但是又没有响应，又不会断开。
            socket.setSoTimeout(10000);
            // 接受服务器信息
            /*InputStream in = socket.getInputStream();
            Reader r = new InputStreamReader(in, "UTF-8");
            BufferedReader reader = new BufferedReader(r);
            for (String line = reader.readLine(); !line.equals("."); line = reader.readLine())
            {
                System.out.println(line);
            }*/

            // 向服务器发送消息
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("hello,yunsheng");
            writer.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Socket s = new Socket();
       // // SocketAddress存储socket连接信息
     //   SocketAddress addr = new InetSocketAddress("localhost", 8888);
       /* try
        {
            // 第二个参数是超时时间，0表示无限等待
            s.connect(addr, 0);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

}
