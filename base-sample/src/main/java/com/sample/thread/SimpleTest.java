package com.sample.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleTest {
//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		ExecutorService threadPool = Executors.newFixedThreadPool(10);
//		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
//		for (int i = 0; i < 100; i++) {
//			list.add(met(threadPool, i));
//		}
//		
//		
//		
//		threadPool.shutdown();
//		System.out.println("main thread before sleep ");
//		Thread.sleep(5000);
//		System.out.println("main thread after sleep ");
//		
////		for (Future<Integer> future : list) {
////			System.out.println(future.get());
////		}
//		
//		for (int i = 0; i< list.size(); i++) {
//			Future<Integer> future2 = list.get(i);
//			System.out.println("before output "+i);
//			System.out.println("输出结果："+future2.get());
//			System.out.println("after output "+i);
//		}
//	}

	private static Future<Integer> met(ExecutorService threadPool, int i) {
		return threadPool.submit(new Callable<Integer>() {
            @Override
			public Integer call() throws Exception {
				System.out.println("before sleep"+i);
				Thread.sleep(1000);
				System.out.println("after sleep"+i);
				return new Random().nextInt(100);
			}
		});
	}
	
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for(int i = 1; i < 5; i++) {
            final int taskID = i;
            cs.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        // 可能做一些事情
        for(int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
	}
}
