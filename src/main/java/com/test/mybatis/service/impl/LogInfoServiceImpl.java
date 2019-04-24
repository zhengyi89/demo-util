package com.test.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mybatis.dao.LogInfoMapper;
import com.test.mybatis.model.LogInfo;
import com.test.mybatis.service.LogInfoService;

@Service("logInfoService")
public class LogInfoServiceImpl implements LogInfoService {

	@Autowired
	private LogInfoMapper logInfoMapper;

	@Override
	public LogInfo selectById(Integer id) {
		return logInfoMapper.selectById(id);
	}

	@Override
	public void insert(LogInfo info) {
		logInfoMapper.insert(info);
	}

}
