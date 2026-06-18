package com.vti.testing.service.impl;

import aj.org.objectweb.asm.commons.Remapper;
import com.vti.testing.Repository.IDepartmentRepository;
import com.vti.testing.dto.AccountDTO;
import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Account;
import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired // khoi tao doi tuong
    private IDepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departments=  departmentRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for(Department dep: departments ){
            DepartmentDTO departmentDTO = modelMapper.map(dep, DepartmentDTO.class);
            departmentDTOS.add(departmentDTO);
        }

        return  departmentDTOS;
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
