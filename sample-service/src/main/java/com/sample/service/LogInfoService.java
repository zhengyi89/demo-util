package com.sample.service;

import com.sample.model.LogInfo;

public interface LogInfoService {

    LogInfo selectById(Integer id);

    void insert(LogInfo info);
}
