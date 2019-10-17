package com.demo.thread;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
	public static void main(final String... args) throws InterruptedException, ExecutionException {
		final ExecutorService es = Executors.newFixedThreadPool(80);
//		final String ip = "192.168.1.4";
		final String ip = "113.119.71.151";
		final int timeout = 200;
		final List<Future<Boolean>> futures = new ArrayList<>();
		for (int port = 1; port <= 65535; port++) {
			futures.add(portIsOpen(es, ip, port, timeout));
		}
		es.shutdown();
		int openPorts = 0;
		for (final Future<Boolean> f : futures) {
			if (f.get()) {
				openPorts++;
			}
		}
		System.out.println("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of "
				+ timeout + "ms)");
	}

	public static Future<Boolean> portIsOpen(final ExecutorService es, final String ip, final int port,
			final int timeout) {
		return es.submit(new Callable<Boolean>() {
			@Override
			public Boolean call() {
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(ip, port), timeout);
					socket.close();
					System.out.println("port:"+port+" is open");
					return true;
				} catch (Exception ex) {
//					System.out.println("port:"+port+" is closed");
					return false;
				}
			}
		});
	}

}
