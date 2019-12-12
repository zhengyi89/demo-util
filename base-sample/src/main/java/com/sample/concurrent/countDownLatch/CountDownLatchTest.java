package com.sample.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        // testWaitThread();
        testConcurrent();
    }

    /**
     * 1、模拟所有子线程都执行完成后再执行主线程 countdownLatch计数，模拟子线程执行完成之后再执行主线程 这个也可以用future来实现
     */
    public static void testWaitThread() {

        final CountDownLatch latch = new CountDownLatch(2);
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            ;

        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();
        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程数量
     */
    public static final int THREAD_NUM = 100;

    /**
     * 开始时间
     */
    private static long startTime = 0L;

    /**
     * 2、模拟高并发
     */
    public static void testConcurrent() {
        try {
            startTime = System.currentTimeMillis();
            System.out.println("CountDownLatch started at: " + startTime);
            // 初始化计数器为1
            CountDownLatch countDownLatch = new CountDownLatch(1);
            for (int i = 0; i < THREAD_NUM; i++) {
                new Thread(new Run(countDownLatch)).start();
            }
            // 启动多个线程
            countDownLatch.countDown();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * 线程类
     */
    private static class Run implements Runnable {
        private final CountDownLatch startLatch;

        public Run(CountDownLatch startLatch) {
            this.startLatch = startLatch;
        }

        @Override
        public void run() {
            try {
                // 线程等待
                startLatch.await();
                // 模拟耗时操作
                Thread.sleep(3000);
                long endTime = System.currentTimeMillis();
                System.out
                        .println(Thread.currentThread().getName() + " ended at: " + endTime + ", cost: " + (endTime - startTime) + " ms.");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
