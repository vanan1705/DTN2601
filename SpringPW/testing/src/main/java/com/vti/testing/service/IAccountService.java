package com.vti.testing.service;

import com.vti.testing.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    Account findByUserName(String userName);

    void create(Account account);

    Account update(Integer id, Account account);
}
