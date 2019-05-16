package com.test.service;

import com.test.bean.LogInfo;

public interface LogInfoService {

	LogInfo selectById(Integer id);

	void insert(LogInfo info);
}
