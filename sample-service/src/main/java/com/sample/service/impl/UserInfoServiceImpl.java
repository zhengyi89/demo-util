package com.sample.service.impl;

import com.alibaba.fastjson.JSON;
import com.sample.anno.Cach;
import com.sample.mapper.UserInfoMapper;
import com.sample.model.UserInfo;
import com.sample.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    UserInfoMapper userInfoMapper;

    private final static String BUSS_USER = "USER";

    @Override
    @Cach(bussName = BUSS_USER, key = "#userId", needLog = true)
    public UserInfo selectById(Long userId) {
        // 3.缓存没有数据，从数据库查询
        UserInfo user = userInfoMapper.selectById(userId);
        logger.info("从数据库查询到:{}", JSON.toJSONString(user));
        return user;
    }

    @Override
    public void insert(UserInfo info) {
        userInfoMapper.insert(info);
    }

    @Override
    public UserInfo findByUsername(String s) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(s);
        List<UserInfo> userList = userInfoMapper.findList(userInfo);
        return userList == null ? null : userList.get(0);
    }
}
