/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
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
