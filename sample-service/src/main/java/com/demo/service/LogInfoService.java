package com.demo.service;

import com.demo.model.LogInfo;

public interface LogInfoService {

    LogInfo selectById(Integer id);

    void insert(LogInfo info);
}
