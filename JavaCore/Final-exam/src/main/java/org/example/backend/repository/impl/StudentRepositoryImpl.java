package org.example.backend.repository.impl;

import org.example.backend.repository.IStudentRepository;
import org.example.entity.Account;
import org.example.entity.Major;
import org.example.entity.Student;
import org.example.utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        // câu lệnh lấy ra toàn bộ thông tin của sinh viên
        String sql =
                "SELECT s.student_id,\n" +
                        "               s.full_name,\n" +
                        "               s.email,\n" +
                        "               s.date_of_birth,\n" +
                        "               m.major_id,\n" +
                        "               m.major_name\n" +
                        "        FROM Student s\n" +
                        "        LEFT JOIN Major m\n" +
                        "        ON s.major_id = m.major_id";

        try (
                Connection connection = DBConnect.getConnection();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);

        ) {

            while (resultSet.next()) {

                Student student =
                        new Student();

                student.setStudentId(
                        resultSet.getInt(
                                "student_id"
                        )
                );

                student.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );

                student.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );

                student.setDateOfBirth(
                        resultSet.getDate(
                                "date_of_birth"
                        )
                );

                Major major =new Major();
                major.setMajorId( resultSet.getInt(
                        "major_id"
                ));

                major.setMajorName( resultSet.getString(
                        "major_name"
                ));
                student.setMajor(major);

                students.add(student);
            }
            DBConnect.close(connection, statement, resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean create(String full_name, String email, Date dateOfBirth, int major_id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = DBConnect.getConnection();

            String sql = "INSERT INTO Student(\n" +
                    "            full_name,\n" +
                    "            email,\n" +
                    "            date_of_birth,\n" +
                    "            major_id\n" +
                    "            )\n" +
                    "            VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, full_name);
            preparedStatement.setString(2, email);
            preparedStatement.setDate(3, (java.sql.Date) dateOfBirth);
            preparedStatement.setInt(4, major_id);

            int c = preparedStatement.executeUpdate();
            return  (c > 0);
        } catch (Exception   e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(
                    connection,
                    preparedStatement,
                    null
            );
        }
        return false;
    }

    @Override
    public boolean checkExistsEmail(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean checkExist = false;
        try {

            connection = DBConnect.getConnection();
            String sql = "select * from Student where email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                checkExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(connection, statement, resultSet);
        }
        return checkExist;
    }


    @Override
    public boolean checkExistsId(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean checkExist = false;
        try {

            connection = DBConnect.getConnection();
            String sql = "select * from Student where student_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                checkExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(connection, statement, resultSet);
        }
        return checkExist;
    }

    @Override
    public boolean updateMajor(int studentId, int majorId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DBConnect.getConnection();
            String sql = "UPDATE Student\n" +
                    "            SET major_id = ?\n" +
                    "            WHERE student_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, majorId);
            statement.setInt(2, studentId);
            int c = statement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(connection, statement, null);
        }
        return false;
    }

    @Override
    public List<Student> findByMajor(String majorName) throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // câu lệnh tìm kiếm sinh viên theo tên của môn học
        String sql =
                "SELECT s.student_id,\n" +
                        "       s.full_name,\n" +
                        "       s.email,\n" +
                        "       s.date_of_birth,\n" +
                        "       m.major_id,\n" +
                        "       m.major_name\n" +
                        "FROM Student s\n" +
                        "JOIN Major m\n" +
                        "ON s.major_id = m.major_id\n" +
                        "WHERE m.major_name = ?";

        try {
                connection = DBConnect.getConnection();
                statement = connection.prepareStatement(sql);
                statement.setString(1, majorName);
                resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {

                Student student =
                        new Student();

                student.setStudentId(
                        resultSet.getInt(
                                "student_id"
                        )
                );

                student.setFullName(
                        resultSet.getString(
                                "full_name"
                        )
                );

                student.setEmail(
                        resultSet.getString(
                                "email"
                        )
                );

                student.setDateOfBirth(
                        resultSet.getDate(
                                "date_of_birth"
                        )
                );

                Major major =new Major();
                major.setMajorId( resultSet.getInt(
                        "major_id"
                ));

                major.setMajorName( resultSet.getString(
                        "major_name"
                ));
                student.setMajor(major);

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBConnect.close(connection, statement, resultSet);
        }
        return students;
    }
    @Override
    public boolean deleteById(int studentId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DBConnect.getConnection();
            String sql = "DELETE FROM Student\n" +
                    "            WHERE student_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, studentId);
            int c = statement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnect.close(connection, statement, null);
        }
        return false;
    }

}
