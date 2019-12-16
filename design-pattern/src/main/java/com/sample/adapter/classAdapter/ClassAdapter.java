package com.sample.adapter.classAdapter;

import com.sample.adapter.Adaptee;
import com.sample.adapter.Target;

/**
 * 类适配器类
 *
 * @Author: zhengyi
 * @Date: 2019/12/16 14:03
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}