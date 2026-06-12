package org.example.backend.service;

import org.example.entity.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean create(String full_name, String email, Date dateOfBirth, int major_id) throws SQLException;
    boolean checkExistsEmail(String email) throws SQLException;
    boolean checkExistsId(int id) throws SQLException;
    boolean updateMajor(int studentId, int majorId) throws SQLException;
    List<Student> findByMajor(String majorName) throws SQLException;
    boolean deleteById(int studentId) throws SQLException;

}
