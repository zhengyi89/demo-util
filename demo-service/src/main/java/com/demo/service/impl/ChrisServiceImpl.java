package com.demo.service.impl;

import com.demo.service.ChrisService;
import com.demo.zhengy.anno.SelfService;

@SelfService("chrisService")
public class ChrisServiceImpl implements ChrisService {

    @Override
    public String query(String name, String age) {
        return "my name is " + name + ", i am " + age + " years old;";
    }

}
