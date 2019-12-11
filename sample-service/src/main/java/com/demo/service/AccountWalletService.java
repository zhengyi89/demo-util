package com.demo.service;

import com.demo.model.AccountWallet;

public interface AccountWalletService {

    AccountWallet selectByOpenId(String openId);

    int updateAccountWallet(AccountWallet record);
}
