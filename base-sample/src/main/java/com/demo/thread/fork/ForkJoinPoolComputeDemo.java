package com.demo.thread.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * 通常我们不会直接使用ForkJoinTask，而是使用它的两个抽象子类： RecursiveAction：没有返回值的任务
 * RecursiveTask：有返回值的任务
 * 
 * @author zhengy
 * @date: 2019年4月8日 下午8:29:24
 */
public class ForkJoinPoolComputeDemo {
	private class SumTask extends RecursiveTask<Integer> {

		private static final int THRESHOLD = 20;

		private int arr[];
		private int start;
		private int end;

		public SumTask(int[] arr, int start, int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}

		/**
		 * 小计
		 */
		private Integer subtotal() {
			Integer sum = 0;
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
			return sum;
		}

		@Override
		protected Integer compute() {

			if ((end - start) <= THRESHOLD) {
				return subtotal();
			} else {
				int middle = (start + end) / 2;
				SumTask left = new SumTask(arr, start, middle);
				SumTask right = new SumTask(arr, middle, end);
				left.fork();
				right.fork();

				return left.join() + right.join();
			}
		}
	}

//	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		int[] arr = new int[100];
//		for (int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}
//
//		ForkJoinPool pool = new ForkJoinPool();
//		ForkJoinTask<Integer> result = pool.submit(new ForkJoinPoolComputeDemo().new SumTask(arr, 0, arr.length));
//		System.out.println("最终计算结果: " + result.invoke());
//		pool.shutdown();
//	}

	static class Sum extends RecursiveTask<Long> {
		public static long sum(int[] array) {
			return ForkJoinPool.commonPool().invoke(new Sum(array, 0, array.length));
		}

		private final int[] array;
		private final int lo, hi;

		private Sum(int[] array, int lo, int hi) {
			this.array = array;
			this.lo = lo;
			this.hi = hi;
		}

		private static final int THRESHOLD = 600;

		@Override
		protected Long compute() {
			if (hi - lo < THRESHOLD) {
				return sumSequentially();
			} else {
				int middle = (lo + hi) >>> 1;
				Sum left = new Sum(array, lo, middle);
				Sum right = new Sum(array, middle, hi);
				right.fork();
				long leftAns = left.compute();
				long rightAns = right.join();
				// 注意subTask2.fork要在subTask1.compute之前
				// 因为这里的subTask1.compute实际上是同步计算的
				return leftAns + rightAns;
			}
		}

		private long sumSequentially() {
			long sum = 0;
			for (int i = lo; i < hi; i++) {
				sum += array[i];
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		int[] array = IntStream.rangeClosed(1, 100_0000).toArray();
		Long sum = Sum.sum(array);
		System.out.println(sum);
	}
}
