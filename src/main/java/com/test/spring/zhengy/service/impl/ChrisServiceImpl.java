package com.test.spring.zhengy.service.impl;

import com.test.spring.zhengy.anno.SelfService;
import com.test.spring.zhengy.service.ChrisService;

@SelfService("chrisService")
public class ChrisServiceImpl implements ChrisService {

	@Override
	public String query(String name, String age) {
		return "my name is " + name + ", i am " + age + " years old;";
	}

}
