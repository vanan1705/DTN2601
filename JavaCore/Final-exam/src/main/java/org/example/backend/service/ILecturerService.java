package org.example.backend.service;

import org.example.entity.Lecturer;

import java.sql.SQLException;

public interface ILecturerService {
    Lecturer findById(int id) throws SQLException;
}
