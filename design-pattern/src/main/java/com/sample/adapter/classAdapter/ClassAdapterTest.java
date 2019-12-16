package com.sample.adapter.classAdapter;

import com.sample.adapter.Target;

/**
 * @Author: zhengyi
 * @Date: 2019/12/16 13:51
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}