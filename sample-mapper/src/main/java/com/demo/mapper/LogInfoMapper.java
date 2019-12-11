package com.demo.mapper;


import com.demo.model.LogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogInfoMapper {
	LogInfo selectById(Integer id);

	void insert(LogInfo info);
}
