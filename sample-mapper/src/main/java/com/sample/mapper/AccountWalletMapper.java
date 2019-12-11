package com.sample.mapper;


import com.sample.model.AccountWallet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountWalletMapper extends GenericRepository {
    AccountWallet selectByOpenId(String openId);
}