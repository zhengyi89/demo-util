package com.demo.service.impl;

import com.demo.mapper.LogInfoMapper;
import com.demo.model.LogInfo;
import com.demo.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
