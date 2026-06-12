package org.example.backend.controller;

import org.example.backend.service.ILecturerService;
import org.example.backend.service.impl.LecturerServiceImpl;
import org.example.entity.Lecturer;

import java.sql.SQLException;

public class LecturerController {
    ILecturerService lecturerService =new LecturerServiceImpl();
    public Lecturer findById(int id) throws SQLException {
        return lecturerService.findById(id);
    }
}
