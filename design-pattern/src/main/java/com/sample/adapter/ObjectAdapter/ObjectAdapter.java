package com.sample.adapter.ObjectAdapter;

import com.sample.adapter.Adaptee;
import com.sample.adapter.Target;

/**
 * 对象适配器类
 *
 * @Author: zhengyi
 * @Date: 2019/12/16 13:58
 */
public class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
