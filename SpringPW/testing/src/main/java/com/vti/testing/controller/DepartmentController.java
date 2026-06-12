package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> findById(@PathVariable(name = "id") Integer id) {
        Department department = departmentService.findById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Department> findByName(@PathVariable(name = "name") String name) {
        Department department = departmentService.findByName(name);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> create (@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Department> update (@PathVariable(name = "id") Integer id, @RequestBody Department department) {
        departmentService.update(id, department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
}
