package com.sample.service;

import com.sample.model.UserInfo;

public interface UserInfoService {
    UserInfo selectById(Long userId);

    void insert(UserInfo info);

    UserInfo findByUsername(String s);
}
