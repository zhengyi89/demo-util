package com.demo.math;

public class IntegerTest {
	public static void main(String[] args) {
		Integer i1 = new Integer(12);
		Integer i2 = new Integer(12);
		System.out.println(i1.equals(i2));
		System.out.println(i1==i2);
		
		int i = 127;
		Integer i3 = Integer.valueOf(i);
		Integer i4 = Integer.valueOf(i);
		System.out.println(i3==i4);
	}

}
