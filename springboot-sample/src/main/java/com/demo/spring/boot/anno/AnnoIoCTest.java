package com.demo.spring.boot.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoIoCTest {
	public static void main(String[] args) {
		String[] locations = { "beans.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(locations);
		Boss boss = (Boss) ctx.getBean("Boss");
		System.out.println(boss);
	}
}
