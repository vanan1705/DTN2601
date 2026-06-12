package org.example.backend.service.impl;

import org.example.backend.repository.ILecturerRepository;
import org.example.backend.repository.IMajorRepository;
import org.example.backend.repository.impl.LecturerRepositoryImpl;
import org.example.backend.repository.impl.MajorRepositoryImpl;
import org.example.backend.service.ILecturerService;
import org.example.backend.service.IMajorService;
import org.example.entity.Lecturer;
import org.example.entity.Major;

import java.sql.SQLException;
import java.util.List;

public class MajorServiceImpl implements IMajorService {
    IMajorRepository majorRepository = new MajorRepositoryImpl();
    @Override
    public List<Major> findAll() throws SQLException {
        return majorRepository.findAll();
    }

    @Override
    public boolean checkExistsId(int id) throws SQLException {
        return majorRepository.checkExistsId(id);
    }
}
