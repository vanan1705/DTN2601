package org.example.backend.controller;

import org.example.backend.service.IStudentService;
import org.example.backend.service.impl.StudentServiceImpl;
import org.example.entity.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentController {
    IStudentService studentService = new StudentServiceImpl();

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public boolean create(String full_name, String email, Date dateOfBirth, int major_id) throws SQLException {
        return studentService.create(full_name, email, dateOfBirth, major_id);
    }

    public boolean checkExistsEmail(String email) throws SQLException {
        return studentService.checkExistsEmail(email);
    }

    public boolean checkExistsId(int id) throws SQLException {
        return studentService.checkExistsId(id);
    }

    public boolean updateMajor(int studentId, int majorId) throws SQLException {
        return studentService.updateMajor(studentId,majorId );
    }

    public List<Student> findByMajor(String majorName) throws SQLException {
        return studentService.findByMajor(majorName);
    }

    public boolean deleteById(int studentId) throws SQLException {
        return studentService.deleteById(studentId);
    }
}
