package com.sample.service.impl;

import com.sample.service.ChrisService;
import com.sample.zhengy.anno.SelfService;

@SelfService("chrisService")
public class ChrisServiceImpl implements ChrisService {

    @Override
    public String query(String name, String age) {
        return "my name is " + name + ", i am " + age + " years old;";
    }

}
