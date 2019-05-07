package com.test.mybatis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.Application;
import com.test.mybatis.model.LogInfo;
import com.test.mybatis.model.UserInfo;
import com.test.mybatis.service.LogInfoService;
import com.test.mybatis.service.UserInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Autowired
	LogInfoService logInfoService;
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired

	@Test
	public void logInsert() {
		LogInfo info = new LogInfo();
		info.setVal("111");
		logInfoService.insert(info);
	}
	
	@Test
	public void userInsert() {
		UserInfo info = new UserInfo();
		info.setName("zhengy");
		info.setMobile("15211111111");
		userInfoService.insert(info);
	}
}
