package org.example.backend.repository;

import org.example.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    List<User> findById(int id);
    boolean delete(int id);
    boolean create(String fullName, String email);
    boolean checkExitFullNameOrEmail(String fullName, String email);
}
