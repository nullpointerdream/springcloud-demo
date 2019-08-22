package com.example.configclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: demo
 * @description:
 * @author: 陈家乐
 * @create: 2018-11-20 10:26
 **/

public class SocketServer {

    // 服务器端socket基本生命周期如下
    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;
        try
        {
            // 1，在特定端口创建一个serverSocket
            serverSocket = new ServerSocket(8888);
            System.out.println("start server socket=================");

            while (true)
            {
                // 2，使用accept()方法监听入站连接，accept()会一直阻塞，直到有一个客户端尝试连接，accept()会返回一个Socket
                Socket clientSocket = null;
                try
                {
                    // 区分server端和client的异常
                    clientSocket = serverSocket.accept();
                    System.out.println("get a connection----------");
                    // 3,根据服务的不同，调用clientSocket的getOutputStream()或getInputStream()得到客户端的输入或输出
                    //OutputStream outputStream = clientSocket.getOutputStream();
                    InputStream inputStream = clientSocket.getInputStream();

                    // 4,得到输入输出流之后，开始交互
                    Reader reader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                 //   Writer writer = new OutputStreamWriter(outputStream);
                    StringBuilder content = new StringBuilder();
                    for (String line = bufferedReader.readLine(); line!=null; line = bufferedReader.readLine())
                    {
                        content.append(line);
                    }
                    Thread.sleep(10000);
                    System.out.println(content.toString());
                   // writer.write("content is : " + content.toString());
                   // writer.flush();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally
                {
                    if (null != clientSocket)
                    {
                        // 5,双方有一方或者双方都关闭连接
                        // 服务器端不要依赖客户端一定会关闭socket。可以自己控制。
                        clientSocket.close();
                    }
                }
            }
            // 6,服务端返回状态2
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            if (null != serverSocket)
            {
                try
                {
                    serverSocket.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
