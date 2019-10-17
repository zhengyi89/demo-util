package com.demo.tomcat.v02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatV02 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("tomcat(v2.0)服务器已经启动... ");
		while (!serverSocket.isClosed()) { // 循环等待
			Socket socket = serverSocket.accept();
			Thread thread = new ThreadProcess(socket);
			thread.start();
		}
	}
}
