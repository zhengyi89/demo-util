package com.sample.encode;

import java.io.UnsupportedEncodingException;

public class TestMain {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 不同编码方式，打印出二进制
		String str = new String("中".getBytes(), "utf-8");
		System.out.println(str.getBytes());
	}
}
