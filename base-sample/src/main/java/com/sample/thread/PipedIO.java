package com.sample.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedIO {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		Sender s = new Sender();
		Receiver r = new Receiver(s);
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(s);
		es.execute(r);
		TimeUnit.SECONDS.sleep(4);
		es.shutdownNow();
	}
}

class Sender implements Runnable {
	private Random rand = new Random(47);
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter() {
		return out;
	}

	@Override
	public void run() {
		while (true) {
			for (char c = 'A'; c < 'z'; c++) {
				try {
					out.write(c);
					// TimeUnit.MILLISECONDS.sleep(rand.nextInt(5000));
				} catch (IOException e) {
					e.printStackTrace();
					Thread.interrupted();
				}
			}
		}
	}
}

class Receiver implements Runnable {
	private PipedReader in;

	public Receiver(Sender sender) throws IOException {
		in = new PipedReader(sender.getPipedWriter());
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("read:" + (char) in.read() + ", ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}