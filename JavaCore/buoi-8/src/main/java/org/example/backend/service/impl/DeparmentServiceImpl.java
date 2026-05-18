package org.example.backend.service.impl;

import org.example.backend.repository.IDeparmentRepository;
import org.example.backend.repository.impl.DeparmentRepositoryImpl;
import org.example.backend.service.IDeparmentService;
import org.example.entity.Department;

import java.util.List;

public class DeparmentServiceImpl implements IDeparmentService {
    IDeparmentRepository deparmentRepository = new DeparmentRepositoryImpl();
    @Override
    public List<Department> findAll() {

        return deparmentRepository.findAll();
    }

    @Override
    public boolean create(String newName) {
        return deparmentRepository.create(newName);
    }

    @Override
    public boolean update(int id, String updateName) {
        return deparmentRepository.update(id, updateName);
    }

    @Override
    public boolean delete(int id) {
        return deparmentRepository.delete(id);
    }

    @Override
    public List<Department> findByIdAndName(int searchId, String searchName) {
        return deparmentRepository.findByIdAndName(searchId, searchName);
    }

    @Override
    public List<Department> getDeparmentWithMaxEmployee() {
        deparmentRepository.getDeparmentWithMaxEmployee();
        return null;
    }

    @Override
    public List<Department> getDeparmentWithMinEmployee() {
        deparmentRepository.getDeparmentWithMinEmployee();
        return null;
    }

    @Override
    public boolean checkExistName(String name, Integer id) {
        return deparmentRepository.checkExistName(name, id);
    }

}
