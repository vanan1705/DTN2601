package com.vti.testing.service;

import com.vti.testing.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department findById(Integer id);

    Department findByName(String name);

    void create(Department department);

    Department update(Integer id, Department department);
}
