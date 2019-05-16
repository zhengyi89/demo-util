package com.test.service.impl;

import com.test.service.ChrisService;
import com.test.spring.zhengy.anno.SelfService;

@SelfService("chrisService")
public class ChrisServiceImpl implements ChrisService {

	@Override
	public String query(String name, String age) {
		return "my name is " + name + ", i am " + age + " years old;";
	}

}
