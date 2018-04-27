package com.test.math;


import java.math.BigDecimal;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		BigDecimal aDouble =new BigDecimal(1.22);
        System.out.println("construct with a double value: " + aDouble);
        BigDecimal aString = new BigDecimal("1.22");
        BigDecimal bString = new BigDecimal("1.22");
        System.out.println("construct with a String value: " + aString);
        BigDecimal ab = aString.add(bString);
        BigDecimal aa = aString.add(aDouble);
        System.out.println(ab);
        System.out.println(aa);
        
        BigDecimal a =new BigDecimal("1.22");

        System.out.println("construct with a String value: " + a);

        BigDecimal b =new BigDecimal("2.22");

        a.add(b);

        System.out.println("aplus b is : " + a);


//		for (int i = 0; i < 19; i++) {
//			Random r = new Random();
//			System.out.println(r.nextInt(10)+1);
//			System.out.println(String.format("%08d", r.nextInt(10)+1));
//		}
	}
}
