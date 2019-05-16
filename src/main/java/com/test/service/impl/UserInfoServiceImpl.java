package com.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.test.anno.Cach;
import com.test.bean.UserInfo;
import com.test.mapper.UserInfoMapper;
import com.test.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	UserInfoMapper userInfoMapper;

	private final static String BUSS_USER = "USER";

	@Override
	@Cach(bussName = BUSS_USER, key = "#userId", needLog = true)
	public UserInfo selectById(Integer userId) {
		// 3.缓存没有数据，从数据库查询
		UserInfo user = userInfoMapper.selectById(userId);
		logger.info("从数据库查询到:{}", JSON.toJSONString(user));
		return user;
	}

	@Override
	public void insert(UserInfo info) {
		userInfoMapper.insert(info);
	}
}
