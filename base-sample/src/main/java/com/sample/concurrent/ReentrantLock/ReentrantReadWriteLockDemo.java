package com.sample.concurrent.ReentrantLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，允许多个读线程同时访问，但不允许写线程和读线程、写线程和写线程同时访问
 *
 * @Author: zhengyi
 * @Date: 2019/10/18 15:05
 */
public class ReentrantReadWriteLockDemo {

    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    static HashMap<String, Object> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Object value = getObject("name");
                System.out.println(value + "  " + i);
            }
        }).start();
        new Thread(() -> {
            writeObject("name", "xiaoming");
        }).start();


        Thread.sleep(50000);
    }

    public static void writeObject(String key, Object value) {
        try {
            writeLock.lock();
            map.put(key, value);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            writeLock.unlock();
        }
    }

    public static Object getObject(String key) {
        try {
            readLock.lock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
