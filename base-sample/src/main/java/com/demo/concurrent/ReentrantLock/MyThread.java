package com.demo.concurrent.ReentrantLock;

/**
 * @Author: zhengyi
 * @Date: 2019/10/18 14:01
 */
public class MyThread extends Thread {
    private MyTask myTask;

    public MyThread(MyTask myTask) {
        this.myTask = myTask;
    }

    @Override
    public void run() {
        myTask.execute();
    }
}
