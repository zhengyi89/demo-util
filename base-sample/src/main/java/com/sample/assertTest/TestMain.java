package com.sample.assertTest;

import org.junit.Assert;

public class TestMain {

    public static void main(String[] args) {
        int i = 22795;
        System.out.println(i-i/8*8);
        Assert.assertTrue(3 > 2);
        System.out.println("程序正常");
    }

}
