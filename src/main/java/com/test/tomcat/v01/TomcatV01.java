package com.test.tomcat.v01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TomcatV01 {

	private static ServerSocket serverSocket;

	public static void main(String[] args) throws IOException {
		serverSocket = new ServerSocket(8080);
		System.out.println("tomcat(v1.0)服务器已经启动... ");
		while (!serverSocket.isClosed()) { // 循环等待
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			System.out.println("执行线程信息：" + Thread.currentThread());
			System.out.println("开始接收请求...");
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				if (msg.length() == 0) {
					break;
				}
				System.out.println(msg);
			}
			// System.out.println("com.test.socket status : "+com.test.socket.get);
//			try {
//				Thread.sleep(10000L);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			String response = "Hello World";
			System.out.println("resp:" + response);
			OutputStream os = socket.getOutputStream();
			os.write(response.getBytes());
			is.close();
			br.close();
			os.flush();
			os.close();
			socket.close();

		}
	}
}
