package com.test.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mybatis.dao.UserInfoMapper;
import com.test.mybatis.model.UserInfo;
import com.test.mybatis.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfo selectById(Integer id) {
		return userInfoMapper.selectById(id);
	}

	@Override
	public void insert(UserInfo info) {
		userInfoMapper.insert(info);
	}

}
