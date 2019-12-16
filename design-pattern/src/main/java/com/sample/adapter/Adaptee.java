package com.sample.adapter;

/**
 * 要适配的类
 *
 * @Author: zhengyi
 * @Date: 2019/12/16 14:02
 */
public class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}
