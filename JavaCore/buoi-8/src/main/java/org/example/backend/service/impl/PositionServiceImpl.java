package org.example.backend.service.impl;

import org.example.backend.repository.IPositonRepository;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IPositionService;
import org.example.entity.Department;
import org.example.entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    IPositonRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public boolean create(String newName) {
        return positionRepository.create(newName);
    }

    @Override
    public boolean update(int id, String updateName) {
        return positionRepository.update(id,updateName);
    }

    @Override
    public boolean delete(int id) {
        return positionRepository.delete(id);
    }

    @Override
    public List<Position> findByIdAndName(int searchId, String searchName) {
        return positionRepository.findByIdAndName(searchId, searchName);
    }

    @Override
    public List<Position> getPositionWithMaxEmployee() {
        return positionRepository.getPositionWithMaxEmployee();
    }

    @Override
    public List<Position> getPositionWithMinEmployee() {
        return positionRepository.getPositionWithMinEmployee();
    }
}
