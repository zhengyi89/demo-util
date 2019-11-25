package com.demo.proxy.cglib;

/**
 * 被代理类
 * 
 * @author zhengy
 * @date: 2019年5月19日 下午8:57:59
 */
public class RealSubject1 {
	public void visit() {
		System.out.println("realsubject1 execute");
	}
}