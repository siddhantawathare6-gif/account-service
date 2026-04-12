package com.bank.account.mapper;

import com.bank.account.dto.AccountDto;
import com.bank.account.entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account, AccountDto accountDto){
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());
        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto, Account account){
        account.setAccountType(accountDto.getAccountType());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }

}
