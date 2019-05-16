package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.AccountWallet;
import com.test.mapper.AccountWalletMapper;
import com.test.service.AccountWalletService;

@Service
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
