package com.test.mybatis.service;

import com.test.mybatis.model.AccountWallet;

public interface AccountWalletService {

	AccountWallet selectByOpenId(String openId);

	int updateAccountWallet(AccountWallet record);
}
