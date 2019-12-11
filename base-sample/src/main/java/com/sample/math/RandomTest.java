package com.sample.math;

import java.util.Random;

public class RandomTest {
	// int i = Math.random()*100;
	// public static void main(String[] args) {
	// for (int i = 0; i < 100; i++) {
	// System.out.println(Math.random()*10);
	// }
	// }
	// 生成6位随机数
	public int nextInt(final int min, final int max) {
		Random rand = new Random();
		int tmp = Math.abs(rand.nextInt());
		return tmp % (max - min + 1) + min;
	}

	//生成随机数，位数不足用0补
	public String getRandom(int i) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < i; j++) {
			sb.append((int)(Math.random()*10));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		RandomTest rt = new RandomTest();
		for (int i = 0; i < 50; i++) {
//			System.out.println(.nextInt(0, 100000));
			System.out.println(rt.getRandom(6) );
//			System.out.println((int)(Math.random()*10));
		}
	}
}
