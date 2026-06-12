package org.example.backend.service.impl;

import org.example.backend.repository.IStudentRepository;
import org.example.backend.repository.impl.StudentRepositoryImpl;
import org.example.backend.service.IStudentService;
import org.example.entity.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl  implements IStudentService {
    IStudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean create(String full_name, String email, Date dateOfBirth, int major_id) throws SQLException {
        return studentRepository.create(full_name, email, dateOfBirth, major_id);
    }

    @Override
    public boolean checkExistsEmail(String email) throws SQLException {
        return studentRepository.checkExistsEmail(email);
    }

    @Override
    public boolean checkExistsId(int id) throws SQLException {
        return studentRepository.checkExistsId(id);
    }

    @Override
    public boolean updateMajor(int studentId, int majorId) throws SQLException {
        return studentRepository.updateMajor(studentId,majorId );
    }

    @Override
    public List<Student> findByMajor(String majorName) throws SQLException {
        return studentRepository.findByMajor(majorName);
    }

    @Override
    public boolean deleteById(int studentId) throws SQLException {
        return studentRepository.deleteById(studentId);
    }
}
