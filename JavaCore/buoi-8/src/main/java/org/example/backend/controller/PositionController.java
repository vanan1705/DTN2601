package org.example.backend.controller;

import org.example.backend.service.IPositionService;
import org.example.backend.service.impl.DeparmentServiceImpl;
import org.example.backend.service.impl.PositionServiceImpl;
import org.example.entity.Department;
import org.example.entity.Position;

import java.util.List;

public class PositionController {
    IPositionService positionService = new PositionServiceImpl();
    public List<Position> findAll(){
        return positionService.findAll();
    };

    public boolean create(String newName){
        return positionService.create(newName);
    };
    public boolean update(int id, String updateName){
        return positionService.update(id, updateName);
    };
    public boolean delete(int id){
        return positionService.delete(id);
    };
    public List<Position> findByIdAndName(int searchId, String searchName) {
        return positionService.findByIdAndName(searchId, searchName);
    }
    public List<Position> getPositionWithMaxEmployee() {
        return positionService.getPositionWithMaxEmployee();
    }


    public List<Position> getPositionWithMinEmployee() {
        return positionService.getPositionWithMinEmployee();
    }
}
