package com.vti.testing.service;

import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Department;
import com.vti.testing.form.DeparmentSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<DepartmentDTO> findAll(Pageable pageable, DeparmentSearchForm form);
    DepartmentDTO findById(Integer id);

    DepartmentDTO findByName(String name);

    void create(DepartmentDTO department);

    void update(Integer id, DepartmentDTO departmentDTO);
}
