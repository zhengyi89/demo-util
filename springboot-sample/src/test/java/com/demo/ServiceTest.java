package com.demo;

import com.demo.model.LogInfo;
import com.demo.model.UserInfo;
import com.demo.service.LogInfoService;
import com.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ServiceTest {

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
		info.setUsername("zhengy");
		info.setMobile("15211111111");
		userInfoService.insert(info);
	}

	@Test
	public void selectUserByIdTest() {
		UserInfo user = userInfoService.selectById(1);
		System.out.println("------" + JSON.toJSONString(user));
	}

}
