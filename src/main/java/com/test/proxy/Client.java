package com.test.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class Client {

	/**
	 * 动态代理测试
	 */
	@Test
	public void dynamicProxyTest() {
		Subject realSubject = new RealSubject();
		DynamicProxy proxy = new DynamicProxy(realSubject);
		Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject
				.getClass().getInterfaces(), proxy);
		subject.visit();
	}

	/**
	 * 静态代理测试
	 */
	@Test
	public void proxyTest() {
		ProxySubject subject = new ProxySubject(new RealSubject());
		subject.visit();
	}
}
