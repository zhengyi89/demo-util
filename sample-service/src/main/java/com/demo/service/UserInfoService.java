package com.demo.service;

import com.demo.model.UserInfo;

public interface UserInfoService {
    UserInfo selectById(Integer userId);

    void insert(UserInfo info);

    UserInfo findByUsername(String s);
}
