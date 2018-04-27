package com.test.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.mybatis.dao.AccountWalletMapper;
import com.test.mybatis.model.AccountWallet;
import com.test.mybatis.service.AccountWalletService;

public class AccountWalletServiceImpl implements AccountWalletService {
	
	@Autowired
	private AccountWalletMapper accountWalletMapper;

	@Override
	public AccountWallet selectByOpenId(String openId) {
		  return accountWalletMapper.selectByOpenId(openId);  
	}

	@Override
	public int updateAccountWallet(AccountWallet record) {
		 return accountWalletMapper.updateAccountWallet(record);  
	}

}
