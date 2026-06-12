package org.example.backend.repository;

import org.example.entity.Major;

import java.sql.SQLException;
import java.util.List;

public interface IMajorRepository {
    List<Major> findAll() throws SQLException;
    boolean checkExistsId(int id) throws SQLException;
}
