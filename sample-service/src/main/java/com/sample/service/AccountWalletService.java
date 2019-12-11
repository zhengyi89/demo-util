package com.sample.service;

import com.sample.model.AccountWallet;

public interface AccountWalletService {

    AccountWallet selectByOpenId(String openId);

    int updateAccountWallet(AccountWallet record);
}
