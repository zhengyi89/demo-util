package com.demo.concurrent.ReentrantLock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ReentrantLock实现同步锁
 *
 * @Author: zhengyi
 * @Date: 2019/10/18 14:00
 */
public class ReentrantLockTest {

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

}
