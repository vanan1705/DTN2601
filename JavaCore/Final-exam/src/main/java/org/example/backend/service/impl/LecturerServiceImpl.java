package org.example.backend.service.impl;

import org.example.backend.repository.ILecturerRepository;
import org.example.backend.repository.impl.LecturerRepositoryImpl;
import org.example.backend.service.ILecturerService;
import org.example.entity.Lecturer;

import java.sql.SQLException;

public class LecturerServiceImpl implements ILecturerService {
    ILecturerRepository lecturerRepository = new LecturerRepositoryImpl();
    @Override
    public Lecturer findById(int id) throws SQLException {
        return lecturerRepository.findById(id);
    }
}
