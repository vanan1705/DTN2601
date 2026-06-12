package org.example.backend.repository;

import org.example.entity.Lecturer;
import org.example.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface ILecturerRepository {
    Lecturer findById(int id) throws SQLException;
}
