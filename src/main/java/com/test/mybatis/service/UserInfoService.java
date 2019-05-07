package com.test.mybatis.service;

import com.test.mybatis.model.UserInfo;

public interface UserInfoService {

	UserInfo selectById(Integer id);

	void insert(UserInfo info);
}
