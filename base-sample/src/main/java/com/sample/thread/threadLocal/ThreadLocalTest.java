package com.sample.thread.threadLocal;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * threadlocal数据维护在threadlocalMap中，key为当前线程id哈希值；
 * thread销毁后，threadlocalMap也会随之销毁
 *
 * @Author: zhengyi
 * @Date: 2020/6/15 15:16
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("set before：" + Thread.currentThread() + "-----" + threadLocal.get());
                    threadLocal.set(String.valueOf(RandomUtil.randomInt()));
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("set after：" + Thread.currentThread() + "-----" + threadLocal.get());
                }
            });
        }

    }
}
