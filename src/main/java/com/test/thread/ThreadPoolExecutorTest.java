package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 
 * Java通过Executors提供四种线程池，分别为：
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 newScheduledThreadPool
 * 创建一个定长线程池，支持定时及周期性任务执行。 newSingleThreadExecutor
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 
 * @author zhengy
 *
 */
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutorTest t = new ThreadPoolExecutorTest();
//		 t.newCachedThreadPoolTest();
		 t.newFixedThreadPoolTest();
//		t.newScheduledThreadPoolTest();
//		t.newSingleThreadExecutorTest();
	}

	/**
	 * 建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 */
	@Test
	public void newCachedThreadPoolTest() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			final int index = i;
			try {
				Thread.sleep(1 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}

	/**
	 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
	 */
	@Test
	public void newFixedThreadPoolTest() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(13);
		for (int i = 0; i < 100; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		System.out.println("shutdown previous");
		fixedThreadPool.shutdown();
		System.out.println("shutdown");
	}

	/**
	 * 创建一个定长线程池，支持定时及周期性任务执行。
	 */
	public void newScheduledThreadPoolTest() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		/*
		 * 表示延迟3秒执行
		 */
		// scheduledThreadPool.schedule(new Runnable() {
		// public void run() {
		// System.out.println("delay 3 seconds");
		// }
		// }, 3, TimeUnit.SECONDS);
		/*
		 * 表示延迟1秒后每3秒执行一次
		 */
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
	}

	/**
	 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
	 */
	public void newSingleThreadExecutorTest() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		singleThreadExecutor.isShutdown();
	}

}
