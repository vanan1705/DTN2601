package org.example.backend.controller;

import org.example.backend.service.IUserService;
import org.example.backend.service.impl.UserServiceImpl;
import org.example.entity.User;

import java.util.List;

public class UserController {
    IUserService userService = new UserServiceImpl();
    public List<User> findAll() {
        return userService.findAll();
    }

    public List<User> findById(int id) {
        return userService.findById(id);
    }

    public boolean delete(int id) {
        return userService.delete(id);
    }

    public boolean create(String fullName, String email) {
        return userService.create(fullName, email);
    }
}
