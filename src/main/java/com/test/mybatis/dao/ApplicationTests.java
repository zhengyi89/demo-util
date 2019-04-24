package com.test.mybatis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.Application;
import com.test.mybatis.model.LogInfo;
import com.test.mybatis.service.LogInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ComponentScan
@MapperScan("com.test.mybatis.dao")
public class ApplicationTests {

	@Autowired
	LogInfoService logInfoService;

	@Test
	public void logInsert() {
		LogInfo info = new LogInfo();
		info.setVal("111");
		logInfoService.insert(info);
	}
}
