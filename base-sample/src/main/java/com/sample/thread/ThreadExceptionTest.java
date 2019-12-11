package com.sample.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExceptionTest {
	static Logger logger = LoggerFactory.getLogger(ThreadExceptionTest.class);

	public static void main(String[] args) {

		// 如果我们执行上面这段代码，会在控制台上看到异常输出。可能多数同学会对此不会觉得问题，但是问题在于，通常情况下绝大多数线上应用不会将控制台作为日志输出地址，而是另有日志输出。这种情况下，上面的代码所抛出异常便会丢失
//		Thread t = new Thread(() -> System.out.println(1 / 0));
//		t.start();

		//为了将异常输出到日志中，我们会这样写代码：
		Thread t = new Thread(() -> {
			try {
				System.out.println(1 / 0);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		});
		t.start();
	}
}
