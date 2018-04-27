package com.test.mybatis.dao;

import com.test.mybatis.model.AccountWallet;


public interface AccountWalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountWallet record);

    int insertSelective(AccountWallet record);

    AccountWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountWallet record);

    int updateByPrimaryKey(AccountWallet record);

	AccountWallet selectByOpenId(String openId);

	int updateAccountWallet(AccountWallet record);
}