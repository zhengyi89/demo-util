package com.demo.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.demo.proxy.cglib.CglibProxy;
import com.demo.proxy.cglib.RealSubject1;
import com.demo.proxy.jdk.DynamicProxy;

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

	@Test
	public void cglibProxyTest() {
		CglibProxy cglib = new CglibProxy();
		RealSubject1 subject = (RealSubject1) cglib.getInstance(new RealSubject1());
		subject.visit();
	}
}
