package com.test.service;

import com.test.bean.UserInfo;

public interface UserInfoService {
	UserInfo selectById(Integer userId);
	
	void insert(UserInfo info);

	UserInfo findByUsername(String s);
}
