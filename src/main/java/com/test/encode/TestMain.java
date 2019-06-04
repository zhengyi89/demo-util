package com.test.encode;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestMain {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// 不同编码方式，打印出二进制
		String str = new String("中".getBytes(), "utf-8");
		System.out.println(str.getBytes());
	}
	
	
	@Test
    public void encoder() {
        String password = "admin";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }
}
