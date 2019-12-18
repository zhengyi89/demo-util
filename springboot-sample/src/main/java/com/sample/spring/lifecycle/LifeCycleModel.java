package com.sample.spring.lifecycle;

/**
 * spring bean生命周期，创建-初始化-销毁
 *
 * @Author: zhengyi
 * @Date: 2019/12/17 16:15
 */
public class LifeCycleModel {
    public LifeCycleModel() {
        System.out.println("lifecycle construct ");
    }

    public void init() {
        System.out.println("lifecycle init....");
    }

    public void destory() {
        System.out.println("lifecycle destory.");
    }
}
