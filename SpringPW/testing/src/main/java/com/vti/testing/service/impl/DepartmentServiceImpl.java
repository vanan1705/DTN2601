package com.vti.testing.service.impl;

import com.vti.testing.Repository.IDepartmentRepository;
import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired // khoi tao doi tuong
    private IDepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        Optional<Department> optional= departmentRepository.findById(id);
        return optional.orElse(new Department());
    }

    @Override
    public Department findByName(String name) {
        Department department  = departmentRepository.findByName(name);
        return department;
    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department update(Integer id, Department department) {
        Department departmentUpdate =departmentRepository.findById(id).orElse(null);
        if (Objects.isNull(departmentUpdate)){
            throw  new RuntimeException("Id không tồn tại");
        }
        if (departmentRepository.existsByNameAndIdNot(department.getName(),id)){
            throw new RuntimeException("Tên này đã tồn tại");
        }

        departmentUpdate.setName(department.getName());
        departmentRepository.save(departmentUpdate);
        return departmentUpdate;
    }
}
