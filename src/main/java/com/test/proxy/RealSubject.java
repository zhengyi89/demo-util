package com.test.proxy;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 18/7/17上午11:04
 */
public class RealSubject implements Subject {
    private String name = "byhieg";
    @Override
    public void visit() {
        System.out.println(name);
    }
}