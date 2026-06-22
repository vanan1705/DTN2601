package com.vti.testing.controller;

import com.vti.testing.dto.DepartmentDTO;
import com.vti.testing.entity.Department;
import com.vti.testing.form.DeparmentSearchForm;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Page<DepartmentDTO>> findAll(Pageable pageable, DeparmentSearchForm form) {
        Page<DepartmentDTO>departmentDTOS = departmentService.findAll(pageable, form);
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable(name = "id") Integer id) {
        DepartmentDTO departmentDTO = departmentService.findById(id);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DepartmentDTO> findByName(@PathVariable(name = "name") String name) {
        DepartmentDTO departmentDTO = departmentService.findByName(name);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody DepartmentDTO departmentDTO) {
        departmentService.create(departmentDTO);
        return new ResponseEntity<>("Create successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") Integer id, @RequestBody DepartmentDTO departmentDTO) {
        departmentService.update(id, departmentDTO);
        return new ResponseEntity<>("Update successfully", HttpStatus.CREATED);
    }
}
