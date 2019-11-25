package com.demo.proxy.base;

/**
 * 被代理对象
 *
 * @author zhengy
 * @date: 2019年5月19日 下午8:57:59
 */
public class RealSubject implements Subject {
    @Override
    public void visit() {
        System.out.println("realsubject execute");
    }
}