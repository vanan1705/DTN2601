package com.vti.testing.service.impl;


import com.vti.testing.Repository.IDepartmentRepository;
import com.vti.testing.dto.DepartmentDTO;

import com.vti.testing.entity.Department;
import com.vti.testing.form.DeparmentSearchForm;
import com.vti.testing.service.IDepartmentService;

import com.vti.testing.specification.DeparmentCustomSpecification;
import io.micrometer.common.util.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired // khoi tao doi tuong
    private IDepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<DepartmentDTO> findAll(Pageable pageable, DeparmentSearchForm form) {
     Specification<Department> where = Specification.unrestricted();
        if(StringUtils.isNotEmpty(form.getName())){
            DeparmentCustomSpecification name = new DeparmentCustomSpecification("name",form.getName());
            where = where.and(name);
        }

        Page<Department> departmentPage=  departmentRepository.findAll(where, pageable);
        Page<DepartmentDTO> dtoPage = departmentPage.map(department ->modelMapper.map(department, DepartmentDTO.class));
        return  dtoPage;
    }

    @Override
    public DepartmentDTO findById(Integer id) {
        Department department = departmentRepository.findById(id).orElse(new Department());
        if (Objects.isNull(department)){
            throw new RuntimeException("Id không tìm thấy");
        }
        return modelMapper.map(department, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO findByName(String name) {
        Department department = departmentRepository.findByName(name);
        if (Objects.isNull(department)){
            throw new RuntimeException("Department Name không tìm thấy");
        }
        return modelMapper.map(department, DepartmentDTO.class);
    }

    @Override
    public void create(DepartmentDTO departmentDTO) {
        Department department =new Department();
        department.setName(departmentDTO.getName());
        departmentRepository.save(department);
    }

    @Override
    public void update(Integer id, DepartmentDTO departmentDTO) {
        Department departmentUpdate =departmentRepository.findById(id).orElse(null);
        if (Objects.isNull(departmentUpdate)){
            throw  new RuntimeException("Id không tồn tại");
        }
        if (departmentRepository.existsByNameAndIdNot(departmentDTO.getName(),id)){
            throw new RuntimeException("Tên này đã tồn tại");
        }

        departmentUpdate.setName(departmentDTO.getName());
        departmentRepository.save(departmentUpdate);
    }
}
