package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.impl.AccountServiceImpl;
import org.example.entity.Account;

import java.util.List;

public class AccountController {
    IAccountService accountService = new AccountServiceImpl();

    public List<Account> findAll() {
        return accountService.findAll();
    }

    public boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId) {
        return accountService.create(newEmail, newUserName,newFullName,newDepartmentId,newPositionId);
    }

    public boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId) {
        return accountService.update(id, updateEmail, updateFullName, updateUserName, updateDepartmentId, updatePositionId);
    }

    public boolean delete(int id) {
        return accountService.delete(id);
    }

    public List<Account> findByIdAndName(int searchId, String searchUserName) {
        return accountService.findByIdAndName(searchId, searchUserName);
    }
    public boolean checkExistUserName(String userName, Integer id) {
        return accountService.checkExistUserName(userName,id);
    }

    public boolean checkExistEmail(String email, Integer id) {
        return accountService.checkExistEmail(email,id);
    }
    public String importAccountToCSV(String pathName) {// trả về String; import thành công, import thất bại
        return accountService.importAccountToCSV(pathName);
    }
}
