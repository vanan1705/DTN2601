package com.vti.testing.service;

import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountCreateForm;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

    AccountDTO findByUserName(String userName);

    void create(AccountCreateForm accountCreateForm);

    void update(Integer id, AccountCreateForm accountCreateForm);

    void deleteById(Integer id);
}
