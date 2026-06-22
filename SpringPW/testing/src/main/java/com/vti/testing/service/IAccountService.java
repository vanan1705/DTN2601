package com.vti.testing.service;

import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.form.AccountCreateForm;
import com.vti.testing.form.AccountSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<AccountDTO> findAll(Pageable pageable, AccountSearchForm form);

    AccountDTO findById(Integer id);

    AccountDTO findByUserName(String userName);

    void create(AccountCreateForm accountCreateForm);

    void update(Integer id, AccountCreateForm accountCreateForm);

    void deleteById(Integer id);
}
