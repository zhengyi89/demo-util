package com.sample.proxy.cglib;

/**
 * 被代理类
 *
 * @author zhengy
 * @date: 2019年5月19日 下午8:57:59
 */
public class CglibRealSubject {
    public void visit() {
        System.out.println("CglibRealSubject execute");
    }
}