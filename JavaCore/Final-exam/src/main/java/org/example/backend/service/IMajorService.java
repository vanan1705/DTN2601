package org.example.backend.service;

import org.example.entity.Major;

import java.sql.SQLException;
import java.util.List;

public interface IMajorService {
    List<Major> findAll() throws SQLException;
    boolean checkExistsId(int id) throws SQLException;
}
