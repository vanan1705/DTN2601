package com.vti.testing.service;

import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDTO> findAll();
    DepartmentDTO findById(Integer id);

    DepartmentDTO findByName(String name);

    void create(DepartmentDTO department);

    void update(Integer id, DepartmentDTO departmentDTO);
}
