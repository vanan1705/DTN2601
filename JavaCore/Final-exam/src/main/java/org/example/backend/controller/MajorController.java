package org.example.backend.controller;

import org.example.backend.service.IMajorService;
import org.example.backend.service.impl.MajorServiceImpl;
import org.example.entity.Major;

import java.sql.SQLException;
import java.util.List;

public class MajorController {
    IMajorService majorService = new MajorServiceImpl();
    public List<Major> findAll() throws SQLException {
        return majorService.findAll();
    }
    public boolean checkExistsId(int id) throws SQLException {
        return majorService.checkExistsId(id);
    }
}
