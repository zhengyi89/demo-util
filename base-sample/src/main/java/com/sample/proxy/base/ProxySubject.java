package com.sample.proxy.base;

/**
 * 静态代理实现
 *
 * @author zhengy
 * @date: 2019年5月19日 下午8:41:11
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        System.out.println("代理方法。。。");
        subject.visit();
    }
}