package com.vti.testing.service.impl;


import com.vti.testing.Repository.IAccountRepository;
import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        Optional<Account> optional= accountRepository.findById(id);
        return optional.orElse(new Account());
    }

    @Override
    public Account findByUserName(String userName) {
        return null;
    }

    @Override
    public void create(Account account) {
        if (accountRepository.existsByEmailOrUserName(account.getEmail(),null)){
            throw  new RuntimeException("Email đã tồn tại");
        }
        if (accountRepository.existsByEmailOrUserName(null,account.getUserName())){
            throw  new RuntimeException("User Name đã tồn tại");
        }
        accountRepository.save(account);
    }

    @Override
    public Account update(Integer id, Account account) {
        Account accountUpdate = accountRepository.findById(id).orElse(null);
        if (Objects.isNull(accountUpdate)){
            throw  new RuntimeException("Id không tồn tại");
        }
        if (accountRepository.existsByEmailAndIdNot(account.getEmail(),id)){
            throw new RuntimeException("Email này đã tồn tại");
        }

        if (accountRepository.existsByUserNameAndIdNot(account.getUserName(),id)){
            throw new RuntimeException("User Name này đã tồn tại");
        }

        accountUpdate.setUserName(account.getUserName());
        accountUpdate.setEmail(account.getEmail());
        accountUpdate.setFullName(account.getFullName());

        return accountRepository.save(accountUpdate);
    }
}
