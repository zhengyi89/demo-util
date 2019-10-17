package com.demo.thread;

import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.ThreadPoolExecutor;  
import java.util.concurrent.TimeUnit;  
  
public class MyThreadPoolExecutor extends ThreadPoolExecutor {  
  
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,  
            long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {  
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);  
    }  
  
    @Override  
    protected void afterExecute(Runnable r, Throwable t) {  
        super.afterExecute(r, t);  
        System.out.println("MyThreadPoolExecutor.afterExecute()");  
    }  
  
}  