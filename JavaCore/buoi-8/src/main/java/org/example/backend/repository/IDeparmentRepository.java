package org.example.backend.repository;

import org.example.entity.Department;

import java.util.List;

public interface IDeparmentRepository {
    List<Department> findAll();
    boolean create(String newName);
    boolean update(int id, String updateName);
    boolean delete(int id);
    List<Department> findByIdAndName(int searchId, String searchName);
    List<Department> getDeparmentWithMaxEmployee();
    List<Department> getDeparmentWithMinEmployee();
    boolean checkExistName(String name, Integer id);
}
