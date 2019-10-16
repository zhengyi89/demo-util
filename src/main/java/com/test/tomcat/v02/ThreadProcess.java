package com.test.tomcat.v02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadProcess extends Thread {
	private Socket socket;

	public ThreadProcess(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
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

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
