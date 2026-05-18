package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.entity.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    IAccountRepository accountRepository= new AccountRepositoryImpl();
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        return accountRepository.create(newEmail, newUserName,newFullName,newDepartmentId,newPositionId);
    }

    @Override
    public boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        return accountRepository.update(id, updateEmail, updateFullName, updateUserName, updateDepartmentId, updatePositionId);
    }

    @Override
    public boolean delete(int id) {
        return accountRepository.delete(id);
    }

    @Override
    public boolean checkExistUserName(String userName, Integer id) {
        return accountRepository.checkExistUserName(userName,id);
    }

    @Override
    public boolean checkExistEmail(String email, Integer id) {
        return accountRepository.checkExistEmail(email,id);
    }

    @Override
    public List<Account> findByIdAndName(int searchId, String searchUserName) {
        return accountRepository.findByIdAndName(searchId, searchUserName);
    }
}
