package com.sample.math;

import org.junit.Test;

public class LongSample {

    /**
     * long小于127
     */
    @Test
    public void doTest() {
        Long a = 100L;
        Long b = 100L;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == 100);
        System.out.println(a.equals(100));
    }

    /**
     * long大于127
     */
    @Test
    public void doTest2() {
        Long a = 128L;
        Long b = 128L;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == 128);
        System.out.println(a.equals(128));
    }
}
