package com.xu.server;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread{

	private Socket socket;
	OutputStream outputStream;
	
	public ServerThread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%");
//			InputStream is=socket.getInputStream();
//			byte[] b=new byte[1024];
//			is.read(b);
			System.out.println("1%%%%%%%%%%%%%%%%%%%%%%%");
			outputStream=socket.getOutputStream();
			outputStream.write(("当前时间为："+new Date()).getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		super.run();
	}
	
}
