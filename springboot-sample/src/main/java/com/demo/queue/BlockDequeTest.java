package com.demo.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class BlockDequeTest {
    public static final BlockingDeque<String> EMAILS = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    try {
                        EMAILS.put("put " + i);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }).start();


        while (true) {
            try {
                // 如果take不到，线程阻塞
                String s = EMAILS.take();
                System.out.println("take " + s);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
