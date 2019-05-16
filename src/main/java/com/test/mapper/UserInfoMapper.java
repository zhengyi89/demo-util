package com.test.mapper;

import com.test.bean.UserInfo;

public interface UserInfoMapper {
	int insert(UserInfo record);


	UserInfo selectById(Integer id);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);
}