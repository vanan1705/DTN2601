package org.example.backend.repository;

import org.example.entity.Account;


import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    boolean create(String newEmail, String newUserName, String newFullName, int newDepartmentId, int newPositionId);
    boolean update(int id, String updateEmail, String updateFullName, String updateUserName, int updateDepartmentId, int updatePositionId);
    boolean delete(int id);
    List<Account> findByIdAndName(int searchId, String searchUserName);
    boolean checkExistUserName(String userName, Integer id);
    boolean checkExistEmail(String email, Integer id);
    boolean createAccounts(List<Account> accounts)throws SQLException;
}
