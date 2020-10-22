package com.sample.thread;

/**
 * 线程内共享
 *
 * @Author: zhengyi
 * @Date: 2019/11/1 16:21
 */
public class ThreadLocalSample {
    static class MyThread extends Thread {
        private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        private static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                threadLocal.set(i);
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
                threadLocal1.set(i + 1);
                System.out.println(getName() + " threadLocal1.get() = " + threadLocal1.get());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread();
        myThreadA.setName("ThreadA");
        MyThread myThreadB = new MyThread();
        myThreadB.setName("ThreadB");
        myThreadA.start();
        myThreadB.start();
    }
}
