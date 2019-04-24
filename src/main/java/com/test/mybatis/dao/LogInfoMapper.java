package com.test.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.mybatis.model.LogInfo;


@Mapper
public interface LogInfoMapper {
	LogInfo selectById(Integer id);

	void insert(LogInfo info);
}
