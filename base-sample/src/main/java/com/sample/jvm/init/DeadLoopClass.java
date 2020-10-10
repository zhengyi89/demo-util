package com.sample.jvm.init;

/**
 * 类初始化线程加锁
 *
 * @Author: zhengyi
 * @Date: 2020/9/29 15:03
 */
public class DeadLoopClass {
    static {
        if (true){
            System.out.println(Thread.currentThread()+"  init DeadLoopClass");
            try {
                System.out.println("before init ....");
                Thread.sleep(2000L);
                System.out.println("init over ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() +"  start");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() +" init over");
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
