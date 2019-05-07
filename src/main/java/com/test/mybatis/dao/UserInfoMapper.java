package com.test.mybatis.dao;

import com.test.mybatis.model.UserInfo;

public interface UserInfoMapper {
	int insert(UserInfo record);


	UserInfo selectById(Integer id);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);
}