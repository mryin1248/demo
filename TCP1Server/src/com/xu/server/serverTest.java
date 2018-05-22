package com.xu.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTest {
  public static void main(String[] args) {
	  try {  
	 /* String ip="10.105.53.65";   //服务器端ip地址  
      int port=10002;        //端口号  
      Socket sck=new Socket(ip,port);  
      //2.传输内容  
      String content="这是一个java模拟客户端";  
      byte[] bstream=content.getBytes("GBK");  //转化为字节流  
      OutputStream os=sck.getOutputStream();   //输出流  
      os.write(bstream);  
      //3.关闭连接  
      sck.close();  */
	  
	
		ServerSocket serverSocket=new ServerSocket(7777);
		  serverSocket.getInetAddress();
		  System.out.println("设定服务端TCP协议端口为：8266");
		while (true) {
			
			Socket socket=serverSocket.accept();
			System.out.println("接收到的瓜皮信息："+ socket.getInetAddress());
			InputStream is=socket.getInputStream();
			byte[] b=new byte[1024];
			is.read(b);
			System.out.println(new String(b));
			System.out.println("有客户端通过TCP协议连接！");
			new ServerThread(socket).start();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e);
	}
}
}
