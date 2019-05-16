package com.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.test.bean.UserInfo;
import com.test.mapper.UserInfoMapper;
import com.test.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	UserInfoMapper userInfoMapper;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	private final static String BUSS_USER = "USER";

	@Override
	public UserInfo selectById(Integer userId) {
		// 1.根据ID从缓存中获取数据
		UserInfo user = (UserInfo) redisTemplate.opsForValue().get(BUSS_USER + userId);
		// 2.判断缓存数据是否存在，存在直接返回
		if (user != null) {
			logger.info("命中缓存:{}", JSON.toJSONString(user));
			return user;
		} else {
			// 3.缓存没有数据，从数据库查询
			user = userInfoMapper.selectById(userId);
			if (user != null) {
				logger.info("从数据库查询到:{}", JSON.toJSONString(user));
				// 4.查询结果写入缓存
				redisTemplate.opsForValue().set(BUSS_USER + userId, user);
			}
		}
		return user;
	}

	@Override
	public void insert(UserInfo info) {
		userInfoMapper.insert(info);
	}
}
