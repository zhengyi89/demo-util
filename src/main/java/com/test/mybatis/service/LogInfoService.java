package com.test.mybatis.service;

import com.test.mybatis.model.LogInfo;

public interface LogInfoService {

	LogInfo selectById(Integer id);

	void insert(LogInfo info);
}
