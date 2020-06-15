package com.sample.mapper;

import com.sample.model.LogInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * @Transactional,测试数据回滚
 * @Author: zhengyi
 * @Date: 2019/12/12 14:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MapperTests {

    @Autowired
    private LogInfoMapper logInfoMapper;


    @Test
    public void logSelectByIdTest() {
        LogInfo logInfo = logInfoMapper.selectById(1L);
        assertNotNull(logInfo);
    }

    @Test
    public void logInsertTest() {
        LogInfo logInfo = new LogInfo();
        logInfo.setVal("----------");
        logInfoMapper.insert(logInfo);
    }

}
