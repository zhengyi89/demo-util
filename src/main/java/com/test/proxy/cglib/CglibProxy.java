package com.test.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于cglib实现动态代理
 * 
 * @author zhengy
 * @date: 2019年5月19日 下午9:04:33
 */
public class CglibProxy implements MethodInterceptor {
	// 业务类对象，供代理方法中进行真正的业务方法调用
	private Object target;

	// 相当于JDK动态代理中的绑定
	public Object getInstance(Object target) {
		this.target = target; // 给业务对象赋值
		Enhancer enhancer = new Enhancer(); // 创建加强器，用来创建动态代理类
		enhancer.setSuperclass(this.target.getClass()); // 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
		// 设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
		enhancer.setCallback(this);
		// 创建动态代理类对象并返回
		return enhancer.create();
	}

	// 实现回调方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib proxy invoke before...");
		Object rst = proxy.invokeSuper(obj, args); // 调用业务类（父类中）的方法
		System.out.println("cglib proxy invoke before...");
		return rst;
	}
}