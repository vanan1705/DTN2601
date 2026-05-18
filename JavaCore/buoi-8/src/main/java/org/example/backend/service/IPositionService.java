package org.example.backend.service;

import org.example.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    boolean create(String newName);
    boolean update(int id, String updateName);
    boolean delete(int id);
    List<Position> findByIdAndName(int searchId, String searchName);
    List<Position> getPositionWithMaxEmployee();
    List<Position> getPositionWithMinEmployee();
    boolean checkExistName(String name, Integer id);

}
