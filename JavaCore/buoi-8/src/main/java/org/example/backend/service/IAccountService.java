package org.example.backend.service;

import org.example.entity.Account;
import org.example.entity.Position;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId);
    boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId);
    boolean delete(int id);

    boolean checkExistUserName(String userName, Integer id);
    boolean checkExistEmail(String email, Integer id);

    List<Account> findByIdAndName(int searchId, String searchUserName);
}
