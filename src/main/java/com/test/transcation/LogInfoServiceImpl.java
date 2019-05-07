package com.test.transcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mybatis.dao.LogInfoMapper;
import com.test.mybatis.model.LogInfo;

@Service("log")
public class LogInfoServiceImpl {

	@Autowired
	private LogInfoMapper logInfoMapper;

	public LogInfo selectById(Integer id) {
		return logInfoMapper.selectById(id);
	}

	public void insert(LogInfo info) {
		logInfoMapper.insert(info);
	}

}
