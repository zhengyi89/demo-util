package com.sample.proxy;

import com.sample.proxy.base.ProxySubject;
import com.sample.proxy.base.RealSubject;
import com.sample.proxy.base.Subject;
import com.sample.proxy.cglib.CglibProxy;
import com.sample.proxy.cglib.CglibRealSubject;
import com.sample.proxy.jdk.DynamicProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class Client {

    /**
     * 静态代理测试
     */
    @Test
    public void proxyTest() {
        ProxySubject subject = new ProxySubject(new RealSubject());
        subject.visit();
    }

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
     * cglib动态代理
     */
    @Test
    public void cglibProxyTest() {
        CglibProxy cglib = new CglibProxy();
        CglibRealSubject subject = (CglibRealSubject) cglib.getInstance(new CglibRealSubject());
        subject.visit();
    }
}
