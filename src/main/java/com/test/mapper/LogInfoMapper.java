package com.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.bean.LogInfo;


@Mapper
public interface LogInfoMapper {
	LogInfo selectById(Integer id);

	void insert(LogInfo info);
}
