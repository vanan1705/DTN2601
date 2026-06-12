package org.example.backend.service;

import org.example.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    List<User> findById(int id);
    boolean delete(int id);
    boolean create(String fullName, String email);
}
