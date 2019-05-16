package com.test.service;

import com.test.bean.AccountWallet;

public interface AccountWalletService {

	AccountWallet selectByOpenId(String openId);

	int updateAccountWallet(AccountWallet record);
}
