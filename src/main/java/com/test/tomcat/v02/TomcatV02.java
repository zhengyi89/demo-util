package com.test.tomcat.v02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.python.jline.internal.InputStreamReader;

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
