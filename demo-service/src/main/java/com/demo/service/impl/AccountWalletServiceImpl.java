package com.demo.service.impl;

import com.demo.mapper.AccountWalletMapper;
import com.demo.model.AccountWallet;
import com.demo.service.AccountWalletService;
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
