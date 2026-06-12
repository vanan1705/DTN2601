package org.example.backend.service.impl;

import org.example.backend.repository.IUserRepository;
import org.example.backend.repository.impl.UserRepositoryImpl;
import org.example.backend.service.IUserService;
import org.example.entity.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean create(String fullName, String email) {
        return userRepository.create(fullName, email);
    }
}
