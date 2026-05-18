package org.example.backend.controller;

import org.example.backend.service.IDeparmentService;
import org.example.backend.service.impl.DeparmentServiceImpl;
import org.example.entity.Department;

import java.util.List;

public class DeparmentController {
    IDeparmentService deparmentService = new DeparmentServiceImpl();
     public List<Department> findAll(){
         return deparmentService.findAll();
     };

    public boolean create(String newName){
        return deparmentService.create(newName);
    };
    public boolean update(int id, String updateName){
        return deparmentService.update(id, updateName);
    };
    public boolean delete(int id){
        return deparmentService.delete(id);
    };
    public List<Department> findByIdAndName(int searchId, String searchName) {
        return deparmentService.findByIdAndName(searchId, searchName);
    }
    public List<Department> getDeparmentWithMaxEmployee() {
       return deparmentService.getDeparmentWithMaxEmployee();
    }


    public List<Department> getDeparmentWithMinEmployee() {
        return deparmentService.getDeparmentWithMinEmployee();
    }

    public boolean checkExistName(String name, Integer id) {
        return deparmentService.checkExistName(name, id);
    }
}
