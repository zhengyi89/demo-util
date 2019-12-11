package com.sample.service;

import com.sample.model.UserInfo;

public interface UserInfoService {
    UserInfo selectById(Integer userId);

    void insert(UserInfo info);

    UserInfo findByUsername(String s);
}
