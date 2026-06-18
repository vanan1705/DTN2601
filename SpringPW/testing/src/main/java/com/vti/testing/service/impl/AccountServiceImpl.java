package com.vti.testing.service.impl;


import com.vti.testing.Repository.IAccountRepository;
import com.vti.testing.Repository.IDepartmentRepository;
import com.vti.testing.Repository.IPositionRepository;
import com.vti.testing.dto.AccountDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.entity.Position;
import com.vti.testing.form.AccountCreateForm;
import com.vti.testing.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (Account acc: accounts){

            AccountDTO dto = modelMapper.map(acc, AccountDTO.class);
            accountDTOS.add(dto);
        }
        return accountDTOS;
    }

    @Override
    public AccountDTO findById(Integer id) {
        Account account= accountRepository.findById(id).orElse(new Account());
        if (Objects.isNull(account)){
            throw new RuntimeException("Id không tìm thấy");
        }
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public AccountDTO findByUserName(String userName) {
        Account account= accountRepository.findByUserName(userName);
        if (Objects.isNull(account)){
            throw new RuntimeException("User Name không tìm thấy");
        }
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public void create(AccountCreateForm accountCreateForm) {
        Account account =new Account();
        account.setUserName(accountCreateForm.getUserName());
        account.setEmail(accountCreateForm.getEmail());
        account.setFullName(accountCreateForm.getFullName());
        if (accountRepository.existsByEmailOrUserName(account.getEmail(),null)){
            throw  new RuntimeException("Email đã tồn tại");
        }
        if (accountRepository.existsByEmailOrUserName(null,account.getUserName())){
            throw  new RuntimeException("User Name đã tồn tại");
        }
        Department department= departmentRepository.findById(accountCreateForm.getDepartmentId()).orElse(null);
        if (Objects.isNull(department)){
            throw new RuntimeException("Department Id not found!");
        }
        account.setDepartment(department);
        Position position= positionRepository.findById(accountCreateForm.getPositionId()).orElse(null);
        if (Objects.isNull(position)){
            throw new RuntimeException("Department Id not found!");
        }
        account.setPosition(position);
        accountRepository.save(account);
    }

    @Override
    public void update(Integer id, AccountCreateForm accountCreateForm) {
        Account accountUpdate = accountRepository.findById(id).orElse(null);
        if (Objects.isNull(accountUpdate)){
            throw  new RuntimeException("Id không tồn tại");
        }
        if (accountRepository.existsByEmailAndIdNot(accountCreateForm.getEmail(),id)){
            throw new RuntimeException("Email này đã tồn tại");
        }

        if (accountRepository.existsByUserNameAndIdNot(accountCreateForm.getUserName(),id)){
            throw new RuntimeException("User Name này đã tồn tại");
        }

        accountUpdate.setUserName(accountCreateForm.getUserName());
        accountUpdate.setEmail(accountCreateForm.getEmail());
        accountUpdate.setFullName(accountCreateForm.getFullName());

        Department department= departmentRepository.findById(accountCreateForm.getDepartmentId()).orElse(null);
        if (Objects.isNull(department)){
            throw new RuntimeException("Department Id not found!");
        }
        accountUpdate.setDepartment(department);
        Position position= positionRepository.findById(accountCreateForm.getPositionId()).orElse(null);
        if (Objects.isNull(position)){
            throw new RuntimeException("Department Id not found!");
        }
        accountUpdate.setPosition(position);

        accountRepository.save(accountUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }
}
