package com.sample.util.concurrent.ReentrantLock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ReentrantLock实现同步锁
 *
 * @Author: zhengyi
 * @Date: 2019/10/18 14:00
 */
public class ReentrantLockDemo {

    /**
     * ReentrantLock实现同步锁
     */
    @Test
    public void loctTest() throws InterruptedException {
        MyTask myTask = new MyTask();
        MyThread mt1 = new MyThread(myTask);
        mt1.setName("mt1");
        MyThread mt2 = new MyThread(myTask);
        mt2.setName("mt2");
        mt1.start();
        mt2.start();

        Thread.sleep(1000);

    }


    /**
     * ReentrantLock-默认实现为非公平锁（随机分配使用权）
     */
    @Test
    public void fairnessTest() throws InterruptedException {
        MyTask myTask = new MyTask(false);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyThread mt1 = new MyThread(myTask);
            mt1.setName("mt" + i);
            threadList.add(mt1);
        }
        for (Thread thread : threadList) {
//            System.out.println(thread.getName()+" start");
            thread.start();
        }
        Thread.sleep(5000);
    }


    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
    }
}
