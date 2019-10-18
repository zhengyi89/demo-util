package com.demo.concurrent.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhengyi
 * @Date: 2019/10/18 13:59
 */
public class MyTask {
    private Lock lock;

    public MyTask() {
        this.lock = new ReentrantLock();
    }

    public MyTask(boolean fair) {
        /**
         * ReentrantLock默认使用非公平锁，创建ReentrantLock对象时通过传参true创建公平锁
         */
        this.lock = new ReentrantLock(fair);
    }

    public void execute() {
        lock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        lock.unlock();
    }
}
