package com.sample.adapter.ObjectAdapter;

import com.sample.adapter.Adaptee;
import com.sample.adapter.Target;

/**
 * @Author: zhengyi
 * @Date: 2019/12/16 13:58
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}