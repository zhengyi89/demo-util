package com.sample.service.impl;

import com.sample.mapper.LogInfoMapper;
import com.sample.model.LogInfo;
import com.sample.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logInfoService")
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Override
    public LogInfo selectById(Long id) {
        return logInfoMapper.selectById(id);
    }

    @Override
    public void insert(LogInfo info) {
        logInfoMapper.insert(info);
    }

}
