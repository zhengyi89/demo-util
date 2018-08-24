package com.test.thread;

import javafx.scene.paint.Stop;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 18/8/1下午6:14
 */
public class ThreadTest {
    private static boolean stop;
    static volatile int a ;


    /*
     * 线程可见性测试
     */
    public void threadVisiableTest() throws InterruptedException {
        Thread t = new Thread(()->{
            int i = 0;
            while (!stop){
                System.out.println("------------"+i++);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });


        t.start();

        TimeUnit.SECONDS.sleep(1);

        stop = true;
    }


    public static void volidateTest(){
        System.out.println(a++);
    }


    public static void main(String[] args) throws InterruptedException {

        while (true){
            System.out.println(a++);
        }
    }

}
