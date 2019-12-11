package com.sample.service.impl;

import com.sample.mapper.AccountWalletMapper;
import com.sample.model.AccountWallet;
import com.sample.service.AccountWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
